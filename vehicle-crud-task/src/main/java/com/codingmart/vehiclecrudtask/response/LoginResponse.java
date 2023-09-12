package com.codingmart.vehiclecrudtask.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    private String jwtToken;
}
