package org.sebi;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring")
public class SpringResource {

    @ConfigProperty(name = "greeting")
    String greeting;

    @GetMapping("/hello")
    public String springHello(){
        return greeting + " from Spring !";
    }

}
