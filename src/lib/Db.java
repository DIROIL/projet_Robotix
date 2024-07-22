package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import static javafx.scene.input.DataFormat.URL;

public class Db {



    private static Connection connection;


    public static Connection connect() {
        if (connection == null) {
        try {
            String URL = "jdbc:mysql://localhost:3306/robotix?serverTimezone=UTC";
            String user = "root";
            String password = "";

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,user,password);
            System.out.println("Connected to MySQL database");



        } catch (SQLException | ClassNotFoundException e) {

            System.out.println("Failed to connect to MySQL database");
            e.printStackTrace();

        }
        }
        return connection;
    }

}
