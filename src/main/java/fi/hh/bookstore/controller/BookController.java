package fi.hh.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.hh.bookstore.domain.Book;
import fi.hh.bookstore.domain.BookRepository;

@Controller
public class BookController {
	
    @Autowired
    private BookRepository repository;
	
    /*@RequestMapping(value="/index")
    public String index() {
        return "Moi";
    }*/
    
    @RequestMapping(value="booklist", method=RequestMethod.GET)
    public String books(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    
    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id, Model model) {
        repository.delete(id);
        return "redirect:/booklist";
    }
    
    @RequestMapping(value = "/addbook")
    public String addBook(Model model){
        model.addAttribute("book", new Book());
        return "addbook";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }
}
