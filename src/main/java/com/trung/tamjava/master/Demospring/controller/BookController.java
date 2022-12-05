package com.trung.tamjava.master.Demospring.controller;

import com.trung.tamjava.master.Demospring.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    List<Book> books = new ArrayList<>();

    @GetMapping("/create-book")
    public String bookCreate() {
        return "book/book-create.html";
    }

    @PostMapping("/create-book")
    public String bookCreate(@RequestParam("id") int id,
                             @RequestParam("title") String title,
                             @RequestParam("price") int price) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setPrice(price);

        books.add(book); //add tam vao list

        //chuyen huong
        return "redirect:/book/list-book";
    }

    @GetMapping("/list-book")
    public String listBook(Model model) {
        model.addAttribute("listbook", books);
        return "book/list-book.html";
    }
}
