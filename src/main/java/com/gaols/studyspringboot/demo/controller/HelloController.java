package com.gaols.studyspringboot.demo.controller;

import com.gaols.studyspringboot.demo.service.PersonService;
import com.sf.jfinal.qs.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    PersonService personService;

    @RequestMapping("hello")
    public Person hello() {
        return personService.findById(16);
    }
}
