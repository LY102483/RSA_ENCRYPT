package com.demo.entity;

import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("serial")
public class Account extends Model<Account> {
    public static final Account dao = new Account();
}