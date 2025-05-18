package com.IntegratedAPI_Admin.Admin.API.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users", schema = "groupapi")
public class UserEntity {
    @Id
    @Column(name = "user_id")
    private String userid;

    @Column(name = "username")
    private String username;

    @Column(name = "password_hash")
    private String password;
}
