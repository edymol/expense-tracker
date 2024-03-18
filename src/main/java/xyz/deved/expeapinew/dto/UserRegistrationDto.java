package xyz.deved.expeapinew.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import xyz.deved.expeapinew.constant.ERole;

@Data
public class UserRegistrationDto {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    @NotBlank
    private String role;
    public ERole getRoleEnum() {
        // Convert the role string to the corresponding ERole enum value
        return ERole.valueOf(role.toUpperCase());
    }
}
