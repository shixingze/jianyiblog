package com.jianyi.auth;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class TokenInfo implements Serializable {

    private Long userId;
    private String username;
    public String format() {
        return username + "," + userId;
    }

}
