package xyz.deved.expeapinew.service;

import xyz.deved.expeapinew.dto.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}
