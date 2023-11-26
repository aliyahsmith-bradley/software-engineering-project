// SPDX-License-Identifier: MIT
package pokersite.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private int coins;

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
        this.coins = 0;
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

    @JsonIgnore
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

    public int getCoins(){return  coins;}
    public void setCoins(int coins){this.coins = coins;}

    public void purchase(Product product){
        if(coins >= product.getPrice()){
            coins -= product.getPrice();
            System.out.println("Purchase Successful: " + product.getName());
        }else{
            System.out.println("Insufficient coins to purchase " + product.getName());
        }
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