import java.sql.*;

public class jdbcDatabase {

    // adding appconfig file for hiding the url, username, and password of the database from the user
    private static final String URL = "jdbc:mysql://localhost:3306/foodapp";
    private static final String USER = "root";
    private static final String PASSWORD = "FoodApp$$81";
    private static Connection connection;
    private static String query = "select * from Recipe";

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);

                // using a sql query
                while (result.next()){
                    String data = "";
                    for (int i = 1; i <= 5; i++){
                        data += result.getString(i) + ":";
                    }
                    System.out.println(data);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
