package za.co.dharriso.swingy.utils;

import java.sql.*;

public class DataBaseConnect{

    static String jdbcDriver = "com.mysql.jdbc.Driver";
    static String dbUrl = "jdbc:mysql://localhost:3306/swingy";

    static String user = "root";
    static String password = "password";

    Connection conn;
    Statement statement;

    public DataBaseConnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(dbUrl, user, password);
            statement = conn.createStatement();

            String createTable = "CREATE TABLE HEROS " +
                                "(id integer not NULL, " +
                                " name VARCHAR(255), " +
                                " type VARCHAR(255), " +
                                " attack INTEGER, " +
                                " defense  INTEGER, " +
                                " level  INTEGER, " +
                                " xp INTEGER, " +
                                " hitpoints INTEGER)";
            statement.executeQuery(createTable);
        }catch(SQLException e){
            System.out.println(e);
        }catch(Exception err){
            System.out.println(err);
        }
    }

}