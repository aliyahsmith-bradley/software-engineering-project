// SPDX-License-Identifier: MIT
package edu.loyola.cs.se.website.model.entity;

import javax.persistence.*;

@Entity
public class User extends BaseEntity {
    @Id @Column(name="id_user") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID = null;

    private String username;
    private String Password;
    private String email;

    private String first_name;
    private String last_name;

    private String phone_number;

    public User(){
    }

    public User(Integer ID, String username, String password, String email, String first_name, String last_name, String phone_number) {
        this.ID = ID;
        Password = password;
        this.username = username;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getID() {
        return ID;
    }
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getFirst_name() {return first_name;}

    public void setFirst_name(String first_name) {this.first_name = first_name;}

    public String getLast_name() {return last_name;}

    public void setLast_name(String last_name) {this.last_name = last_name;}

    public String getPhone_number() {return phone_number;}

    public void setPhone_number(String phoneNumber) {this.phone_number = phoneNumber;}
}

/**
 create table user(
    id_user int not null auto_increment,
    name_user varchar(50),
    login varchar(30) not null,
    password char(60) not null,
    permission int not null default 1,
    constraint user_pk primary key(id_user),
    constraint user_login_uk unique key(login)
 );
 */