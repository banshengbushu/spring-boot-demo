package com.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
    public String id;
    public String name;
    public String age;

    public User() {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
