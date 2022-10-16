package itmo.soa.controllers;

import itmo.soa.dto.AllDragonCavesDto;
import itmo.soa.services.DragonCavesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/caves")
@CrossOrigin(origins = "http://localhost:8081")
public class DragonCavesController {

    @Autowired
    DragonCavesService dragonCavesService;

    @GetMapping()
    public ResponseEntity<AllDragonCavesDto> getCaves() {
        return new ResponseEntity<>(new AllDragonCavesDto(dragonCavesService.getCaves()), HttpStatus.OK);
    }
}
