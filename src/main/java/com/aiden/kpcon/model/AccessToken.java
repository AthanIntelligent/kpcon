package com.aiden.kpcon.model;

import lombok.Data;

@Data
public class AccessToken {
    private String access_token;
    private Long expires_in;
}
