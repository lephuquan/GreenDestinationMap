package com.study.GreenPlace.controller;

import com.study.GreenPlace.jwt.JwtTokenProvider;
import com.study.GreenPlace.model.UserModel;
import com.study.GreenPlace.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/user")
public class UserController {

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
}
