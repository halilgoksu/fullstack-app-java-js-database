package com.revature.CreateLogin.data;

import com.revature.CreateLogin.entity.Person;

public interface PersonDao {
    public Person insert (Person person);
    public Person getById(int id);
}
