package com.prashant.demo.resource;

import com.prashant.demo.modal.Gender;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserProfileResource {
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Gender gender;
    private Date dob;
    private Date createdDate;
    private String address;
    private String email;


}