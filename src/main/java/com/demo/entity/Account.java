package com.demo.entity;

import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("serial")
public class Account extends Model<Account> {
    public static final Account dao = new Account();
    public static final String ID = "id";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    public String getUsername(){
        return this.getStr("username");
    }
}