package com.kaiky.taticstftools.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document("User")
public class UserModel {
    @Id private String id;
    private String name;
    private short age;

    public UserModel(String name, Short age) {
        this.name = name;
        this.age = age;
    }

    public UserModel(String id) {
        this.id = id;
    }

    public UserModel() {
        
    }
}
