package xyz.deved.expeapinew.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.deved.expeapinew.entity.User;
import xyz.deved.expeapinew.repository.UserRepository;
import xyz.deved.expeapinew.implementation.UserDetailsImpl; // Import UserDetailsImpl

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));

        return UserDetailsImpl.build(user); // Return UserDetailsImpl object
    }
}
