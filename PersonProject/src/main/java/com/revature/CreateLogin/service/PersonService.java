package com.revature.CreateLogin.service;

import com.revature.CreateLogin.data.DaoFactory;
import com.revature.CreateLogin.data.PersonDao;
import com.revature.CreateLogin.entity.Person;

// Service classes contain business logic of what's going on:
public class PersonService {

    // we take in a Ticket object with just name and password
    public Person register(Person person) {
        // we want to send back data from database
        // inserting this new person into the database:
        PersonDao personDao = DaoFactory.getPersonDao();
        Person person1 = personDao.insert(person);
        return person1;
    }

    // return a person object if the id and password match what's in the database
    // otherwise, we can return null:
    public Person login(int id, String password,String stafftype) {
        // business logic where we check the password:
        // first let's get the person from the database:
        PersonDao personDao = DaoFactory.getPersonDao();
        Person person = personDao.getById(id);
        if (password.equals(person.getPassword())) {
            // if they match, we return the person
            return person;
        }
        // if passwords don't match, return null, indicating that the password is incorrect
        return null;
    }

}
