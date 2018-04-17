package com.prashant.demo.convert;

import com.prashant.demo.modal.User;
import com.prashant.demo.resource.UserResource;
import org.springframework.stereotype.Service;

@Service
public class UserConvertServiceImpl implements UserConvertService {

    @Override
    public UserResource convert(User user) {
        UserResource userResource=new UserResource();
        userResource.setUserId(user.getId());
        userResource.setUserName(user.getUserName());
        userResource.setDisplayName(user.getDisplayName());
        userResource.setCreatedDate(user.getCreatedAt());
        userResource.setUserStatus(user.getStatus());
        return userResource;
    }
}
