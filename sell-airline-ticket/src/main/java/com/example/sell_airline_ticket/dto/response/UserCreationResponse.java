package com.example.sell_airline_ticket.dto.response;

public class UserCreationResponse {
    private String userID;
    private String name;
    private String phoneNum;
    private String email;
    private String citizenID;
    private String creditNum;
    private Boolean status;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getCreditNum() {
        return creditNum;
    }

    public void setCreditNum(String creditNum) {
        this.creditNum = creditNum;
    }

    public String getCitizenID() {
        return citizenID;
    }

    public void setCitizenID(String citizenID) {
        this.citizenID = citizenID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
