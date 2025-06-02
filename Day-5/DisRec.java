import java.sql.*;

public class DisRec {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "admin@123";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        String selectQuery = "SELECT * FROM students";
        ResultSet resultSet = statement.executeQuery(selectQuery);

        System.out.println("ID\tName\tAge");

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");

            System.out.println(id + "\t" + name + "\t" + age);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
