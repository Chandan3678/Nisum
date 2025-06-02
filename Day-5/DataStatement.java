import java.sql.*;

public class DataStatement {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "admin@123";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        String createTable = "CREATE TABLE IF NOT EXISTS students (" +
                             "id INT PRIMARY KEY, " +
                             "name VARCHAR(100), " +
                             "age INT)";
        statement.executeUpdate(createTable);

        String insert = "INSERT INTO students (id, name, age) VALUES (1, 'Avinash', 20)";
        int rowsInserted = statement.executeUpdate(insert);

        if (rowsInserted > 0) {
            System.out.println("Student inserted successfully.");
        } else {
            System.out.println("Insertion failed.");
        }

        statement.close();
        connection.close();
    }
}
