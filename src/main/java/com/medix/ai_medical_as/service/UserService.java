//package com.medix.ai_medical_as.service;
//
//
//import com.medix.ai_medical_as.entity.User;
//import com.medix.ai_medical_as.repository.UserRepository;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//    private final UserRepository userRepository;
//
//    public UserService(UserRepository userRepository)
//    {
//        this.userRepository=userRepository;
//    }
//   public User registerUser(User user)
//   {
//       if (userRepository.findByEmail(user.getEmail()).isPresent()) {
//           throw new RuntimeException("Email already registered");
//       }
//
//      return userRepository.save(user);
//   }
//}



package com.medix.ai_medical_as.service;

import com.medix.ai_medical_as.dto.*;
import com.medix.ai_medical_as.entity.User;
import com.medix.ai_medical_as.exception.EmailAlreadyExistException;
import com.medix.ai_medical_as.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterResponse registerUser(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailAlreadyExistException("Email already registered");
        }

        String encodedPassword =
                passwordEncoder.encode(request.getPassword());

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(encodedPassword);

        User savedUser = userRepository.save(user);

        return new RegisterResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }

    public UserProfileResponse updateProfile(
            User user,
            UpdateProfileRequest request) {

        if (!user.getEmail().equalsIgnoreCase(request.getEmail())) {

            if (userRepository.findByEmail(request.getEmail()).isPresent()) {
                throw new EmailAlreadyExistException(
                        "Email already registered"
                );
            }
        }

        user.setName(request.getName());
        user.setEmail(request.getEmail());

        User updatedUser = userRepository.save(user);

        return new UserProfileResponse(
                updatedUser.getId(),
                updatedUser.getName(),
                updatedUser.getEmail(),
                updatedUser.getRole()
        );
    }

    public void changePassword(
            User user,
            ChangePasswordRequest request) {

        if (!passwordEncoder.matches(
                request.getOldPassword(),
                user.getPassword())) {

            throw new RuntimeException("Old password is incorrect");
        }

        if (request.getOldPassword().equals(
                request.getNewPassword())) {

            throw new RuntimeException(
                    "New password must be different from old password"
            );
        }

        String encodedPassword =
                passwordEncoder.encode(
                        request.getNewPassword());

        user.setPassword(encodedPassword);

        userRepository.save(user);
    }

}