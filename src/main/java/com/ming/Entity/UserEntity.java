package com.ming.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class UserEntity {
    @Id
    private Long id;
    private String username;
    private String nickName;
    private String password;
    private String email;
    private String avatar;
    private String quote;

}
