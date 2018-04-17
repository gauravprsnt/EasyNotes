package com.prashant.demo.service;

import com.prashant.demo.dto.UserDto;
import com.prashant.demo.modal.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();

    User insertDetails(UserDto userDto);

    Optional<User> fetchSingleUser(Long userId);

    User updateUserValue(Long userID, UserDto userDto);

    User updateUserStatus(Long userId, UserDto userDto);

    User findByUserId(Long userId);
}
