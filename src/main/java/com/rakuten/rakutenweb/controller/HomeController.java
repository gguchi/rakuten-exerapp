package com.rakuten.rakutenweb.controller;

import com.rakuten.rakutenweb.model.JwtRequest;
import com.rakuten.rakutenweb.model.JwtResponse;
import com.rakuten.rakutenweb.service.UserServices;
import com.rakuten.rakutenweb.ulity.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserServices userServices;

    @GetMapping("/TEST")
    public String home(){
        return "TESTING";
    }

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID CREDENTIALS", e);
        }

        final UserDetails userDetails =
                userServices.loadUserByUsername(jwtRequest.getUsername());

        final String token =
                jwtUtil.generateToken(userDetails);

        return new JwtResponse(token);
    }
}
