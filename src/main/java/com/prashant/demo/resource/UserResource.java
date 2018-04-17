package com.prashant.demo.resource;

import com.prashant.demo.modal.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserResource {
    private Long userId;
    private String userName;
    private String displayName;
    private Date createdDate;
    private Status userStatus;
}
