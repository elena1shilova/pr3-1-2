package net.proselyte.springbootdem.repository;

import net.proselyte.springbootdem.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
