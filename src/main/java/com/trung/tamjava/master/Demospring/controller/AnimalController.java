package com.trung.tamjava.master.Demospring.controller;

import com.trung.tamjava.master.Demospring.entity.Animal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/animal")
public class AnimalController {

    List<Animal> animals = new ArrayList<>();

    @GetMapping("/create-animal")
    public String createAnimal() {
        return "animal/create-animal.html";
    }

    @PostMapping("/create-animal")
    public String createAnimal(
            @RequestParam("id") int id,
            @RequestParam("name") String name
    ) {
        Animal animal = new Animal();
        animal.setId(id);
        animal.setName(name);

        animals.add(animal);

        return "redirect:/animal/list-animal";
    }

    @GetMapping("/list-animal")
    public String listAnimal(Model model) {
        model.addAttribute("listanimal", animals);
        return "animal/list-animal.html";
    }
}
