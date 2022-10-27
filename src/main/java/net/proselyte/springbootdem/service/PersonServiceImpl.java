package net.proselyte.springbootdem.service;
import net.proselyte.springbootdem.models.Person;
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
    public Person show(Long id) {
        return personRepository.findById(id).orElse(null);
    }
    @Override
    public List<Person> index() {
        return personRepository.findAll();
    }
    @Override
    public  Person save(Person person) {
        return personRepository.save(person);
    }
    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }
    /*@Override
    public List<Person> index() {
        return personRepository.findAll();
    }

    @Override
    public Person show(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }


//    public void update(Long id, Person updatePerson) {
//        personRepository.update(id, updatePerson);
//    }
    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }*/
   // spring.mvc.hiddenmethod.filter.enabled=true
}
