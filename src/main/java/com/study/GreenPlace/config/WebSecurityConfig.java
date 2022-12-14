package com.study.GreenPlace.config;

import com.study.GreenPlace.jwt.JwtAuthenticationFilter;
import com.study.GreenPlace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // Get AuthenticationManager bean
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Password encoder, để Spring Security sử dụng mã hóa mật khẩu người dùng
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userService) // Cung cáp userservice cho spring security
                .passwordEncoder(passwordEncoder()); // cung cấp password encoder
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/api/login", "/api/register1", "/api", "/img/image", "/place/information","/place/{id}", "/place/findPlacesByWishlistId/{id}",
                                                "/place/findByName/{name}","/place/findByUser/{userName}",
                                                    "/place/deletePlace/{id}", "/user/register", "/img/image/{id}",
                                                    "/criterias/getAllCriterias", "/criterias/getCriteriasByPlaceTypeId/{id}", "/place/addPlace",
                                                        "/criterias/addCriterias", "/criterias/updateCriterias", "/rating/getRatingByPlaceIdAndUserId/**", "/rating/addRating",
                "/comment/addComment", "/rating/updateRating", "/place/findByUserId/{id}",
                "/comment/getCommentByPlaceId/{id}", "/comment/deleteComment/{id}", "/comment/updateComment",
                "/wishList/addWishList", "/wishList/updateWishList", "/wishList/deleteWishList/{id}", "/wishList/getWishlistByUserId/{id}",
                "/wishlistItem/addWishlistItem", "/wishlistItem//deleteWishListItem/{id}", "/wishlistItem/getWishlistItemByWishlistId/{id}",
                "/notification/getByUserId/{id}", "/notification/updateStatus/{id}", "/place/approved").permitAll();
        http.authorizeRequests().antMatchers("/api/random" ).hasAuthority("USER");
        http.authorizeRequests().antMatchers("/api/random1").hasAuthority("ADMIN");
        http.cors() // Ngăn chặn request từ một domain khác
                .and()
                .authorizeRequests()
                .anyRequest().authenticated(); // Tất cả các request khác đều cần phải xác thực mới được truy cập

        // Thêm một lớp Filter kiểm tra jwt
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.csrf().disable();
    }
}