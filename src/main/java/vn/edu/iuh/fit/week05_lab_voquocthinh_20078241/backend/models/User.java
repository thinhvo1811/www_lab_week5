package vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.enums.UserType;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String username;
    @Column(length = 50, nullable = false)
    private String password;
    @Column(nullable = false)
    private UserType userType;

    public User() {
    }

    public User(String username, String password, UserType userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}
