package com.alex.library.contoller;

import com.alex.library.dao.BookDAO;
import com.alex.library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookDAO bookDAO;

    @Autowired
    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String indexBook(Model model){
        model.addAttribute(bookDAO.index());
        return "book/index";
    }

    @GetMapping("/{id}")
    public String showBook(@PathVariable("id") int id, Model model){
        model.addAttribute(bookDAO.show(id));
        return "book/show";
    }

    @GetMapping("/new")
    public String newBook( @Valid Book book){  // @ModelAttribute("book"),

        return "book/new";
    }

    @PostMapping()
    public String createBook(@Valid Book book){
        bookDAO.save(book);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String editBook(@PathVariable("id") int id, Model model){
        model.addAttribute(bookDAO.show(id));
        return "book/edit";
    }

    @PostMapping("/{id}")
    public String updateBook(@PathVariable("id") int id, @Valid Book book){
        bookDAO.update(id, book);
        return "redirect:/book";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookDAO.delete(id);
        return "redirect:/book";
    }





}
