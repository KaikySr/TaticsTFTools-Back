package com.kaiky.taticstftools.controller;

import java.util.List;
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

import com.kaiky.taticstftools.model.UserModel;
import com.kaiky.taticstftools.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<UserModel> getAllUser() {
        List<UserModel> listRes = userService.findAll();
        return listRes;
    }

    @GetMapping("/{name}")
    public List<UserModel> getUserByName(@PathVariable String name) {
        List<UserModel> listRes = userService.findByName(name);
        return listRes;
    }

    @GetMapping("/{age}/{name}")
    public List<UserModel> getUserByAgeAndName(@PathVariable short age, @PathVariable String name) {
        List<UserModel> listRes = userService.findByAgeAndName(age, name);
        return listRes;
    }

    @PostMapping("")
    public void newUser(@RequestBody UserModel newUser) {
        userService.save(newUser);
    }

    @PutMapping("/{id}")
    public void putUser(@RequestBody UserModel newUser, @PathVariable String id) {
        userService.save((String) id, (String) newUser.getName(), (short) newUser.getAge());
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.delete(id);
    }

}
