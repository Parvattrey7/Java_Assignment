import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/javatestdb";
        String user = "root";
        String password = "Parv";
        
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Successful");
            
            String sql = "INSERT INTO students (roll_number, student_name) VALUES (?, ?)";
            pstmt = con.prepareStatement(sql);
            
            pstmt.setInt(1, 12345);
            pstmt.setString(2, "Parv Attrey");
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Record Inserted");
            }

        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found.");
        } catch (SQLException e) {
            System.err.println("SQL Error occurred: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}