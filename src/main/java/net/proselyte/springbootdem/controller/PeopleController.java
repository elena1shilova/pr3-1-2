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
    /*@GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personService.index());
        return "index";
    }
//@GetMapping("/people")
//public String index(Model model) {
//    List<Person> persons = personService.index();
//    model.addAttribute("persons", persons);
//    return "index";
//}

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("person", personService.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") Person person, //@Valid
                         org.springframework.validation.BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";
        personService.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id){
        model.addAttribute("person", personService.show(id));
        return "edit";
    }
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("person") Person person, // @Valid
//                         org.springframework.validation.BindingResult bindingResult, @PathVariable("id") Long id) {
//        if (bindingResult.hasErrors())
//            return "edit";
//        personService.update(id, person);
//        return "redirect:/people";
//    }
@PatchMapping("/{id}")
public String update(@ModelAttribute("person") Person person, // @Valid
                     org.springframework.validation.BindingResult bindingResult, @PathVariable("id") Long id) {
    if (bindingResult.hasErrors())
        return "edit";
    personService.save(person);
    return "redirect:/people";
}

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        personService.delete(id);
        return "redirect:/people";
    }*/
}
