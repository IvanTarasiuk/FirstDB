package main.java;
import java.sql.*;

public class FirstConnect {

    private final String url;


    public FirstConnect() {
        this.url = "jdbc:postgresql://127.0.0.1:5432/postgres";
    }

    public String[][] allSelect(String select) {

        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            System.err.println(e.getMessage());
            return new String[0][0];
        }

        final int ROW_SIZE = 5;
        final int COLUMN_SIZE = 3;

        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()
        ) {
            ResultSet result = statement.executeQuery(select);
            String[][] obj = new String[ROW_SIZE][COLUMN_SIZE];

            if (result.next()) {
                for (int i = 1; i <= ROW_SIZE; i++) {
                    for (int j = 0; j < COLUMN_SIZE; j++) {
                        obj[i - 1][j] = result.getString(j + 1);
                    }
                    result.next();
                }
            }

            return obj;
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            System.err.println(e.getMessage());
            return new String[0][0];
        }
    }
}