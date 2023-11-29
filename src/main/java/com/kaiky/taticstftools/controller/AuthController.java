package com.kaiky.taticstftools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaiky.taticstftools.model.UserModel;
import com.kaiky.taticstftools.service.AuthService;
import com.kaiky.taticstftools.service.UserService;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody UserModel user) {
        var resp = this.userService.findByUsername(user.getUsername());
        if (resp != null) {
            if (resp.size() == 0)
                throw new UsernameNotFoundException("User not found");
            if (resp.get(0).getPassword().equals(user.getPassword())) {
                return authService.createToken(user);
            }
            return "Senha incorreta";
        }
        return "Usuário não encontrado";
    }

    @PostMapping("/validate")
    public String validate(@RequestHeader("Authorization") String token) {
        final var validate = this.authService.validateToken(token.replace("Bearer ", ""));
        if (!validate.isBlank()) {
            return validate;
        }
        return "token not valid";
    }

}
