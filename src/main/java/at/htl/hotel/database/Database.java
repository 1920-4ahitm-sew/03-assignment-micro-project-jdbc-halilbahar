package at.htl.hotel.database;

import at.htl.hotel.model.Customer;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

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

    public List<Customer> selectAllCustomer() {
        List<Customer> customerList = new LinkedList<>();

        try {
            PreparedStatement statement = this.connection.prepareStatement(
                    "SELECT CUSTOMER_ID, FIRST_NAME, LAST_NAME FROM CUSTOMER"
            );
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                customerList.add(new Customer(id, firstName, lastName));
            }
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;
    }
}