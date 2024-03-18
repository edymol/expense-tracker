package xyz.deved.expeapinew.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import xyz.deved.expeapinew.constant.ERole;
import xyz.deved.expeapinew.dto.UserRegistrationDto;
import xyz.deved.expeapinew.entity.User;
import xyz.deved.expeapinew.entity.Role;
import xyz.deved.expeapinew.repository.RoleRepository;
import xyz.deved.expeapinew.repository.UserRepository;
import xyz.deved.expeapinew.service.UserService;

import java.util.Set;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void registerAdmin(UserRegistrationDto registrationDto) {
        User admin = new User();
        admin.setUsername(registrationDto.getUsername());
        admin.setEmail(registrationDto.getEmail());
        admin.setPassword(passwordEncoder.encode(registrationDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN.name())
                .orElseThrow(() -> new RuntimeException("Error: Role not found."));
        roles.add(adminRole);
        admin.setRoles(roles);

        userRepository.save(admin);
    }
}
