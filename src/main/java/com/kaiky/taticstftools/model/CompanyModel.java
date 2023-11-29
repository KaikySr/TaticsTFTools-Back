package com.kaiky.taticstftools.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("company")
public class CompanyModel {
    @Id
    private String id;
    private String username;
    @DBRef
    private UserModel idUser;
    @DBRef
    private List<UserModel> listUser;

    public CompanyModel(String id, String username) {
        this.id = id;
        this.username = username;
    }

    public CompanyModel(String name) {
        this.username = username;
    }

    public CompanyModel() {
    }
}
