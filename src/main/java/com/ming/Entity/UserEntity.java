package com.ming.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_user")
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
