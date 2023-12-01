package com.kaiky.taticstftools.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.kaiky.taticstftools.model.UserModel;
import java.util.List;


public interface UserRepository extends MongoRepository<UserModel, String> {
    @Query("('username' : ?0)")
    UserModel findByUsername(String username);
}
