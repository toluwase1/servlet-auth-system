package com.example.servlet_auth_system.DAO;

import com.example.servlet_auth_system.Models.User;

import java.sql.*;

public class UserDao {
    Connection con ;

    public UserDao(Connection con) {
        this.con = con;
    }

    //for register user
    public boolean saveUser(User user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into user(name,email,password) values(?,?,?)";

            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1, user.getName());
            pt.setString(2, user.getEmail());
            pt.setString(3, user.getPassword());
            pt.executeUpdate();
            set = true;

        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }


    public boolean validate(User login)
    {
        boolean status = false;
//
//        loadDriver(dbDriver);
//        Connection con = getConnection();

        String query = "select * from login where username = ? and password =?";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, login.getName());
            ps.setString(2, login.getPassword());
            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return status;
    }
}

