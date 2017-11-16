package com.pwr.invoice.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import java.security.MessageDigest;

@Service
public class TokenService implements ITokenService{

    @Override
    public String generateToken(String login) {
        Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
        String hashed = passwordEncoder.encodePassword(login, null);
        return hashed;
    }
}
