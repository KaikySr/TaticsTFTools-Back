package com.kaiky.taticstftools.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaiky.taticstftools.dto.CompanyUserDTO;
import com.kaiky.taticstftools.model.CompanyModel;
import com.kaiky.taticstftools.model.UserModel;
import com.kaiky.taticstftools.service.CompanyService;
import com.kaiky.taticstftools.service.UserService;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;

    @PostMapping("")
    public void newUser(@RequestBody CompanyUserDTO newCompanyUserDTO) {
        CompanyModel newCompanyModel = new CompanyModel(newCompanyUserDTO.getCompany().getUsername());

        UserModel userResp = userService
                .save(new UserModel(newCompanyUserDTO.getUser().getUsername(), newCompanyUserDTO.getUser().getPassword(), newCompanyUserDTO.getUser().getEmail()));
        newCompanyModel.setIdUser(new UserModel(userResp.getId()));
        companyService.save(newCompanyModel);
    }

    @PostMapping("/array")
    public void newUserArray(@RequestBody CompanyUserDTO newCompanyUserDTO) {
        List<UserModel> idsUsers = new ArrayList<UserModel>();

        for (UserModel test : newCompanyUserDTO.getUserList()) {
            UserModel userResp = userService.save(new UserModel(test.getUsername(), test.getPassword(), test.getEmail()));
            idsUsers.add(new UserModel(userResp.getId()));
        }

        CompanyModel newCompanyModel = new CompanyModel(newCompanyUserDTO.getCompany().getUsername());

        newCompanyModel.setListUser(idsUsers);
        companyService.save(newCompanyModel);
    }

    @GetMapping("")
    public List<CompanyModel> findAllCompanyModels() {
        return companyService.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<CompanyModel> findByUserID(@PathVariable String userId) {
        return companyService.findByUserID(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable String id) {
        companyService.delete(id);
    }
}
