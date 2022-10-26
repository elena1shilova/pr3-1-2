package net.proselyte.springbootdem.service;

import net.proselyte.springbootdem.model.Person;
import net.proselyte.springbootdem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).orElse(null);
    }
    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }
    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }
    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
