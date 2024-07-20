package com.springServer.springServer.modal;

public enum Authorize {
    ADMIN("ADMIN"),
    USER("USER");
    private String auth;
    Authorize(String auth)
    {
        this.auth = auth;
    }
    public String getAuth() {
        return auth;
    }
    public void setAuth(String auth) {
        this.auth = auth;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
