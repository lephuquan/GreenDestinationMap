package com.study.GreenPlace.service;

import com.study.GreenPlace.entity.CustomUserDetails;
import com.study.GreenPlace.entity.Users;
import com.study.GreenPlace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // Kiểm tra xem user có tồn tại trong database không?
        Users user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }

    public UserDetails loadUserById(Short userId) {
        return new CustomUserDetails(userRepository.findById(userId).get());
    }

    public static void main(String... args) {
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }
}