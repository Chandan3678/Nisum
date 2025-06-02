import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "admin@123";

        Connection conn = DriverManager.getConnection(url, username, password);


        conn.setAutoCommit(false);

        String insertStudent = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
        String insertEnrollment = "INSERT INTO enrollments (student_id, course_id, semester, enrollment_date) VALUES (?, ?, ?, ?)";

        PreparedStatement psStudent = conn.prepareStatement(insertStudent);
        PreparedStatement psEnrollment = conn.prepareStatement(insertEnrollment);


        psStudent.setInt(1, 101);
        psStudent.setString(2, "John Doe");
        psStudent.setInt(3, 21);

        psEnrollment.setInt(1, 101);
        psEnrollment.setInt(2, 10); // Assume course_id 10 exists
        psEnrollment.setString(3, "Fall 2025");
        psEnrollment.setDate(4, Date.valueOf("2025-09-01"));


        int rowsStudent = psStudent.executeUpdate();
        int rowsEnrollment = psEnrollment.executeUpdate();


        if (rowsStudent == 1 && rowsEnrollment == 1) {
            conn.commit();
            System.out.println("Transaction committed successfully.");
        } else {
            conn.rollback();
            System.out.println("Transaction rolled back due to insert failure.");
        }

        // Close resources
        psStudent.close();
        psEnrollment.close();
        conn.close();
    }
}
