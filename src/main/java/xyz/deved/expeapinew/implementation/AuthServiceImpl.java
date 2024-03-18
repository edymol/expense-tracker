package xyz.deved.expeapinew.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import xyz.deved.expeapinew.constant.ERole;
import xyz.deved.expeapinew.dto.LoginDto;
import xyz.deved.expeapinew.dto.UserRegistrationDto;
import xyz.deved.expeapinew.entity.User;
import xyz.deved.expeapinew.repository.UserRepository;
import xyz.deved.expeapinew.utility.JwtTokenProvider;

@Service
public class AuthServiceImpl {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public boolean registerUser(UserRegistrationDto registrationDto) {
        // Check if the username or email already exists
        if (userRepository.existsByUsername(registrationDto.getUsername()) ||
                userRepository.existsByEmail(registrationDto.getEmail())) {
            return false; // Registration failed
        }

        // Create a new user entity
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword())); // Hash password
        user.setRole(ERole.ROLE_USER); // Set default role as ROLE_USER

        // Save the user to the database
        userRepository.save(user);

        return true; // Registration successful
    }
    public boolean registerAdmin(UserRegistrationDto registrationDto) {
        // Check if the username or email already exists
        if (userRepository.existsByUsername(registrationDto.getUsername()) ||
                userRepository.existsByEmail(registrationDto.getEmail())) {
            return false; // Registration failed
        }

        // Create a new user entity
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword())); // Hash password
        user.setRole(ERole.ROLE_ADMIN); // Always set role as ROLE_ADMIN

        // Save the user to the database
        userRepository.save(user);

        return true; // Registration successful
    }

    public String login(LoginDto loginDto) {
        // Perform authentication
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        // Set authentication in security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Generate JWT token
        return jwtTokenProvider.generateToken(authentication);
    }
}
