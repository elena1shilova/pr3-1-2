package net.proselyte.springbootdem.controller;
import net.proselyte.springbootdem.models.Person;
import net.proselyte.springbootdem.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class PeopleController {

    private final PersonService personService;

    @Autowired
    public PeopleController(PersonService personService) {

        this.personService = personService;
    }
    @GetMapping("/persons")
    public String index(Model model) {
        List<Person> persons = personService.index();
        model.addAttribute("persons", persons);
        return "index";
    }
    @GetMapping("/person-create")
    public String createPersonForm(Person person) {
        return "person-create";
    }
    @PostMapping("/person-create")
    public String createPerson(Person person) {
        personService.save(person);
        return "redirect:/persons";
    }
    @GetMapping("person-delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        personService.delete(id);
        return "redirect:/persons";
    }
    @GetMapping("person-update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        Person person = personService.show(id);
        model.addAttribute("person", person);
        return "person-update";
    }
    @PostMapping("/person-update")
    public String update(Person person) {
        personService.save(person);
        return "redirect:/persons";
    }
}
