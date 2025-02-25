package com.example.springsecuritylearn.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authorities {

    @Id
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "authority", nullable = false, length = 50)
    private String authority;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Authorities() {
    }

    public Authorities(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

}
