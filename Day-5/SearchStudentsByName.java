import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class SearchStudentsByName {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter partial name to search: ");
        String partialName = scanner.nextLine();
        scanner.close();

        String url = "jdbc:mysql://localhost:3306/jdbc";
        String username = "root";
        String password = "admin@123";

        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = "SELECT id, name, age FROM students WHERE name LIKE ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "%" + partialName + "%");

        ResultSet rs = ps.executeQuery();

        System.out.println("ID\tName\tAge");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" +
                               rs.getString("name") + "\t" +
                               rs.getInt("age"));
        }

        rs.close();
        ps.close();
        connection.close();
    }
}
