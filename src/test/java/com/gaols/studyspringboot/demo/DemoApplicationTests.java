package com.gaols.studyspringboot.demo;

import com.gaols.studyspringboot.demo.service.PersonService;
import com.sf.jfinal.qs.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    PersonService personService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSave() {
        Person person = personService.createPerson("gaols", 30, "test address");
        System.out.println(person.getId());
    }

    @Test
    public void testUpdate() {
        personService.updatePersonName(16, "gaols3");
        System.out.println(Person.dao.findById(16).getName());
    }

    @Test
    public void testGet() {
        Person person = personService.findById(16);
        System.out.println(person.getName());
    }

}
