package com.study.GreenPlace.service;

import com.study.GreenPlace.entity.CustomUserDetails;
import com.study.GreenPlace.entity.Places;
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
        Users users = new ModelMapper().map(userModel, Users.class);
        users.setUserid(userModel.getUserid());
        users.setGender(userModel.isGender());
        users.setEmail(userModel.getEmail());
        users.setAddress(userModel.getAddress());
        users.setAvatar(userModel.getAvatar());
        users.setStartdate(userModel.getStartdate());
        users.setFirstname(userModel.getFirstname());
        users.setLastname(userModel.getLastname());
        users.setUsername(userModel.getUsername());// <=20 character
        users.setPassword(new BCryptPasswordEncoder().encode(userModel.getPassword()));
        users.setToken(userModel.getToken());
        users.setPhonenumber(userModel.getPhonenumber());
        users.setRoleid(roleRepository.findByRole(userModel.getRoleid().getRolesname()));// set by role, not rolesname at FE
        users = userRepository.save(users);
        return "success";
    }

    public String updateAccount(UserModel userModel) {
        Users users = userRepository.getReferenceById(userModel.getUserid());
        users.setGender(userModel.isGender());
        users.setEmail(userModel.getEmail());
        users.setAddress(userModel.getAddress());
        users.setAvatar(userModel.getAvatar());
        users.setStartdate(userModel.getStartdate());
        users.setFirstname(userModel.getFirstname());
        users.setLastname(userModel.getLastname());
        users.setUsername(userModel.getUsername());// <=20 character
        users.setPassword(new BCryptPasswordEncoder().encode(userModel.getPassword()));
        users.setToken(userModel.getToken());
        users.setPhonenumber(userModel.getPhonenumber());
        users.setAvatarkey(userModel.getAvatarkey());
        users.setRoleid(roleRepository.findByRole(userModel.getRoleid().getRolesname()));
        users = userRepository.save(users);
        return "success";
    }

}