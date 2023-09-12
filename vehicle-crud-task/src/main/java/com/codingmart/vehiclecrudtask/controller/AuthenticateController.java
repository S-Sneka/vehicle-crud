package com.codingmart.vehiclecrudtask.controller;


import com.codingmart.vehiclecrudtask.entity.User;
import com.codingmart.vehiclecrudtask.response.GenericResponse;
import com.codingmart.vehiclecrudtask.response.LoginResponse;
import com.codingmart.vehiclecrudtask.service.AuthenticateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticateController {
    private final AuthenticateService authenticateService;

    @PostMapping("/signup")
    public GenericResponse<LoginResponse> sendOtp(@RequestBody User user) {


        return GenericResponse.<LoginResponse>builder()
                .code(200)
                .status(HttpStatus.OK)
                .data(authenticateService.signup(user))
                .build();
    }

    @PostMapping("/login")
    public GenericResponse<LoginResponse> login(@RequestBody User user) {
        return GenericResponse.<LoginResponse>builder()
                .code(200)
                .status(HttpStatus.OK)
                .data(authenticateService.login(user))
                .build();
    }
}
