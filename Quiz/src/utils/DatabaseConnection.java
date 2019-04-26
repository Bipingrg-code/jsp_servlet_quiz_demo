package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by sharmi on 8/15/2018.
 */
public class DatabaseConnection {
    String username = "root";
    String password = "";

    String url = "jdbc:mysql://localhost:3306/demo";

    Connection connection = null;

    public DatabaseConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!!");
        } catch (SQLException e) {
            System.out.println("not connected");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public final PreparedStatement getPreparedStatement(String query) {
        try {
            PreparedStatement pstm = connection.prepareStatement(query);
            return pstm;
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return null;
    }

   }





















