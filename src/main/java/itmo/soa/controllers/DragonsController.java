package itmo.soa.controllers;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import itmo.soa.dto.AllDragons;
import itmo.soa.dto.DragonDto;
import itmo.soa.dto.ErrorDto;
import itmo.soa.entity.Dragon;
import itmo.soa.services.DragonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dragons")
@CrossOrigin(origins = "http://localhost:3000")
public class DragonsController extends BaseConroller{

    @Autowired
    DragonsService dragonsService;

    @GetMapping()
    public ResponseEntity<AllDragons> getAllDragons(){
        return new ResponseEntity<>(new AllDragons(dragonsService.getAllDragons()), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<DragonDto> addNewDragon(@RequestBody DragonDto dragonDto) throws InstantiationException {
        return new ResponseEntity<>(dragonsService.addNewDragon(dragonDto), HttpStatus.OK);

    }

    @PutMapping()
    public String[] updateDragon(){
        return new String[]{"fd", "ddd"};
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DragonDto> getDragonById(@PathVariable String id) throws IllegalArgumentException, NullPointerException{
        return new ResponseEntity<>(dragonsService.getDragonById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id:[\\d]+}")
    public String deleteDragonById(@PathVariable String id){
        return id;
    }

    /*business logic*/
    @PostMapping(value = "/age/average", produces = "text/plain;charset=UTF-8")
    public String getAverageAge(){
        return "0";
    }

    @PostMapping(value = "/age/less/{id:[\\d+]}")
    public String getAgeLessThan(@PathVariable int id){
        return String.valueOf(id);
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
        return new ResponseEntity<>(new ErrorDto(HttpStatus.METHOD_NOT_ALLOWED.value(), "Wrong input values"), HttpStatus.METHOD_NOT_ALLOWED);
    }



}
