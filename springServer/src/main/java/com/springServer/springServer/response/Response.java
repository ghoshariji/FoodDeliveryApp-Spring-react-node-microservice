package com.springServer.springServer.response;

import com.springServer.springServer.modal.UserModal;

public class Response {
    private String token;
    private UserModal userModal;

    public String getToken() {
        return token;
    }

    public UserModal getUserModal() {
        return userModal;
    }

    @Override
    public String toString() {
        return "Response [token=" + token + ", userModal=" + userModal + "]";
    }

    public Response(String token, UserModal userModal) {
        this.token = token;
        this.userModal = userModal;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUserModal(UserModal userModal) {
        this.userModal = userModal;
    }

}
