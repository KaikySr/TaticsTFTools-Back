package com.kaiky.taticstftools.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaiky.taticstftools.model.UserModel;
import com.kaiky.taticstftools.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModel save(UserModel userModel) {
        return this.userRepository.save(userModel);
    }

    public void save(String id, String username, String password, String email) {
        this.userRepository.save(new UserModel(id, username, password, email));
    }

    public List<UserModel> findAll() {
        return (List<UserModel>) this.userRepository.findAll();
    }

    public List<UserModel> findByUsername(String username) {
        return (List<UserModel>) this.userRepository.findByUsername(username);
    }

    public void delete(String id) {
        this.userRepository.deleteById(id);
    }

}
