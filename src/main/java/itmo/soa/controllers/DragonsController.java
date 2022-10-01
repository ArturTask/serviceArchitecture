package itmo.soa.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/dragons")
@CrossOrigin(origins = "http://localhost:3000")
public class DragonsController {

    @GetMapping()
    public String[] getAllDragons(){
        return new String[]{"fd", "ddd"};
    }

    @PostMapping()
    public String[] addNewDragon(){
        return new String[]{"fd", "ddd"};
    }

    @PutMapping()
    public String[] updateDragon(){
        return new String[]{"fd", "ddd"};
    }

    @GetMapping(value = "/{id}")
    public String getDragonById(@PathVariable String id){
        return id;
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
