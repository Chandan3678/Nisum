import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateStudent {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "admin@123";

        int studentId = 1;              
        String newName = "Avinash Rath";

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "UPDATE students SET name = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, newName);
        preparedStatement.setInt(2, studentId);

        int rowsUpdated = preparedStatement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Student record updated successfully.");
        } else {
            System.out.println("No student found with the given ID.");
        }

        preparedStatement.close();
        connection.close();
    }
}
