package com.prashant.demo.controller;

import com.prashant.demo.convert.UserConvertService;
import com.prashant.demo.dto.UserDto;
import com.prashant.demo.modal.User;
import com.prashant.demo.resource.UserResource;
import com.prashant.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api")
public class UserController {
    private final UserService userService;
    private final UserConvertService userConvertService;

    @Autowired
    public UserController(UserService userService, UserConvertService userConvertService) {
        this.userService = userService;
        this.userConvertService = userConvertService;
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userService.findAllUsers();
    }

    @PostMapping(value="/users")
    public UserResource insertUser(@RequestBody UserDto userDto){
        return userConvertService.convert(userService.insertDetails(userDto));
    }

    @GetMapping(value = "/users/{id}")
    public Optional<User> getSingleUser(@PathVariable(value = "id")Long userId){
        return userService.fetchSingleUser(userId);
    }

    @PutMapping(value = "/users/{id}")
    public UserResource updateUser(@PathVariable(value = "id")Long userID,
                                   @RequestBody UserDto userDto){
        return userConvertService.convert(userService.updateUserValue(userID,userDto));
    }

    @PutMapping(value = "/users/{id}/delete")
    public UserResource deleteUser(@PathVariable(value = "id")Long userId,
                                   @RequestBody UserDto userDto){
        return userConvertService.convert(userService.updateUserStatus(userId,userDto));
    }

}
