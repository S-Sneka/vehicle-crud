package com.codingmart.vehiclecrudtask.service;


import com.codingmart.vehiclecrudtask.entity.User;
import com.codingmart.vehiclecrudtask.repository.UserRepository;
import com.codingmart.vehiclecrudtask.response.LoginResponse;
import com.codingmart.vehiclecrudtask.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticateServiceImpl implements AuthenticateService {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponse login(User user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail()
                ,user.getPassword()));
        return getLoginResponse(user);
    }


    @Override
    public LoginResponse signup(User user) {
        return getLoginResponse(userRepository.save(User.builder()
                        .email(user.getEmail())
                        .password(passwordEncoder.encode(user.getPassword()))
                .build()));

    }

    public LoginResponse getLoginResponse(User user) {
        return LoginResponse.builder()
                .jwtToken(jwtUtil.generateToken(user))
                .build();
    }
}
