

import java.sql.*;

public class PrepInsert {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "admin@123";

        Connection connection = DriverManager.getConnection(url, username, password);

        String insertQuery = "INSERT INTO PRODUCT (id, name, price) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

        preparedStatement.setInt(1, 1); 
        preparedStatement.setString(2, "aloo"); 
        preparedStatement.setDouble(3, 60.00); 

        int rowsInserted = preparedStatement.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("Product inserted successfully.");
        } else {
            System.out.println("Insertion failed.");
        }

        preparedStatement.close();
        connection.close();
    }
}
