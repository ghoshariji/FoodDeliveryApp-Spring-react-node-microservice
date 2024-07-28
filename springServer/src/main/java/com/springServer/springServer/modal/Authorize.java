package com.springServer.springServer.modal;

public enum Authorize {
    // here admin and user are the enum constant variables it's works as a constant variables (like final keyword)
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
