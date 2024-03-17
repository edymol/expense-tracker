package xyz.deved.expeapinew.controler;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.deved.expeapinew.dto.LoginDto;
import xyz.deved.expeapinew.dto.UserRegistrationDto;
import xyz.deved.expeapinew.implementation.AuthServiceImpl;
import xyz.deved.expeapinew.security.response.JWTAuthResponse;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthServiceImpl authService;

    // Endpoint for user registration
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDto registrationDto) {
        if (authService.registerUser(registrationDto)) {
            return ResponseEntity.ok("User registered successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User registration failed");
        }
    }

    // Endpoint for admin registration (secured URL)
    @PostMapping("/register/admin")
    public ResponseEntity<String> registerAdmin(@RequestBody UserRegistrationDto registrationDto) {
        if (authService.registerAdmin(registrationDto)) {
            return ResponseEntity.ok("Admin registered successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Admin registration failed");
        }
    }

    // Endpoint for user login
    @PostMapping("/login")
    public ResponseEntity<JWTAuthResponse> authenticate(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);
        if (token != null) {
            JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
            jwtAuthResponse.setAccessToken(token);
            return ResponseEntity.ok(jwtAuthResponse);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
