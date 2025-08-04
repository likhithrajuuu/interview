package com.think41.interview.dto;

import java.util.Date;
import lombok.Data;

@Data
public class UserResponseDTO {
    public Long id;
    public String firstName;
    public String lastName;
    public String email;
    public Integer age;
    public String gender;
    public String city;
    public String country;
    public Long orderCount;
    public Date createdAt;

    public UserResponseDTO() {
        
    }


}