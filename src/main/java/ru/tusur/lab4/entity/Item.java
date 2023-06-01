package ru.tusur.lab4.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "item")
@RequiredArgsConstructor
@Data
public class Item {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "price")
    @NonNull
    private double price;


    @Column(name = "category")
    private String category;

    @Column(name = "isbn")
    private long isbn;
    @Column(name = "description")
    private String description;

    public Item(long id, @NonNull String name, String category, long isbn, String description) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.isbn = isbn;
        this.description = description;
    }

    public Item() {

    }
}
