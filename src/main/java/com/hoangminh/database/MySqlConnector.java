package com.hoangminh.database;

public class MySqlConnector extends DatabaseConnector{

    @Override
    public void connect() {
        System.out.println("Đã kết nối tới Mysql: " + getUrl());
        System.out.println("Mysql Username: " + getUsername());
        System.out.println("Mysql Password: " + getPassword());
    }


}
