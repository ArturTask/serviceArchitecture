package itmo.soa.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ErrorController {

    @GetMapping(value = "/error")
    public String error(){
        return "Error page";
    }

}
