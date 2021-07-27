package M12.Nivel3.Controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class Nivel3Controller {

    // *******************FASE 2 *************************************////
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }
    
    @GetMapping("/{nom}")
    public String helloWorld(@PathVariable(name="nom") String nom) {
        return "Hello "+ nom;
    }
    // *************************************************************////


}
