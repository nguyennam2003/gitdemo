package com.trung.tamjava.master.Demospring.service;

import com.trung.tamjava.master.Demospring.entity.Person;
import com.trung.tamjava.master.Demospring.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepo personRepo;

    public List<Person> getAll() {
        return personRepo.findAll();
    }
}
