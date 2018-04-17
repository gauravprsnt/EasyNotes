package com.prashant.demo.controller;

import com.prashant.demo.convert.UserProfileConvert;
import com.prashant.demo.dto.UserProfileDto;
import com.prashant.demo.modal.UserProfile;
import com.prashant.demo.resource.UserProfileResource;
import com.prashant.demo.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserProfileController {
    private final UserProfileService userProfileService;
    private final UserProfileConvert userProfileConvert;

    @Autowired
    public UserProfileController(UserProfileService userProfileService, UserProfileConvert userProfileConvert) {
        this.userProfileService = userProfileService;
        this.userProfileConvert = userProfileConvert;
    }


    @GetMapping(value = "/profile")
    public List<UserProfile> getUserProfile() {
        return userProfileService.getAllUserProfile();

    }

    @PostMapping(value = "/profile")
    public UserProfileResource insertProfile(@RequestBody UserProfileDto userProfileDto){
        return userProfileConvert.convert(userProfileService.insertUserProfile(userProfileDto));

    }

    @GetMapping(value = "/profile/{id}")
    public UserProfile getSingleProfile(@PathVariable(value = "id")Long profileId){
        return userProfileService.getSingleUserProfile(profileId);
    }

    @PutMapping(value="/profile/{id}")
    public UserProfileResource updateProfile(@PathVariable(value = "id")Long profileId,
        @RequestBody UserProfileDto userProfileDto){

        return userProfileConvert.convert(userProfileService.updateUserProfile(profileId,userProfileDto));
    }

    @PutMapping(value="/profile/{id}/delete")
    public UserProfileResource deleteProfile(@PathVariable(value = "id")Long profileId,
                                             @RequestBody UserProfileDto userProfileDto){

        return userProfileConvert.convert(userProfileService.updateUserProfileStatus(profileId,userProfileDto));
    }
}
