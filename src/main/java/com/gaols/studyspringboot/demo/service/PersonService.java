package com.gaols.studyspringboot.demo.service;

import com.jfinal.plugin.activerecord.Db;
import com.sf.jfinal.qs.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

    public Person findById(int id) {
        return Person.dao.findById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public Person createPerson(String name, int age, String address) {
        Person person = new Person();
        person.setName(name);
        person.setAddress(address);
        person.setAge(age);
        person.save();
        return person;
    }

    @Transactional(rollbackFor = Exception.class)
    public void updatePersonName(int id, String newName) {
        Db.update("update person set name=? where id=?", newName, id);
    }
}
