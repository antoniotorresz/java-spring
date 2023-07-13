package com.antonio.HolaSpring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import java.util.Arrays;

@Controller
@Slf4j
public class IndexController {

    @Value("${index.saludo}") //para leer una variable desde application.properties
    private String saludo;
    @GetMapping("/")
    public String index(Model model)
    {
        log.info("ejecutando controlador spring mvc");
        String mensaje = "Hola mundo con si amigo mio";
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("perez");
        persona.setEmail("jperez@gmail.com");
        persona.setTelefono("1234567890");

        Persona persona1 = new Persona();
        persona1.setNombre("karla");
        persona1.setApellido("Gonzalez");
        persona1.setEmail("karlaglez@gmail.com");
        persona1.setTelefono("2309478210");

        var personas = Arrays.asList(persona, persona1);

        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);

        return "index";
    }
}
