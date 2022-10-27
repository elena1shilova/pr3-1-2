package net.proselyte.springbootdem.service;
import net.proselyte.springbootdem.models.Person;
import java.util.List;

public interface PersonService {

    public Person show(Long id);

    public List<Person> index();

    public  Person save(Person person);

    public void delete(Long id);

}
