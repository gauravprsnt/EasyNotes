package com.prashant.demo.convert;

import com.prashant.demo.modal.UserProfile;
import com.prashant.demo.resource.UserProfileResource;

public interface UserProfileConvert {
    UserProfileResource convert(UserProfile userProfile);
}
