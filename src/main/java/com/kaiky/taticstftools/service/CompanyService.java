package com.kaiky.taticstftools.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaiky.taticstftools.model.CompanyModel;
import com.kaiky.taticstftools.repository.CompanyRepository;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public void save(CompanyModel companyModel) {
        this.companyRepository.save(companyModel);
    }

    public List<CompanyModel> findAll() {
        return this.companyRepository.findAll();
    }

    public List<CompanyModel> findByUserID(String userId) {
        return this.companyRepository.findByUserID(userId);
    }

    public void delete(String id) {
        this.companyRepository.deleteById(id);
    }

}
