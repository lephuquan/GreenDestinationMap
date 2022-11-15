package com.study.GreenPlace.controller;

import com.study.GreenPlace.entity.CustomUserDetails;
import com.study.GreenPlace.jwt.JwtTokenProvider;
import com.study.GreenPlace.model.UserModel;
import com.study.GreenPlace.payload.LoginRequest;
import com.study.GreenPlace.payload.LoginResponse;
import com.study.GreenPlace.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private JwtTokenProvider tokenProvider;

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        // Kiểm tra xem header Authorization có chứa thông tin jwt không
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    private final String JWT_SECRET = "lodaaaaaa";

    public Short getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        return Short.parseShort(claims.getSubject());
    }

    @GetMapping("/userInfor")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getUser(){
        String jwt = getJwtFromRequest(httpServletRequest);
        Short userId = tokenProvider.getUserIdFromJWT(jwt);
        return ok(userService.getUser(userId));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserModel user){
        return ResponseEntity.ok(userService.createAccount(user));
    }

    @PutMapping("/update")
    public ResponseEntity<?>  updateUser(@RequestBody UserModel user){
        return ResponseEntity.ok(userService.updateAccount(user));
    }

    @PostMapping("/updatePassword")
    public boolean authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {// if don't work, let test login

        try{
            // Xác thực từ username và password.
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            // Nếu không xảy ra exception tức là thông tin hợp lệ
            // Set thông tin authentication vào Security Context
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Trả về jwt cho người dùng.
            String jwt = tokenProvider.generateToken ((CustomUserDetails) authentication.getPrincipal());

            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
