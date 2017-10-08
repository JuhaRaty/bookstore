package fi.hh.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import fi.hh.bookstore.domain.BookRepository;

@Controller
public class BookController {
	
    @Autowired
    private BookRepository repository;
	
    /*@RequestMapping(value="/index")
    public String index() {
        return "Moi";
    }*/
    
    @RequestMapping(value="booklist")
    public String books(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
}
