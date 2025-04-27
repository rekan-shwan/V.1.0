package com.leap.app.app_security;


import java.io.IOException;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthFilter extends OncePerRequestFilter{

    @SuppressWarnings("null")
    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
          HttpServletResponse response, 
         FilterChain filterChain)
            throws ServletException, IOException {
        String authHeader=request.getHeader("Authorization");
        String token=null;
        if (authHeader!=null && authHeader.startsWith("Bearer ")) {
            token=authHeader.substring(7).trim();
        }
        if (token!=null&& JwtUtile.isTokenvalid(token)) {
            Authentication authentication=new UsernamePasswordAuthenticationToken(JwtUtile.getClaims(token).getSubject(), null,io.jsonwebtoken.lang.Collections.emptyList());
           SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
        
    }

   
}
