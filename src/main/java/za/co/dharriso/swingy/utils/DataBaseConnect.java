package za.co.dharriso.swingy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBaseConnect{
    private Connection conn;
    private Statement statement;

    public DataBaseConnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://http://localhost:3000", "root", "password");
            createDB();
            createTable();
        } catch(Exception e){
            System.out.println("Error trying to connect to database: " + e);
        }
    }

    private void createDB(){
        String createTable = "CREATE DATABASE IF [IF NOT EXISTS] swingy";
        try{
            statement = conn.createStatement();
            statement.executeUpdate(createTable);
        } catch(Exception e){
            System.out.println("Error creating database: " + e);
        }
    }

    private void createTable(){
        // String query = "Create DATABASE IF NOT EXISTS swingy()";
        String createTable = "CREATE TABLE IF NOT EXIST swingy.hero" +
				"(id INTEGER(11) NOT NULL AUTO_INCREMENT PRIMARY KEY , " +
				"attack INTEGER(11) NOT NULL , " +
				"defense INTEGER(11) NOT NULL ," +
				"hp INTEGER(11) NOT NULL ," +
				"lvl INTEGER(11) NOT NULL ," +
				"xp INTEGER(11) NOT NULL ," +
				"name VARCHAR(50) NOT NULL ," +
                "type VARCHAR(50) NOT NULL) ,";
        try{
            statement.executeQuery(createTable);
        }
        catch(Exception e){
            System.out.print("Error creating database table: " + e);
        }
    }
}