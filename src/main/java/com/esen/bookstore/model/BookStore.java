package com.esen.bookstore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;


@Entity
public class BookStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private Double placeModifier;
    private Double moneyInCashRegister;

    @ElementCollection(fetch = FetchType.EAGER)
    private Map<Book, Integer> inventory;

    public BookStore() {
    }

    public BookStore(Long id, String location, Double placeModifier, Double moneyInCashRegister, Map<Book, Integer> inventory) {
        this.id = id;
        this.location = location;
        this.placeModifier = placeModifier;
        this.moneyInCashRegister = moneyInCashRegister;
        this.inventory = inventory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getPlaceModifier() {
        return placeModifier;
    }

    public void setPlaceModifier(Double placeModifier) {
        this.placeModifier = placeModifier;
    }

    public Double getMoneyInCashRegister() {
        return moneyInCashRegister;
    }

    public void setMoneyInCashRegister(Double moneyInCashRegister) {
        this.moneyInCashRegister = moneyInCashRegister;
    }

    public Map<Book, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(Map<Book, Integer> inventory) {
        this.inventory = inventory;
    }
}
