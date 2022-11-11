package com.AcmeFresh.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	 
	
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user123")
            .password("password123")
            .roles("buyer")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
    
    
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests()
//            .antMatchers("/buyer").hasRole("buyer")
//            .antMatchers("/grower").hasRole("grower")
//            .and().formLogin();
//        return http.build();
//    }
}
