package com.kaiky.taticstftools.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.kaiky.taticstftools.exception.AuthException;
import com.kaiky.taticstftools.model.UserModel;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Value("${jwt.secret")
    private String secret;

    @Value("${jwt.issuer}")
    private String issuer;

    public String createToken(UserModel user) {
        try {

            final var anAlgorithm = Algorithm.HMAC256(secret);
            final String aToken = JWT.create()
                    .withIssuer(issuer)
                    .withSubject(user.getUsername())
                    .withExpiresAt(new Date(new Date().getTime() + 24 * 60 * 60 * 1000))
                    .sign(anAlgorithm);
            return aToken;

        } catch (IllegalArgumentException e) {
            throw new AuthException(e.getMessage());
        } catch (JWTCreationException e) {
            throw new AuthException(e.getMessage());
        }

    }

    public String validateToken(String token) {
        try {
            final var anAlgorithm = Algorithm.HMAC256(secret);
            final var decoded = JWT.require(anAlgorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(token);
            final var anSubject = decoded.getSubject();
            return anSubject;
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserModel> resp = this.userService.findByUsername(username);
        if (resp.size() == 0)
            throw new UsernameNotFoundException("User not found");
        if (resp.get(0).getUsername().equals(username)) {
            return resp.get(0);
        } 
        throw new UsernameNotFoundException("User not found");
    }

}
