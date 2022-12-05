package com.trung.tamjava.master.Demospring.controller;

import com.trung.tamjava.master.Demospring.entity.Laptop;
import com.trung.tamjava.master.Demospring.entity.Person;
import com.trung.tamjava.master.Demospring.repository.PersonRepo;
import com.trung.tamjava.master.Demospring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {
    List<Person> persons = new ArrayList<>();


    @Autowired
    PersonRepo personRepo;

    @Autowired
    @Qualifier("laptop2") // khi có nhiều thằng trùng kiểu thì dùng để phân biệt
    Laptop laptop;

    @Autowired
    PersonService personService;

    @GetMapping("/create")
    public String create() {
        System.out.println(laptop.getId() + laptop.getName());
        return "person/create.html";
    }


    @PostMapping("/create")
    public String create(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("age") int age) {
        Person p = new Person();
        p.setId(id);
        p.setName(name);
        p.setAge(age);

        persons.add(p);

        //save to db
        personRepo.save(p);

        //chuyen huong redirect:
        return "redirect:/person/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Person> persons = personService.getAll();
        model.addAttribute("list", persons);
        return "person/list.html";
    }

    @GetMapping("/search")
    public String search(@RequestParam("min") int min, @RequestParam("max") int max,
                         @RequestParam("page") int page, @RequestParam("size") int size, Model model) {
        Page<Person> personPage =
                personRepo.search(min, max, PageRequest.of(page, size));
        System.out.println(personPage.getTotalPages());
        System.out.println(personPage.getNumberOfElements());
        model.addAttribute("list", personPage.getContent());
        return "person/list.html";
    }



    @GetMapping("/delete")
    public String list(@RequestParam("id") int id) {
        personRepo.deleteById(id);
        return "redirect:/person/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {

        Person p = personRepo.findById(id).orElse(null);
        model.addAttribute("person", p);
        return "/person/edit.html";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Person p) {
        // save to db
        personRepo.save(p);

        return "redirect:/person/list";
    }
}
