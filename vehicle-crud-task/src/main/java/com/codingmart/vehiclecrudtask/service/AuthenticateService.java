package com.codingmart.vehiclecrudtask.service;


import com.codingmart.vehiclecrudtask.entity.User;
import com.codingmart.vehiclecrudtask.response.LoginResponse;

public interface AuthenticateService {
    LoginResponse login(User user);
    LoginResponse signup(User user);
}
