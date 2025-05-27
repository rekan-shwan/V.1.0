package com.leap.app.app_security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {


    // @Bean
    // public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
    //     UserDetails user=User.withUsername("admin").password(passwordEncoder.encode("s")).build();
    //     return new InMemoryUserDetailsManager(user);
    // }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception{
        return http.getSharedObject(AuthenticationManagerBuilder.class).build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        return http
        .cors(cors -> cors.configurationSource(request -> {
            var corsConfig = new org.springframework.web.cors.CorsConfiguration();
            
            //corsConfig.setAllowedOrigins(List.of("http://localhost:9090"))); // Allow Flutter web origin
            corsConfig.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
            corsConfig.setAllowedHeaders(List.of("*"));
            corsConfig.setAllowCredentials(true);
            return corsConfig;
        }))
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(

            auth->{
                auth.requestMatchers("/login").permitAll();
                auth.requestMatchers("/index.html","/index.html", "/flutter.js", "/main.dart.js", 
                                 "/manifest.json", "/version.json", "/favicon.ico", "/favicon.png",
                                 "/icons/Icon-192.png", "/",
                                 "/flutter_bootstrap.js", "/flutter_service_worker.js",
                                 "/assets/**", "/icons/**", "/canvaskit/**").permitAll();
 
                auth.anyRequest().authenticated();
            }
        )
        .addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class)
        //.addFilterAfter(new BasicAuthenticationFilter(authenticationManager(http)), UsernamePasswordAuthenticationFilter.class) 
        
        .build();

    }
    

    public JwtAuthFilter authFilter(){
        return new JwtAuthFilter();
    }

    
    
}
