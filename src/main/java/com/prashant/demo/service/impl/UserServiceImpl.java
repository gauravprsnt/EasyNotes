package com.prashant.demo.service.impl;

import com.prashant.demo.dto.UserDto;
import com.prashant.demo.exception.ResourceNotFoundException;
import com.prashant.demo.modal.Status;
import com.prashant.demo.modal.User;
import com.prashant.demo.repository.UserRepository;
import com.prashant.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User insertDetails(UserDto userDto) {
        User user=new User();
        user.setUserName(userDto.getUserName());
        user.setDisplayName(userDto.getDisplayName());
        user.setStatus(Status.ACTIVE);
        user.setPassWord(userDto.getPassWord());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> fetchSingleUser(Long userId) {

        return userRepository.findById(userId);
    }

    @Override
    public User updateUserValue(Long userID, UserDto userDto) {
        User user=userRepository.findById(userID).orElseThrow(()->
                new ResourceNotFoundException("User","Id",userID));
        user.setUserName(userDto.getUserName());
        user.setDisplayName(userDto.getDisplayName());
        user.setPassWord(userDto.getPassWord());
        return userRepository.save(user);
    }

    @Override
    public User updateUserStatus(Long userId, UserDto userDto) {
        User user=userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User","Id",userId));
        user.setUserName(userDto.getUserName());
        user.setDisplayName(userDto.getDisplayName());
        user.setPassWord(userDto.getPassWord());
        user.setStatus(Status.INACTIVE);
        return userRepository.save(user);
    }

    @Override
    public User findByUserId(Long userId) {
        return userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User","Id",userId));
    }
}
