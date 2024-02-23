package org.example.repositories;

import org.example.entities.Game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;
import static org.example.MainMySQL.*;

public class GameDB {

    public static Scanner sc = new Scanner(System.in);
    //* CREATE
    public static void createTableGame(Connection connection) {
        try {
            String query = "CREATE TABLE games(id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(30) NOT NULL, " +
                    "stock INTEGER NOT NULL, " +
                    "secondhand BOOLEAN NOT NULL);";
            Statement sentencia = connection.createStatement();
            sentencia.executeUpdate(query);
            System.out.println("Tabla GAMES creada correctamente");
            sentencia.close();
        } catch (SQLException ex) {
            if (ex.getMessage().contains("already exists")) {
                System.err.println("La tabla GAMES ya existe en la BD");
            } else {
                System.err.println(ex.getMessage());
            }
        }
    }
    //* INSERT
    public static void addGames(Connection connection) {
        System.out.print("Escribe el nombre: ");
        String name = sc.nextLine();
        System.out.print("Escribe el stock actual: ");
        Integer stock = sc.nextInt();
        sc.nextLine();
        System.out.print("¿Es de segunda mano?(SI/NO): ");
        String secondhand = sc.nextLine();
        Boolean secondHandBool = null;
        if(secondhand.equalsIgnoreCase("SI")){
            secondHandBool = true;
        } else if (secondhand.equalsIgnoreCase("NO")) {
            secondHandBool = false;
        } else {
            System.err.println("Respuesta no valida");
            exit(0);
        }
        Game game = new Game(name, stock, secondHandBool);

        String query = "INSERT INTO games (name, stock, secondhand) VALUES (?,?,?);";
        PreparedStatement sentencia = null;
        try {
            sentencia = connection.prepareStatement(query);
            sentencia.setString(1, game.getName());
            sentencia.setInt(2, game.getStock());
            sentencia.setBoolean(3, game.getSecondHand());
            sentencia.executeUpdate();
            System.out.println("¡Videojuego agregado con exito!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    //* SEARCH
    public static void showAllGames(Connection connection) {
        List<Game> games = new ArrayList<Game>();
        try {
            String query = "SELECT * " +
                    "FROM games;";
            PreparedStatement sentencia = connection.prepareStatement(query);
            ResultSet result = sentencia.executeQuery();
            while (result.next()) {
                Integer id = result.getInt("id");
                String name= result.getString("name");
                Integer stock = result.getInt("stock");
                Boolean secondhand = result.getBoolean("secondhand");
                Game game = new Game(id, name, stock, secondhand);
                games.add(game);
            }
            System.out.println("GAMES: ");
            games.stream()
                    .forEach(g -> System.out.print(g.toString()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void showGamesById(Connection connection) {
        System.out.print("Escribe el ID del videojuego que quieras buscar: ");
        int idQuery = sc.nextInt();
        sc.nextLine();
        try {
            String query = "SELECT * " +
                    "FROM games " +
                    "WHERE id LIKE ?;";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt(1, idQuery);
            ResultSet result = sentencia.executeQuery();
            while (result.next()) {
                Integer id = result.getInt("id");
                String name= result.getString("name");
                Integer stock = result.getInt("stock");
                Boolean secondhand = result.getBoolean("secondhand");
                Game game = new Game(id, name, stock, secondhand);
                System.out.print(game.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void showGamesByName(Connection connection) {
        System.out.print("Escribe el NOMBRE del videojuego que quieras buscar: ");
        String nameQuery = sc.nextLine();
        try {
            String query = "SELECT * " +
                    "FROM games " +
                    "WHERE name LIKE ?;";
            PreparedStatement sentencia = connection.prepareStatement(query);
            String textSearched = "%" + nameQuery + "%";
            sentencia.setString(1, textSearched);
            ResultSet result = sentencia.executeQuery();
            while (result.next()) {
                Integer id = result.getInt("id");
                String name= result.getString("name");
                Integer stock = result.getInt("stock");
                Boolean secondhand = result.getBoolean("secondhand");
                Game game = new Game(id, name, stock, secondhand);
                System.out.print(game.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //* UPDATE
    public static void updateGameName(Connection connection, Integer id) {
        System.out.print("Escribe el nombre nuevo: ");
        String name = sc.nextLine();
        try {
            String query = "UPDATE games SET name=? WHERE id LIKE ?;";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setString(1, name);
            sentencia.setInt(2, id);
            sentencia.executeUpdate();
            System.out.println("¡Videojuego actualizado con exito!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateGameStock(Connection connection, Integer id) {
        System.out.print("Escribe el stock nuevo: ");
        Integer stock = sc.nextInt();
        sc.nextLine();
        try {
            String query = "UPDATE games SET stock=? WHERE id LIKE ?;";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt(1, stock);
            sentencia.setInt(2, id);
            sentencia.executeUpdate();
            System.out.println("¡Videojuego actualizado con exito!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //* DELETE
    public static void deleteGamesById(Connection connection) {
        System.out.print("Escribe el ID del videojuego que quieras borrar: ");
        int idQuery = sc.nextInt();
        sc.nextLine();
        try {
            String query = "DELETE FROM games WHERE id LIKE ?";
            PreparedStatement sentencia = connection.prepareStatement(query);
            sentencia.setInt(1, idQuery);
            sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
