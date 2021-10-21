package com.study.corona_study.domain;


import lombok.*;

import java.time.LocalDateTime;

@Data
public class Admin {
    private long id;
    private String email;
    private String nickname;
    private String password;
    private String phone;
    private String memo;

    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
}
