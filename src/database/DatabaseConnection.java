/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author dil
 */
public class DatabaseConnection {
    private static Connection connection = null;
    public static Statement statment;
    private static String database_name = "project_banking";
    private static String database_user = "root";
    private static String database_password = "";
    private static String database_host = "localhost";
    private static String database_port = "3306";
    private static String url = "jdbc:mysql://" + database_host + ":" + database_port + "/" + database_name;

   static 
  {
      try
      {
          connection = DriverManager.getConnection(url, database_name, database_password);
//          JOptionPane.showMessageDialog(null, "Connected Successfully");
            System.out.println("Connected Successfully");

      } catch (SQLException e) {
//          JOptionPane.showMessageDialog(null, "Error Connecting");
//          JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
          System.out.println("Error: " + e.getMessage());


      }
  }
   /**
 * 
 * @param String sql
 * @return ResultSet
 * @exception SQLException
 * 
 * This function is for creating sql select query and execute the query
 * This function returns the resultset of data from the database
 */
    public static ResultSet select(String sql) {
        ResultSet rs = null;
        try {
            statment = connection.createStatement();
            rs = statment.executeQuery(sql);

        } catch (SQLException e){
            
           System.out.println("Error: " + e.getMessage());
            }
            return rs;
        }
        

        /**
         * i = insert
         *  u = update
         * d = delete
         * @return int
         * @param sql
         */
        
        public static int iud(String sql){
            int result = 0;
            try {
                statment = connection.createStatement();
                result = statment.executeUpdate(sql);
                
            }catch(SQLException e){
                System.out.println("Error:" + e.getMessage());
            }
        
            return result;
        } 
        
       public static Connection getConnection() {
        return connection;
    }
    
}
