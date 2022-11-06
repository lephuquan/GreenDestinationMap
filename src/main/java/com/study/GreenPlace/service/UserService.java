package com.study.GreenPlace.service;

import com.study.GreenPlace.entity.CustomUserDetails;
import com.study.GreenPlace.entity.Users;
import com.study.GreenPlace.model.UserModel;
import com.study.GreenPlace.repository.RoleRepository;
import com.study.GreenPlace.repository.UserRepository;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private RoleRepository roleRepository;

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

    public UserModel getUser(Short userId) {
        return new ModelMapper().map(userRepository.findById(userId).get(), UserModel.class);
    }

    public static void main(String... args) {
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }


    public boolean checkIfUserExist(String username) {
        return userRepository.findByUsername(username) !=null ? true : false;
    }
    public String createAccount(UserModel userModel) {
        if(checkIfUserExist(userModel.getUsername())){
            return "fail";
        }
        Users userEntity = new ModelMapper().map(userModel, Users.class);
        userEntity.setPassword(new BCryptPasswordEncoder().encode(userModel.getPassword()));
        userEntity.setRoleid(roleRepository.findByRole("USER"));
        userEntity = userRepository.save(userEntity);
//        Roles roles  = new Roles();
//        roles.setUsersCollection((Collection<Users>) userEntity);
//        roles.setRole(roleRepository.findByRole("USER"));
//        roleRepository.save(roles);
        return "success";
    }

}