package xyz.deved.expeapinew.dto;

import lombok.Data;
import xyz.deved.expeapinew.constant.ERole;

@Data
public class UserRegistrationDto {
    private String username;
    private String email;
    private String password;
    private ERole role;
}
