package xyz.deved.expeapinew.service;

import xyz.deved.expeapinew.dto.LoginDto;
import xyz.deved.expeapinew.dto.UserRegistrationDto;

public interface AuthService {
    String login(LoginDto loginDto);

    boolean registerUser(UserRegistrationDto registrationDto);
}
