package com.management.service;

import com.management.exceptions.MyException;
import com.management.model.User;
import com.management.model.dto.LoginDataDto;
import com.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    @Value("${token}")
    private String authenticationToken;

    private UserRepository userRepository;

    public SecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String login(LoginDataDto loginDataDto) {

        if (loginDataDto == null) {
            throw new MyException("LOGIN DATA OBJECT IS NULL");
        }

        if (loginDataDto.getLogin() == null) {
            throw new MyException("PASSWORD IS NULL");
        }

        if (loginDataDto.getPassword() == null) {
            throw new MyException("PASSWORD IS NULL");
        }

        User user = userRepository.findByLogin(loginDataDto.getLogin())
                .orElseThrow(() -> new IllegalArgumentException("USERNAME IS NOT CORRECT"));

        if (!loginDataDto.getPassword().equals(user.getPassword())) {
            throw new IllegalArgumentException("PASSWORD IS NOT CORRECT");
        }

        return authenticationToken;
    }
}
