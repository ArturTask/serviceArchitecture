package itmo.soa.controllers;

import itmo.soa.dto.*;
import itmo.soa.services.DragonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/dragons")
@CrossOrigin(origins = "http://localhost:3000")
public class DragonsController extends BaseConroller{

    @Autowired
    DragonsService dragonsService;

    @GetMapping()
    public ResponseEntity<AllDragonsDto> getAllDragons(){
        return new ResponseEntity<>(new AllDragonsDto(dragonsService.getAllDragons()), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<DragonDto> addNewDragon(@RequestBody DragonDto dragonDto) throws InstantiationException {
        return new ResponseEntity<>(dragonsService.addNewDragon(dragonDto), HttpStatus.OK);

    }

    @PutMapping()
    public ResponseEntity<DragonDto> updateDragon(@RequestBody DragonDto dragonDto) throws InstantiationException, NullPointerException {
        return new ResponseEntity<>(dragonsService.updateDragon(dragonDto), HttpStatus.OK);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DragonDto> getDragonById(@PathVariable String id) throws IllegalArgumentException, NullPointerException{
        return new ResponseEntity<>(dragonsService.getDragonById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}") //@DeleteMapping(value = "/{id:[\\d]+}") - only allows delete mapping with numeric id!! => /dragons/f - another controller
    public ResponseEntity<DefaultDto> deleteDragonById(@PathVariable String id) throws NullPointerException, IllegalArgumentException {
        dragonsService.deleteDragonById(id);
        return new ResponseEntity<>(new DefaultDto(HttpStatus.OK.value(), "Successful Operation"), HttpStatus.OK);
    }

    /*business logic*/
    @PostMapping(value = "/age/average", produces = "text/plain;charset=UTF-8")
    public ResponseEntity<AgeDto> getAverageAge(){
        return new ResponseEntity<>(dragonsService.getAverageAge(), HttpStatus.OK);
    }

    @PostMapping(value = "/age/less/{age}")
    public ResponseEntity<AllDragonsDto> getDragonsAgeLessThan(@PathVariable String age){

        return new ResponseEntity<>(new AllDragonsDto(dragonsService.getDragonsAgeLessThan(age)), HttpStatus.OK);
    }

    @PostMapping(value = "/name/{name}")
    public String getDragonByName(@PathVariable String name){
        return name;
    }

    /*exception handlers*/

    @ExceptionHandler({NullPointerException.class })
    public ResponseEntity<ErrorDto> handleNullPointerException() {
        return new ResponseEntity<>(new ErrorDto(HttpStatus.NOT_FOUND.value(), "Dragon not found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<ErrorDto> handleIllegalArgumentException() {
        return new ResponseEntity<>(new ErrorDto(HttpStatus.METHOD_NOT_ALLOWED.value(), "Invalid id supplied"), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler({NumberFormatException.class})
    public ResponseEntity<ErrorDto> handleNumberFormatException() {
        return new ResponseEntity<>(new ErrorDto(HttpStatus.METHOD_NOT_ALLOWED.value(), "Invalid age supplied"), HttpStatus.METHOD_NOT_ALLOWED);
    }



}
