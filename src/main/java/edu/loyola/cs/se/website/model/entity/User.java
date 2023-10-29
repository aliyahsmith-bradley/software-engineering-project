// SPDX-License-Identifier: MIT
package edu.loyola.cs.se.website.model.entity;

import javax.persistence.*;

@Entity
public class User extends BaseEntity {
    @Id @Column(name="id_user") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID = null;

    private String username;
    private String Password;

    public User(){
    }

    public User(Integer ID, String username, String password) {
        this.ID = ID;
        Password = password;
        this.username = username;
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