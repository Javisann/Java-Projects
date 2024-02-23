package org.example.repositories;

import org.example.entities.Customer;
import org.example.entities.Game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class CustomerDB {

    public static Scanner sc = new Scanner(System.in);
    //* CREATE
    public static void createTableCustomer(Connection connection) {
        try {
            String query = "CREATE TABLE customers(id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(30) NOT NULL, " +
                    "address VARCHAR(100) NOT NULL);";
            Statement sentencia = connection.createStatement();
            sentencia.executeUpdate(query);
            System.out.println("Tabla CUSTOMERS creada correctamente");
            sentencia.close();
        } catch (SQLException ex) {
            if (ex.getMessage().contains("already exists")) {
                System.err.println("La tabla CUSTOMERS ya existe en la BD");
            } else {
                System.err.println(ex.getMessage());
            }
        }
    }
    //* INSERT
    public static void addCustomers(Connection connection) {

        System.out.print("Escribe el nombre: ");
        String name = sc.nextLine();
        System.out.print("Escribe la direccion: ");
        String address = sc.nextLine();
        Customer customer = new Customer(name, address);

        String query = "INSERT INTO customers (name, address) VALUES (?,?);";
        PreparedStatement sentencia = null;
        try {
            sentencia = connection.prepareStatement(query);
            sentencia.setString(1, customer.getName());
            sentencia.setString(2, customer.getAddress());
            sentencia.executeUpdate();
            System.out.println("Cliente agregado con exito!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    //* SEARCH
    public static void showAllCustomers(Connection connection) {
        List<Customer> customers = new ArrayList<Customer>();
        try {
            String query = "SELECT * " +
                    "FROM customers;";
            PreparedStatement sentencia = connection.prepareStatement(query);
            ResultSet result = sentencia.executeQuery();
            while (result.next()) {
                Integer id = result.getInt("id");
                String name= result.getString("name");
                String address = result.getString("address");
                Customer customer = new Customer(id, name, address);
                customers.add(customer);
            }
            System.out.println("CUSTOMERS: ");
            customers.stream()
                    .forEach(c -> System.out.print(c.toString()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void showCustomersByName(Connection connection) {
        System.out.print("Escribe el NOMBRE del cliente que quieras buscar: ");
        String nameQuery = sc.nextLine();
        try {
            String query = "SELECT * " +
                    "FROM customers " +
                    "WHERE name LIKE ?;";
            PreparedStatement sentencia = connection.prepareStatement(query);
            String textSearched = "%" + nameQuery + "%";
            sentencia.setString(1, textSearched);
            ResultSet result = sentencia.executeQuery();
            while (result.next()) {
                Integer id = result.getInt("id");
                String name = result.getString("name");
                String address = result.getString("address");
                Customer customer = new Customer(id, name, address);
                System.out.print(customer.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //* UPDATE
    public static void updateCustomerName(Connection connection, Integer id) {
        System.out.print("Escribe el nombre nuevo: ");
        String name = sc.nextLine();
        try {
            String query = "UPDATE customers SET name=? WHERE id LIKE ?;";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString(1, name);
            sentencia.setInt(2, id);
            sentencia.executeUpdate();
            System.out.println("¡Cliente actualizado con exito!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateCustomerAddress(Connection connection, Integer id) {
        System.out.print("Escribe la direccion nueva: ");
        String address = sc.nextLine();
        try {
            String query = "UPDATE customers SET address=? WHERE id LIKE ?;";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString(1, address);
            sentencia.setInt(2, id);
            sentencia.executeUpdate();
            System.out.println("¡Cliente actualizado con exito!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //* DELETE
    public static void deleteCustomersById(Connection connection) {
        System.out.print("Escribe el ID del cliente que quieras borrar: ");
        int idQuery = sc.nextInt();
        sc.nextLine();
        try {
            String query = "DELETE FROM customers WHERE id LIKE ?";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt(1, idQuery);
            sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
