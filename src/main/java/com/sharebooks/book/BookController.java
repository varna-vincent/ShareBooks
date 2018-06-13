package com.sharebooks.book;

import com.sharebooks.user.User;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(path="/addBook")
    public String addBook(HttpServletRequest request, Model model) {
        // This returns a JSON or XML with the users
        model.addAttribute("user", request.getSession().getAttribute("user"));
        return "addbook";
    }
    @GetMapping(path="/mybooks")
    public String getBooksByUser(HttpServletRequest request, Model model) {
        // This returns a JSON or XML with the users
        User user = (User) request.getSession().getAttribute("user");
        List<Book> books = bookRepository.findByUser(user);
        model.addAttribute("books", books);
        model.addAttribute("user", request.getSession().getAttribute("user"));
        return "mybooks";
    }

    @GetMapping(path="/")
    public String getAllBooks(HttpServletRequest request, Model model) {
        // This returns a JSON or XML with the users
        System.out.println(bookRepository);
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        model.addAttribute("user", request.getSession().getAttribute("user"));
        return "explore";
    }

    @PostMapping(path="/add") // Map ONLY GET Requests
    public String addBook (HttpServletRequest request, @RequestParam String name, @RequestParam Integer year, @RequestParam String bookCondition,
                                         @RequestParam Double originalPrice, @RequestParam Double rentalPrice, @RequestParam String notes, @RequestParam("image") MultipartFile image) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        try {

            Book book = new Book();
            book.setName(name);
            book.setUser((User) request.getSession().getAttribute("user"));
            book.setYearBought(year);
            book.setBookCondition(bookCondition);
            book.setOriginalPrice(originalPrice);
            book.setRentalPrice(rentalPrice);
            book.setNotes(notes);
            book.setImage(Base64.encodeBase64String(image.getBytes()));
            book.setStatus("Available");

            bookRepository.save(book);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "explore";
    }

    @RequestMapping(value="/borrow/{id}")
    public String showBorrowForm(HttpServletRequest request, @PathVariable("id") long id, Model model) {

        Optional<Book> result = bookRepository.findById(id);
        Book book = result.get();
        model.addAttribute("book", book);
        model.addAttribute("user", request.getSession().getAttribute("user"));
        System.out.println(book);
        return "borrow";
    }
}
