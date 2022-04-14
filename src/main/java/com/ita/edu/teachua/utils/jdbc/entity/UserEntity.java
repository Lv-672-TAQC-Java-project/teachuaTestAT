package com.ita.edu.teachua.utils.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class UserEntity {
    public static final String SELECT_ALL = "SELECT * FROM users ORDER BY id;";

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private String provider;
    private String providerId;
    private Integer roleId;
    private Boolean status;
    private String urlLogo;
    private String verificationCode;

    public UserEntity(Long id, String email, String firstName, String lastName, String password, String phone, String provider, String providerId, Integer roleId, Boolean status, String urlLogo, String verificationCode) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.provider = provider;
        this.providerId = providerId;
        this.roleId = roleId;
        this.status = status;
        this.urlLogo = urlLogo;
        this.verificationCode = verificationCode;
    }

    public UserEntity() {
        this.id = 0L;
        this.email = null;
        this.firstName = null;
        this.lastName = null;
        this.password = null;
        this.phone = null;
        this.provider = null;
        this.providerId = null;
        this.roleId = null;
        this.status = null;
        this.urlLogo = null;
        this.verificationCode = null;
    }

    public static UserEntity getUser(List<String> row) {
        UserEntity user = new UserEntity();
        user.setId(Long.parseLong(row.get(0)));
        user.setEmail(row.get(1));
        user.setFirstName(row.get(2));
        user.setLastName(row.get(3));
        user.setPassword(row.get(4));
        user.setPhone(row.get(5));
        user.setProvider(row.get(6));
        user.setProviderId(row.get(7));
        user.setStatus(row.get(8) == "t");
        user.setUrlLogo(row.get(9));
        user.setVerificationCode(row.get(10));
        if (row.get(11) != null) {
            user.setRoleId(Integer.parseInt(row.get(11)));
        }

        return user;
    }

    public static List<UserEntity> getUsers(List<List<String>> rows) {
        List<UserEntity> users = new ArrayList<>();
        for (List<String> row : rows) {
            users.add(getUser(row));
        }
        return users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", provider='" + provider + '\'' +
                ", providerId='" + providerId + '\'' +
                ", roleId=" + roleId +
                ", status=" + status +
                ", urlLogo='" + urlLogo + '\'' +
                ", verificationCode='" + verificationCode + '\'' +
                '}';
    }
}
