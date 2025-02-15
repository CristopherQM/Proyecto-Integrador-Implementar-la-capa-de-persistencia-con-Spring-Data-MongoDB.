package com.example.Proyecto_final_bueno.entity;


import org.springframework.data.mongodb.core.mapping.Document;
@Document(collation = "users")

public class UserMongoEntity {
    private String id;

    private String name;

    private String email;


    public UserMongoEntity(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserMongoEntity() {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
