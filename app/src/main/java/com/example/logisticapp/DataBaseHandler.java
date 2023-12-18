package com.example.logisticapp;
import java.sql.*;


public class DataBaseHandler extends configs{

    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,dbUser, dbPass);
        return dbConnection;
    }

     public void signUpUser(User user) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_NAME + "," + Const.USERS_PASSWORD + "," + Const.USERS_EMAIL + ")" + "VALUES(?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getName());
            prSt.setString(2, user.getPassword());
            prSt.setString(3, user.getEmail());
            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
