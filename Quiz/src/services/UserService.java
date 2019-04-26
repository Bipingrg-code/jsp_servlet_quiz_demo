package services;

import domain.User;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.*;

public class UserService {

    public User getUser(String username, String password) {
        User user = null;
        String query = "select * from user where username=? and password=?";

        DatabaseConnection db = new DatabaseConnection();
        PreparedStatement pstm = db.getPreparedStatement(query);

        try {
            pstm.setString(1, username);
            pstm.setString(2, password);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public User getUser(int id) {
        User user = null;
        String query = "select * from user where id=?";

        DatabaseConnection db = new DatabaseConnection();
        PreparedStatement pstm = db.getPreparedStatement(query);

        try {
            pstm.setInt(1, id);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    public List<User> getUserList(){
        List<User> userList = new ArrayList<User>();
        String query = "select * from user";

        DatabaseConnection db = new DatabaseConnection();
        PreparedStatement pstm = db.getPreparedStatement(query);

        try {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

                userList.add(user);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

      public void createuser(User user){
          String query = "insert into  user (username,password,role) values(?,?,?)";

          DatabaseConnection db = new DatabaseConnection();
          PreparedStatement pstm = db.getPreparedStatement(query);
          try{
              pstm.setString(1,user.getUserName());
              pstm.setString(2,user.getPassword());
              pstm.setString(3,user.getRole());
              pstm.execute();
          }catch(SQLException e){
              e.printStackTrace();
          }
          //return user;
      }
      public void updateUser(User user){
        String query = "update user set username=?,password=?,role=? where id=?";
          DatabaseConnection db = new DatabaseConnection();
          PreparedStatement pstm = db.getPreparedStatement(query);
          try{
              pstm.setString(1,user.getUserName());
              pstm.setString(2,user.getPassword());
              pstm.setString(3,user.getRole());
              pstm.setInt(4,user.getId());
              pstm.executeUpdate();
          }catch(SQLException e){
              e.printStackTrace();
          }
      }

       public void deleteuser(int id){
        String query = "delete  FROM user WHERE id=?";
           DatabaseConnection db = new DatabaseConnection();
           PreparedStatement pstm = db.getPreparedStatement(query);
           try {
               pstm.setInt(1,id);
               pstm.execute();
           }catch(SQLException e){
               e.printStackTrace();
           }
       }
       }
