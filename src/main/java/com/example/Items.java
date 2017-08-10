package com.example;

import java.io.Serializable;
import java.util.ArrayList;

public class Items implements Serializable {
    private String name;
    private Integer count;
    private Double price;
    private Integer id;
    private ArrayList alias;

    public Items() {

    }

    public Items(String name, Integer count, Double price, Integer id, ArrayList alias) {
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAlias(ArrayList alias) {
        this.alias = alias;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public Double getPrice() {
        return price;
    }

    public ArrayList getAlias() {
        return alias;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", alias=" + alias +
                '}';
    }

}
