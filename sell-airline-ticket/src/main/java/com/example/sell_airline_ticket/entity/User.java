package com.example.sell_airline_ticket.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "User")
public class User {

    @Id
    @Column(name = "UserID", length = 10, nullable = false)
    String userID;

    @Column(name = "Name", length = 50, nullable = false)
    String name;

    @Column(name = "PhoneNum", length = 10, nullable = true)
    String phoneNum;

    @Column(name = "Email", length = 50, nullable = true)
    String email;

    @Column(name = "CitizenID", length = 12, nullable = false)
    String citizenID;

    @Column(name = "CreditNum", length = 20, nullable = true)
    String creditNum;

    @Column(name = "Status", nullable = false)
    Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}

