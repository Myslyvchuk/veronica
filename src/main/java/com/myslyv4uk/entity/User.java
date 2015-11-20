package com.myslyv4uk.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @SequenceGenerator(name = "users_user_id_seq", sequenceName = "users_user_id_seq", allocationSize = 101)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_user_id_seq")
    @Column(name = "user_id", unique = true, nullable = false)
    private Integer userId;

    @Size(min = 3, message = "Login must be at least 3 characters!")
    @Column(name = "login", length = 50, updatable = false, unique = true, nullable = false)
    private String login;

    @Size(min = 6, message = "Password must be at least 6 characters!")
    @Column(name = "password", length = 70, nullable = false)
    private String password;

    @Size(min = 3, message = "Not valid email address")
    @Column(name = "email")
    private String email;

    @Size(min = 3, message = "Name must be at least 3 characters!")
    @Column(name = "firstName", length = 70)
    private String firstName;

    @Size(min = 3, message = "Name must be at least 3 characters!")
    @Column(name = "lastName", length = 70)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_state", nullable = false)
    private UserState userState;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "birth_date")
    private Calendar birthday;

    @Column(name = "country", length = 50)
    private Country country;

    @Column(name = "region", length = 50)
    private String region;

    @ManyToOne
    @Column(name = "region", length = 50)
    private City city;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
