package itmo.soa.controllers;

import itmo.soa.dto.AllDragons;
import itmo.soa.dto.DragonDto;
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
public class DragonsController {

    @Autowired
    DragonsService dragonsService;

    @GetMapping()
    public ResponseEntity<AllDragons> getAllDragons(){
        return new ResponseEntity<>(new AllDragons(dragonsService.getAllDragons()), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<DragonDto> addNewDragon(@RequestBody DragonDto dragonDto){
        try {
            return new ResponseEntity<>(dragonsService.addNewDragon(dragonDto), HttpStatus.OK);
        } catch (InstantiationException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping()
    public String[] updateDragon(){
        return new String[]{"fd", "ddd"};
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DragonDto> getDragonById(@PathVariable String id){
        try {
            return new ResponseEntity<>(dragonsService.getDragonById(id), HttpStatus.OK);
        } catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id:[\\d]+}")
    public String deleteDragonById(@PathVariable String id){
        return id;
    }

//    business logic
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





}
