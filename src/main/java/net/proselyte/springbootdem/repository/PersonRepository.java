package net.proselyte.springbootdem.repository;

import net.proselyte.springbootdem.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    //List<Person> findBySurname(String surname);
}
