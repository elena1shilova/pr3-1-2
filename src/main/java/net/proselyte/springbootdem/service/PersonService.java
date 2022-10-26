package net.proselyte.springbootdem.service;

import net.proselyte.springbootdem.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PersonService {
    public Person findById(Long id);

    public List<Person> findAll();

    public  Person savePerson(Person person);

    public void deleteById(Long id);
}
