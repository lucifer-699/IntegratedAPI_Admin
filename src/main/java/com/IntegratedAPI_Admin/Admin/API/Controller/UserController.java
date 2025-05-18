package com.IntegratedAPI_Admin.Admin.API.Controller;

import com.IntegratedAPI_Admin.Admin.API.Authenticator.JwtTokenUtil;
import com.IntegratedAPI_Admin.Admin.API.DTO.LoginRequest;
import com.IntegratedAPI_Admin.Admin.API.DTO.LoginResponse;
import com.IntegratedAPI_Admin.Admin.API.Entities.UserEntity;
import com.IntegratedAPI_Admin.Admin.API.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginRequest loginRequest){

        String userid = loginRequest.getUserId();
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if (userid == null && !userid.isEmpty()){
            return ResponseEntity.status(404).body("The userid is not present or not valid");
        }
        if (username == null && !username.isEmpty()){
            return ResponseEntity.status(404).body("The username is not present or not valid");
        }
        if (password == null && !password.isEmpty()){
            return ResponseEntity.status(404).body("The password is not present or not valid");
        }

        try {
            UserEntity data = userService.validateuser(userid, username, password);
            if (data != null){
                System.out.println("The user with email : " + username + " is logged in.");
                String token = JwtTokenUtil.generateToken(username);
                return ResponseEntity.ok(new LoginResponse(token));
            }else {
                return ResponseEntity.status(404).body(" The token generation Failed !!");
            }
        }catch (Exception e){
            return ResponseEntity.status(404).body("The login failed due to Exception !!");
        }
    }

}
