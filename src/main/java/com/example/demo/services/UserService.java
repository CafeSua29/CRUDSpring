package com.example.demo.services;

import com.example.demo.repository.dto.RegisterDto;
import com.example.demo.repository.entity.User;
import com.example.demo.repository.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            var springUser = user.get();

            return org.springframework.security.core.userdetails.User.builder()
                    .username(springUser.getUsername())
                    .password(springUser.getPassword())
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
