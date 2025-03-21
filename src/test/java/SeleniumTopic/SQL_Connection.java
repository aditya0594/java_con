package SeleniumTopic;

import org.testng.annotations.Test;

import java.sql.*;

public class SQL_Connection {
    @Test(enabled = true)
    public void connection() throws ClassNotFoundException, SQLException {

        // Path to the SQLite database file
        String url = "jdbc:sqlite:C:\\SQL-for-testers-practice-site\\database.db";

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           /* String url = "jdbc:mysql://localhost:3306/your_database";
            String user = "your_username";
            String password = "your_password";*/
             connection = DriverManager.getConnection(url);
             // Create a statement object to execute the query
            Statement statement = connection.createStatement();
            // Execute a simple query and get the result set
            String query = "SELECT * FROM products ";
            ResultSet resultSet = statement.executeQuery(query);


            // Process the result set
            while (resultSet.next()) {
                // Replace "column_name" with the actual column name from your table
                String name = resultSet.getString("name");
                String productId = resultSet.getString("productId");
                System.out.println("Data from column: " + name);
                System.out.println("Data from column: " + productId);
            }
            // Close the result set and statement
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
