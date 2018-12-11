package com.management.service;

import com.management.exceptions.MyException;
import com.management.model.User;
import com.management.model.dto.UserDto;
import com.management.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public List<UserDto> getAllUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(modelMapper::fromUsertoUserDto)
                .collect(Collectors.toList());
    }

    public UserDto addNewUser(UserDto userDto) {
        if (userDto == null) {
            log.error("USER OBJECT IS NULL");
            throw new MyException("USER OBJECT IS NULL");
        }

        if (userRepository.findByLogin(userDto.getLogin()).isPresent()) {
            log.error("LOGIN IS ALREADY EXISTS");
            throw new MyException("LOGIN IS ALREADY EXISTS");
        }
        User user = userRepository
                .save(modelMapper.fromUserDtoToUser(userDto));
        return modelMapper.fromUsertoUserDto(user);
    }

    public UserDto updateUser(UserDto userDto) {
        if (userDto == null) {
            log.error("USER OBJECT IS NULL");
            throw new MyException("USER OBJECT IS NULL");
        }
        User user = userRepository
                .findByLogin(userDto.getLogin())
                .orElseThrow(() -> new MyException("INCORRECT LOGIN"));
        user.setUsername(userDto.getUserName() == null ? user.getUsername() : userDto.getUserName());
        user.setSurname(userDto.getSurname() == null ? user.getSurname() : userDto.getSurname());
        user.setPassword(userDto.getPassword() == null ? user.getPassword() : userDto.getPassword());
        userRepository.save(user);
        return modelMapper.fromUsertoUserDto(user);
    }

    public UserDto deleteUser(UserDto userDto) {
        if (userDto == null) {
            log.error("USER OBJECT IS NULL");
            throw new MyException("USER OBJECT IS NULL");
        }

        User user = userRepository.findByLogin(userDto.getLogin())
                .orElseThrow(() -> new MyException("INCORRECT LOGIN"));
        userRepository.delete(user);
        return modelMapper.fromUsertoUserDto(user);
    }
}

