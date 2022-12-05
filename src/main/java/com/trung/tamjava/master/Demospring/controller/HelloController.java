package com.trung.tamjava.master.Demospring.controller;

import com.trung.tamjava.master.Demospring.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller // tra ve view
//@RestController // ko co view
@RequestMapping("/api") // /api trc roi den cac duong dan con o duoi
public class HelloController {

    // localhost:8080/api/hello-spring
    @GetMapping("/hello-spring")
    public String hello(Model model) {
        model.addAttribute("msg", "hello spring framekork");
        new Person();
        return "hi.html"; // view
    }
}
