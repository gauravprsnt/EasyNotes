package com.prashant.demo.convert;

import com.prashant.demo.modal.Gender;
import com.prashant.demo.modal.UserProfile;
import com.prashant.demo.resource.UserProfileResource;
import org.springframework.stereotype.Service;
@Service
public class UserProfileConvertImlp implements UserProfileConvert{
    @Override
    public UserProfileResource convert(UserProfile userProfile) {
        UserProfileResource userProfileResource=new UserProfileResource();
        userProfileResource.setId(userProfile.getId());
        userProfileResource.setAddress(userProfile.getAddress());
        userProfileResource.setCreatedDate(userProfile.getCreatedAt());
        userProfileResource.setDob(userProfile.getDob());
        userProfileResource.setEmail(userProfile.getEmail());
        userProfileResource.setLastName(userProfile.getLastName());
        userProfileResource.setMiddleName(userProfile.getMiddleName());
        userProfileResource.setFirstName(userProfile.getFirstName());
        userProfileResource.setGender(Gender.MALE);
        return userProfileResource;
    }
}
