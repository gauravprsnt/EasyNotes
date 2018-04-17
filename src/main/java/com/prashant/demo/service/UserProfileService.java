package com.prashant.demo.service;

import com.prashant.demo.dto.UserProfileDto;
import com.prashant.demo.modal.UserProfile;

import java.util.List;

public interface UserProfileService {
    List<UserProfile> getAllUserProfile();

    UserProfile insertUserProfile(UserProfileDto userProfileDto);

    UserProfile getSingleUserProfile(Long profileId);

    UserProfile updateUserProfile(Long profileId, UserProfileDto userProfileDto);

    UserProfile updateUserProfileStatus(Long profileId, UserProfileDto userProfileDto);
}
