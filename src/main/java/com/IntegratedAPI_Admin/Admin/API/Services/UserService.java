package com.IntegratedAPI_Admin.Admin.API.Services;

import com.IntegratedAPI_Admin.Admin.API.Entities.UserEntity;
import com.IntegratedAPI_Admin.Admin.API.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity validateuser(String userid, String username, String password){
        return userRepository.validateUser(userid, username, password);
    }
}
