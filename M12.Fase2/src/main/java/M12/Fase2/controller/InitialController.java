package M12.Fase2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class InitialController {

    
    // *******************FASE 2 *************************************//
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }
    
    @GetMapping("/{nom}")
    public String helloWorld(@PathVariable(name="nom") String nom) {
        return "Hello "+ nom;
    }
    // *************************************************************//

}
