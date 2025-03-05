package com.Library.managment.Model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
@Table(name="orders")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="customer_id",nullable = false)
    private Customer customer;
    @OneToMany
    private List<Book> books;
    @Column(name="order_date")
    private Date order_date;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }
}
