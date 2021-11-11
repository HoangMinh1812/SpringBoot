package com.hoangminh.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String passWord;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "status")
    private Integer status;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleEnity> roles = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<RoleEnity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEnity> roles) {
        this.roles = roles;
    }
}
