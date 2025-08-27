import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Studentmanagement{
   public static void main(String[] args){
      String URL = "jdbc:mysql://localhost:3306/vedant";
      String USER = "deepak";
      String PASSWORD = "Deepak1vedant@";
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the operation you want to perform : ");
      String operation = sc.next();
      try{
      //Database connection
      Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
      //Creating a user
      switch (operation) {
      case "insert":
            String insertSQL = "INSERT INTO students (name, age) VALUES (?,?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
            System.out.println("Enter the name of the student : ");
            String name = sc.next();
            insertStmt.setString(1, name);
            System.out.println("Enter the age of the student : ");
            int age = sc.nextInt();
            insertStmt.setInt(2, age);
            insertStmt.executeUpdate();
            System.out.println("Student named " + name + " inserted");
            break;
      
      //Reading a user
      case "read":
            String selectSQL = "SELECT * FROM students";
            PreparedStatement selectStmt = conn.prepareStatement(selectSQL);
            ResultSet rs = selectStmt.executeQuery();
            System.out.println("Students in table : ");
            while(rs.next()){
         System.out.println(rs.getInt("id") + "   " + rs.getString("name")  + "   "  + rs.getInt("age"));
         }
            break;
         
      
      //Updating a user
      case "update":
            String updateSQL = "UPDATE students SET age = ? WHERE name = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateSQL);
            System.out.println("Enter the name of the student whose age you want to update : ");
            String name2 = sc.next();
            updateStmt.setString(2, name2);
            System.out.println("Enter the new age of the student : ");
            int age2 = sc.nextInt();
            updateStmt.setInt(1, age2);
            int rowsUpdated = updateStmt.executeUpdate();
            System.out.println("\nUpdated rows : " + rowsUpdated);
            break;
      
      //Deleting a user
      
      case "delete":
            String deleteSQL = "DELETE FROM students WHERE name = ?";
            PreparedStatement deleteStmt = conn.prepareStatement(deleteSQL);
            System.out.println("Enter the name of the student to delete : ");
            String name3 = sc.next();
            deleteStmt.setString(1, name3);
            int rowsDeleted = deleteStmt.executeUpdate();
            System.out.println("Deleted rows : " + rowsDeleted);
            break;
      
      default:
      System.out.println("Invalid input");
      conn.close();
      }
      
      }
      catch (Exception e){
         e.printStackTrace();
      }
   }
}
