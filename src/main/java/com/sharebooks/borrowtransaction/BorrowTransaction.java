package com.sharebooks.borrowtransaction;

import com.sharebooks.book.Book;
import com.sharebooks.user.User;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "borrow_transactions")
public class BorrowTransaction {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @OneToOne
    private Book book;
    @OneToOne
    private User lender;
    @OneToOne
    private User borrower;
    private Double price;
    private Date borrowedDateFrom;
    private Date borrowedDateTo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getLender() {
        return lender;
    }

    public void setLender(User lender) {
        this.lender = lender;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getBorrowedDateFrom() {
        return borrowedDateFrom;
    }

    public void setBorrowedDateFrom(Date borrowedDateFrom) {
        this.borrowedDateFrom = borrowedDateFrom;
    }

    public Date getBorrowedDateTo() {
        return borrowedDateTo;
    }

    public void setBorrowedDateTo(Date borrowedDateTo) {
        this.borrowedDateTo = borrowedDateTo;
    }
}
