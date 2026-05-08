package com.ab.book_store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class UserInfo {
    @Id
    private long userId;
    private String userName;
    private String password;
    private String role;

    public UserInfo(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
}
