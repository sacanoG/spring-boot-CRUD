package co.com.sancanoga.calculatorsalary.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @CrossOrigin
    @GetMapping(produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResponseEntity<String> consult(){
        return new ResponseEntity<>("Bienvenido a mi Compañia", HttpStatus.OK);
    }
}

