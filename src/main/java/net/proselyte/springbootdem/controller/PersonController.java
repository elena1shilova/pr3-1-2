package net.proselyte.springbootdem.controller;

import net.proselyte.springbootdem.model.Person;
import net.proselyte.springbootdem.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PersonController {

    private PersonService personService;

    @GetMapping("/persons")
    public String findAll(Model model) {
        List<Person> person = personService.findAll();
        model.addAttribute("person", person);
        return "index";
    }


}
