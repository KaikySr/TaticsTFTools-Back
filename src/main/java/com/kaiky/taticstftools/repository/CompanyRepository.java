package com.kaiky.taticstftools.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.kaiky.taticstftools.model.CompanyModel;

import java.util.List;

public interface CompanyRepository extends MongoRepository<CompanyModel, String> {
    // @Query("{'listUser.id': ?0 }")
    @Query("{'idUser.id': ?0 }")
    List<CompanyModel> findByUserID(String userId);

}
