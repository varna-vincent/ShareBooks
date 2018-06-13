package com.sharebooks.borrowtransaction;

import com.sharebooks.book.Book;
import com.sharebooks.book.BookRepository;
import com.sharebooks.user.User;
import com.sharebooks.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Optional;

@Controller
public class BorrowTransactionController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowTransactionRepository borrowTransactionRepository;

    @Transactional
    @PostMapping(path="/borrow") // Map ONLY POST Requests
    public String borrowBook (HttpServletRequest request, @RequestParam Long bookId, @RequestParam Long userId, @RequestParam Double price,
                           @RequestParam("borrowedDateFrom") @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate,
                           @RequestParam("borrowedDateTo") @DateTimeFormat(pattern="yyyy-MM-dd") Date toDate) {

        try {
            if (bookRepository.setBorrowedDatesFor(fromDate, toDate, "Borrowed", bookId) > 0) {

                System.out.println("book borrowed");
                Book book = ((Optional<Book>) bookRepository.findById(bookId)).get();
                User lender = ((Optional<User>) userRepository.findById(userId)).get();

                BorrowTransaction borrowTransaction = new BorrowTransaction();
                borrowTransaction.setBook(book);
                borrowTransaction.setLender(lender);
                borrowTransaction.setBorrower((User) request.getSession().getAttribute("user"));
                borrowTransaction.setPrice(price);
                borrowTransaction.setBorrowedDateFrom(fromDate);
                borrowTransaction.setBorrowedDateTo(toDate);

                borrowTransactionRepository.save(borrowTransaction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/borrowhistory";
    }

    @GetMapping("/borrowhistory")
    public String getBorrowHistory(HttpServletRequest request, Model model) {

        User user = (User) request.getSession().getAttribute("user");
        Iterable<BorrowTransaction> borrowTransactions = borrowTransactionRepository.findByBorrower(user);
        model.addAttribute("borrowTransactions", borrowTransactions);
        model.addAttribute("user", request.getSession().getAttribute("user"));
        return "borrowhistory";
    }
}
