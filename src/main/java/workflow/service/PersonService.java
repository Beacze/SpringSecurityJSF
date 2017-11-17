package workflow.service;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.annotation.Secured;

import workflow.bean.Person;

public class PersonService {

    /**
     * Find person by id.
     */
    public Person findById(Integer id) {
        return new Person();
    }

    /**
     * Find persons.
     */
    public Collection<Person> find() {
        return null;
    }

    /**
     * Saves person.
     */
    public Person save(Person person) {
        return person;
    }

    /**
     * Deletes person.
     */
    @Secured({"ADMIN"})
    public void delete(Person person) {

    }

    @Secured({"ADMIN"})
    public void delete(Integer id) {

    }

}
