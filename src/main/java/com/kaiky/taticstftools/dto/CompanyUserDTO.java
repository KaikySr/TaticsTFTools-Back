package com.kaiky.taticstftools.dto;

import com.kaiky.taticstftools.model.CompanyModel;
import com.kaiky.taticstftools.model.UserModel;

import lombok.Data;
import java.util.List;

@Data
public class CompanyUserDTO {
    private UserModel user;
    private List<UserModel> userList;
    private CompanyModel company;
}
