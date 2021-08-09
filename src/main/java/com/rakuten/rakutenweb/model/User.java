package com.rakuten.rakutenweb.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class User {

    @Id
    private int id;
    @NotBlank(message = "Enter your full name")
    private String fullName;
    @NotBlank(message="Enter your username")
    private String username;
    @NotBlank(message="Enter your password")
    @Length(min = 6, message = "Password should be at least six characters")
    private String password;
    @NotBlank(message="Enter your email")
    @Email(message = "Enter a valid email address")
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public User() {
    }

    protected User(int id, String username, String fullName, String password, String email) {
        super();
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

