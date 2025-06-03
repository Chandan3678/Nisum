package com.nisum.model;

public class Account {

    private String userId;
    private String contactEmail;

    public Account() {
        // Default constructor
    }

    public Account(String userId, String contactEmail) {
        this.userId = userId;
        this.contactEmail = contactEmail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
