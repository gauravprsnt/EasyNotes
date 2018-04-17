package com.prashant.demo.service.impl;

import com.prashant.demo.dto.UserProfileDto;
import com.prashant.demo.exception.ResourceNotFoundException;
import com.prashant.demo.modal.Gender;
import com.prashant.demo.modal.Status;
import com.prashant.demo.modal.UserProfile;
import com.prashant.demo.repository.UserProfileRepository;
import com.prashant.demo.service.UserProfileService;
import com.prashant.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    private final UserProfileRepository userProfileRepository;
    private final UserService userService;

    @Autowired
    public UserProfileServiceImpl(UserProfileRepository userProfileRepository, UserService userService) {
        this.userProfileRepository = userProfileRepository;
        this.userService = userService;
    }

    @Override
    public List<UserProfile> getAllUserProfile() {
        return userProfileRepository.findAll();
    }

    @Override
    public UserProfile insertUserProfile(UserProfileDto userProfileDto) {
        UserProfile userProfile=new UserProfile();

        userProfile.setAddress(userProfileDto.getAddress());
        userProfile.setDob(userProfileDto.getDob());
        userProfile.setEmail(userProfileDto.getEmail());
        userProfile.setFirstName(userProfileDto.getFirstName());
        userProfile.setMiddleName(userProfileDto.getMiddleName());
        userProfile.setLastName(userProfileDto.getLastName());
        userProfile.setUser(userService.findByUserId(userProfileDto.getUserId()));
        userProfile.setStatus(Status.ACTIVE);
        userProfile.setGender(Gender.MALE);
        return userProfileRepository.save(userProfile);


    }

    @Override
    public UserProfile getSingleUserProfile(Long profileId) {
        return userProfileRepository.findById(profileId).orElseThrow(()->new ResourceNotFoundException("USerProfile","id",profileId));
    }

    @Override
    public UserProfile updateUserProfile(Long profileId, UserProfileDto userProfileDto) {
        UserProfile userProfile=userProfileRepository.findById(profileId).orElseThrow(()->new ResourceNotFoundException("UserProfile","Id",profileId));
        userProfile.setAddress(userProfileDto.getAddress());
        userProfile.setDob(userProfileDto.getDob());
        userProfile.setEmail(userProfileDto.getEmail());
        userProfile.setFirstName(userProfileDto.getFirstName());
        userProfile.setMiddleName(userProfileDto.getMiddleName());
        userProfile.setLastName(userProfileDto.getLastName());
        userProfile.setStatus(Status.ACTIVE);
        return userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfile updateUserProfileStatus(Long profileId, UserProfileDto userProfileDto) {
        UserProfile userProfile=userProfileRepository.findById(profileId).orElseThrow(()->new ResourceNotFoundException("UserProfile","Id",profileId));
        userProfile.setAddress(userProfileDto.getAddress());
        userProfile.setDob(userProfileDto.getDob());
        userProfile.setEmail(userProfileDto.getEmail());
        userProfile.setFirstName(userProfileDto.getFirstName());
        userProfile.setMiddleName(userProfileDto.getMiddleName());
        userProfile.setLastName(userProfileDto.getLastName());
        userProfile.setStatus(Status.INACTIVE);
        return userProfileRepository.save(userProfile);

    }
}
