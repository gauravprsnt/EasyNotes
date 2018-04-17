package com.prashant.demo.convert;

import com.prashant.demo.modal.User;
import com.prashant.demo.resource.UserResource;

public interface UserConvertService {
    UserResource convert(User user);
}
