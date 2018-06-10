package com.sharebooks.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(path="/addBook")
    public String addBook() {
        // This returns a JSON or XML with the users
        return "addbook";
    }

    @GetMapping(path="/")
    public String getAllBooks(Model model) {
        // This returns a JSON or XML with the users
        System.out.println(bookRepository);
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "explore";
    }

    @PostMapping(path="/add") // Map ONLY GET Requests
    public String addBook (@RequestParam String name, @RequestParam Integer year, @RequestParam String bookCondition,
                                         @RequestParam Double originalPrice, @RequestParam Double rentalPrice, @RequestParam String notes) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Book book = new Book();
        book.setName(name);
        book.setUserId(1);
        book.setYearBought(year);
        book.setBookCondition(bookCondition);
        book.setOriginalPrice(originalPrice);
        book.setRentalPrice(rentalPrice);
        book.setNotes(notes);
        book.setStatus("Available");
        bookRepository.save(book);
        return "home";
    }
}
