package com.prashant.demo.dto;

import com.prashant.demo.modal.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserProfileDto {
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String email;
    private Date dob;
    private Long userId;

}
