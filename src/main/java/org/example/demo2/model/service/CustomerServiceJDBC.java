package org.example.demo2.model.service;

import org.example.demo2.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceJDBC implements ICustomerService {

    public static final String SELECT_FROM_CUSTOMER = "select * from customer;";
    public static final String INSERT_INTO_CUSTOMER_VALUE = "insert into customer value (?, ?, ?);";
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/c1023h1jdbc";
    public static final String ROOT = "root";
    public static final String PASSWORD = "123456@Abc";

    Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL,
                    ROOT,
                    PASSWORD);
            System.out.println("ket noi thanh cong");
        } catch (ClassNotFoundException e) {
            System.out.println("ket noi ko thanh cong");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("ket noi ko thanh cong");
            throw new RuntimeException(e);
        }
        return connection;
    }
    @Override
    public List<Customer> findAll() {
        List<Customer> c = new ArrayList<>();
//        return null;
        Connection connection = getConnection();
        try {
            PreparedStatement getAllQuery = connection.prepareStatement(SELECT_FROM_CUSTOMER);
            ResultSet resultSet = getAllQuery.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String dob = resultSet.getString(2);
                String address = resultSet.getString("address");
                Customer customer = new Customer(name, dob, address);
                c.add(customer);
            }
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
        return c;
    }

    @Override
    public void save(Customer c) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_CUSTOMER_VALUE);
            preparedStatement.setString(1, c.getName());
            preparedStatement.setString(2, c.getDateOfBirth());
            preparedStatement.setString(3, c.getAddress());
//            so ban ghi bi tac dong boi cau lenh
//            Tao moi -> 1 ban ghi
//            Xoa -> bao nhieu ban ghi -> tra ve ?
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customerList = new ArrayList<>();
       Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from customer where name=?;");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String nameOfResult = resultSet.getString("name");
                String dob = resultSet.getString("dob");
                String address = resultSet.getString("address");
                Customer customer = new Customer(nameOfResult, dob, address);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerList;
    }
}
