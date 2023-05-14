package Zuza;

import org.openqa.selenium.WebDriver;

import java.sql.*;

public class DbConnection extends ZuzaDraiveriai {
    public DbConnection(WebDriver driver) {
        super(driver);
    }

    public static void main(String[] args) {
        //pirmas try prisijungimas tikrinamas, ar nera klaidu
        String url = "jdbc:postgresql://localhost/zuzaLentele";
        String user = "postgres";
        String password = "labas123";

        try {
            System.out.println("1");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement stmt = connection.createStatement();
            String pirkiniuKrepselis = "CREATE TABLE produktuKrepselis " +
                    "(id SERIAL PRIMARY KEY," +
                    "produkto_pavadinimas VARCHAR(250)," +
                    "Skelbimo_ID INT,"+
                    "kaina INT," +
                    "prekiu_likutis_sandelyje INT,"+
                    "paveiksliukas VARCHAR(250))";
//
//            String megstamiausiuSarasas = "CREATE TABLE megstamisusiuSarasas " +
//                    "(id SERIAL PRIMARY KEY," +
//                    "produkto_pavadinimas VARCHAR(250)," +
//                    "kaina INT," +
//                    "prekiu_likutis_sandelyje INT,"+
//                    "paveiksliukas VARCHAR(250))" ;;

            System.out.println("1.1");
            stmt.executeUpdate(pirkiniuKrepselis);
//            stmt.executeUpdate(megstamiausiuSarasas);
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(pirkiniuKrepselis);
//                statement.executeUpdate(megstamiausiuSarasas);
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

