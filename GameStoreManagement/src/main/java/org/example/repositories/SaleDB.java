package org.example.repositories;

import org.example.entities.Game;
import org.example.entities.Sale;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class SaleDB {

    public static Scanner sc = new Scanner(System.in);
    //* CREATE
    public static void createTableSale(Connection connection) {
        try {
            String query = "CREATE TABLE sales(id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                    "price DOUBLE NOT NULL);";
            Statement sentencia = connection.createStatement();
            sentencia.executeUpdate(query);
            System.out.println("Tabla SALES creada correctamente");
            sentencia.close();
        } catch (SQLException ex) {
            if (ex.getMessage().contains("already exists")) {
                System.err.println("La tabla SALES ya existe en la BD");
            } else {
                System.err.println(ex.getMessage());
            }
        }
    }
    //* ALTER
    public static void alterTable(Connection connection, String text) {
        try {
            String query = text;
            Statement sentencia = connection.createStatement();
            sentencia.executeUpdate(query);
            System.out.println("Tabla SALES actualizada");
        } catch (SQLException ex) {
            System.err.println("La tabla SALES ya ha sido actuializada");
        }
    }
    //* INSERT
    public static void addSales(Connection connection) {

        System.out.print("Escribe el precio: ");
        Double price = sc.nextDouble();
        System.out.print("Escribe el id del cliente: ");
        Integer idCustomer = sc.nextInt();
        sc.nextLine();
        System.out.print("Escribe el id del videojuego: ");
        Integer idGame = sc.nextInt();
        sc.nextLine();
        Sale sale = new Sale(price, idCustomer, idGame);

        String query = "INSERT INTO sales (price, customer_id, game_id) VALUES (?,?,?);";
        PreparedStatement sentencia = null;
        try {
            sentencia = connection.prepareStatement(query);
            sentencia.setDouble(1, sale.getPrice());
            sentencia.setInt(2, sale.getCustomer_id());
            sentencia.setInt(3, sale.getGame_id());
            sentencia.executeUpdate();
            System.out.println("Venta agregada con exito!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    //* SEARCH
    public static void showAllSales(Connection connection) {
        try {
            String query = "SELECT sales.*, customers.name as customer_name, games.name as game_name " +
                    "FROM sales " +
                    "INNER JOIN customers ON sales.customer_id = customers.id " +
                    "INNER JOIN games ON sales.game_id = games.id;";
            PreparedStatement sentencia = connection.prepareStatement(query);
            ResultSet result = sentencia.executeQuery();
            while (result.next()) {
                Integer id = result.getInt("id");
                Double price = result.getDouble("price");
                Integer customerId = result.getInt("customer_id");
                Integer gameId = result.getInt("game_id");
                String customerName = result.getString("customer_name");
                String gameName = result.getString("game_name");
                System.out.printf("""
                        Sale '%s':
                            Price -> %s
                            Customer:
                                ID -> %s
                                Name -> %s
                            Game:
                                ID -> %s
                                Name -> %s
                        ----------------------------------------------------------------------------
                        """, id, price, customerId,customerName, gameId, gameName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void showSalesByGameName(Connection connection) {
        System.out.print("Escribe el NOMBRE del videojuego: ");
        String nameQuery = sc.nextLine();
        try {
            String query = "SELECT sales.*, customers.name AS customer_name, games.name AS game_name " +
                    "FROM sales " +
                    "INNER JOIN customers ON sales.customer_id = customers.id " +
                    "INNER JOIN games ON sales.game_id = games.id " +
                    "WHERE games.name LIKE ?;";
            PreparedStatement sentencia = connection.prepareStatement(query);
            String textSearched = "%" + nameQuery + "%";
            sentencia.setString(1, textSearched);
            ResultSet result = sentencia.executeQuery();
            while (result.next()) {
                Integer id = result.getInt("id");
                Double price = result.getDouble("price");
                Integer customerId = result.getInt("customer_id");
                Integer gameId = result.getInt("game_id");
                String customerName = result.getString("customer_name");
                String gameName = result.getString("game_name");
                System.out.printf("""
                        Sale '%s':
                            Price -> %s
                            Customer:
                                ID -> %s
                                Name -> %s
                            Game:
                                ID -> %s
                                Name -> %s
                        ----------------------------------------------------------------------------
                        """, id, price, customerId,customerName, gameId, gameName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void showSalesByCustomerName(Connection connection) {
        System.out.print("Escribe el NOMBRE del cliente: ");
        String nameQuery = sc.nextLine();
        try {
            String query = "SELECT sales.*, customers.name AS customer_name, games.name AS game_name " +
                    "FROM sales " +
                    "INNER JOIN customers ON sales.customer_id = customers.id " +
                    "INNER JOIN games ON sales.game_id = games.id " +
                    "WHERE customers.name LIKE ?;";
            PreparedStatement sentencia = connection.prepareStatement(query);
            String textSearched = "%" + nameQuery + "%";
            sentencia.setString(1, textSearched);
            ResultSet result = sentencia.executeQuery();
            while (result.next()) {
                Integer id = result.getInt("id");
                Double price = result.getDouble("price");
                Integer customerId = result.getInt("customer_id");
                Integer gameId = result.getInt("game_id");
                String customerName = result.getString("customer_name");
                String gameName = result.getString("game_name");
                System.out.printf("""
                        Sale '%s':
                            Price -> %s
                            Customer:
                                ID -> %s
                                Name -> %s
                            Game:
                                ID -> %s
                                Name -> %s
                        ----------------------------------------------------------------------------
                        """, id, price, customerId,customerName, gameId, gameName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //* UPDATE
    public static void updateSalePrice(Connection connection, Integer id) {
        System.out.print("Escribe el precio nuevo: ");
        Double price = sc.nextDouble();
        sc.nextLine();
        try {
            String query = "UPDATE sales SET price=? WHERE id LIKE ?;";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setDouble(1, price);
            sentencia.setInt(2, id);
            sentencia.executeUpdate();
            System.out.println("¡Venta actualizada con exito!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateSaleCustomerId(Connection connection, Integer id) {
        System.out.print("Escribe el id del cliente nuevo: ");
        Integer customerId = sc.nextInt();
        sc.nextLine();
        try {
            String query = "UPDATE sales SET customer_id=? WHERE id LIKE ?;";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt(1, customerId);
            sentencia.setInt(2, id);
            sentencia.executeUpdate();
            System.out.println("¡Venta actualizada con exito!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateSaleGameId(Connection connection, Integer id) {
        System.out.print("Escribe el id del juego nuevo: ");
        Integer gameId = sc.nextInt();
        sc.nextLine();
        try {
            String query = "UPDATE sales SET game_id=? WHERE id LIKE ?;";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt(1, gameId);
            sentencia.setInt(2, id);
            sentencia.executeUpdate();
            System.out.println("¡Venta actualizada con exito!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //* DELETE
    public static void deleteSalesById(Connection connection) {
        System.out.print("Escribe el ID de la venta que quieras borrar: ");
        int idQuery = sc.nextInt();
        sc.nextLine();
        try {
            String query = "DELETE FROM sales WHERE id LIKE ?";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt(1, idQuery);
            sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
