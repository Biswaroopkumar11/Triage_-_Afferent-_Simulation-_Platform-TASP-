//package com.medix.ai_medical_as.controller;
//
//
//import com.medix.ai_medical_as.entity.User;
//import com.medix.ai_medical_as.service.UserService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//
//    private final UserService userService;
//
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<User> registerUser(@RequestBody User user) {
//
//        User savedUser = userService.registerUser(user);
//
//        return ResponseEntity.ok(savedUser);
//    }
//}

package com.medix.ai_medical_as.controller;

import com.medix.ai_medical_as.dto.*;
import com.medix.ai_medical_as.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.medix.ai_medical_as.entity.User;
import org.springframework.security.core.Authentication;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;



@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> registerUser(
            @Valid @RequestBody RegisterRequest request) {

        RegisterResponse response =
                userService.registerUser(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);

    }
    @GetMapping("/profile")
    public ResponseEntity<UserProfileResponse> profile(
            Authentication authentication) {

        User user = (User) authentication.getPrincipal();

        UserProfileResponse response =
                new UserProfileResponse(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getRole()
                );

        return ResponseEntity.ok(response);
    }



    @GetMapping("/admin-test")
    public ResponseEntity<String> adminTest() {
        return ResponseEntity.ok(
                "Welcome Admin! You have admin access."
        );
    }


    @PutMapping("/profile")
    public ResponseEntity<UserProfileResponse> updateProfile(
            @Valid @RequestBody UpdateProfileRequest request,
            Authentication authentication) {

        User user = (User) authentication.getPrincipal();

        UserProfileResponse response =
                userService.updateProfile(user, request);

        return ResponseEntity.ok(response);
    }


    @PutMapping("/change-password")
    public ResponseEntity<String> changePassword(
            @Valid @RequestBody ChangePasswordRequest request,
            Authentication authentication) {

        User user = (User) authentication.getPrincipal();

        userService.changePassword(user, request);

        return ResponseEntity.ok(
                "Password changed successfully"
        );
    }

}