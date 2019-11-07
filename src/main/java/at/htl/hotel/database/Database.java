package at.htl.hotel.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String DRIVER_STRING = "org.apache.derby.jdbc.ClientDriver";
    private static final String CONNECTION_STRING = "jdbc:derby://localhost:1527/db;create=true";
    private static final String USER = "app";
    private static final String PASSWORD = "app";

    private Connection connection;

    private static Database instance;

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    private Database() {
        try {
            Class.forName(DRIVER_STRING);
            this.connection = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Could not open Connection to database: \n" + e.getMessage());
        }
    }
}