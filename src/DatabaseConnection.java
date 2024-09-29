
import java.sql.*;


public class DatabaseConnection {
    
 
   static final String DB_URL = "jdbc:mysql://localhost:3333/hrms";
   static final String USER = "root";
   static final String PASS = "";
//   static final String QUERY = "SELECT firstname, lastname FROM Users";

   public static Connection connectDB() {
      // Open a connection
      Connection conn;        
      
      try { 
         conn = DriverManager.getConnection(DB_URL, USER, PASS);
         return conn;
         
      } 
      catch (SQLException e) {
         e.printStackTrace();
         return null;
      }
   }
}   
