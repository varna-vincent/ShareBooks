package com.sharebooks.book;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Integer userId;
    private String name;
    private Integer yearBought;
    private String bookCondition;
    private Double originalPrice;
    private Double rentalPrice;
    private String notes;
    private byte[] image;
    private DateTime borrowedDateFrom;
    private DateTime borrowedDateTo;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearBought() {
        return yearBought;
    }

    public void setYearBought(Integer yearBought) {
        this.yearBought = yearBought;
    }

    public String getBookCondition() {
        return bookCondition;
    }

    public void setBookCondition(String bookCondition) {
        this.bookCondition = bookCondition;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(Double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public DateTime getBorrowedDateFrom() {
        return borrowedDateFrom;
    }

    public void setBorrowedDateFrom(DateTime borrowedDateFrom) {
        this.borrowedDateFrom = borrowedDateFrom;
    }

    public DateTime getBorrowedDateTo() {
        return borrowedDateTo;
    }

    public void setBorrowedDateTo(DateTime borrowedDateTo) {
        this.borrowedDateTo = borrowedDateTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
