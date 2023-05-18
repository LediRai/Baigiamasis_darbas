package Zuza;

//import org.openqa.selenium.WebDriver;

import java.sql.*;

public class DbConnection {

    public static void main(String[] args) {
        //pirmas try prisijungimas tikrinamas, ar nera klaidu
        String url = "jdbc:postgresql://localhost/zuzaLentele";
        String user = "postgres";
        String password = "labas123";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String pirkiniuKrepselis = "CREATE TABLE pirkiniuKrepselis " +
                    "(id SERIAL PRIMARY KEY," +
                    "produkto_pavadinimas VARCHAR(250)," +
                    "Skelbimo_ID VARCHAR(250)," +
                    "kaina INT," +
                    "prekiu_likutis_sandelyje VARCHAR(250)," +
                    "paveiksliukas VARCHAR(250))";

            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(pirkiniuKrepselis);
                System.out.println("Sekmingai sukurtos lenteles");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static PreparedStatement prisijungimasPrieDB(String sql) {
        String url = "jdbc:postgresql://localhost/zuzaLentele";
        String user = "postgres";
        String password = "labas123";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            return pstmt;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static void testasDB() {
        String url = "jdbc:postgresql://localhost/zuzaLentele";
        String user = "postgres";
        String password = "labas123";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection to database established.");
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        }
    }
}