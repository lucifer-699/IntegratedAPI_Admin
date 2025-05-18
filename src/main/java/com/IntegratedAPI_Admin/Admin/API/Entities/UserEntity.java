package com.IntegratedAPI_Admin.Admin.API.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserEntity {
    @Id
    @Column(name = "userid")
    private String userid;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}
