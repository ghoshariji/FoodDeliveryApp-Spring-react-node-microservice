package com.springServer.springServer.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class UserModal {

    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Authorize authorize;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public Authorize getAuthorize() {
        return authorize;
    }
     public void setAuthorize(Authorize authorize) {
        this.authorize = authorize;
    }
    @Override
    public String toString() {
        return "UserModal [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phone="
                + phone + ", authorize=" + authorize + "]";
    }

}
