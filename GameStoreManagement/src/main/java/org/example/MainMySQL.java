package org.example;

import org.example.connections.ConfigurationDBMySQL;

import java.sql.Connection;
import java.util.Scanner;

import static org.example.repositories.CustomerDB.*;
import static org.example.repositories.GameDB.*;
import static org.example.repositories.SaleDB.*;

public class MainMySQL {
    public static Connection connection = ConfigurationDBMySQL.connectionDB();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //? CREATE TABLE
        createTableGame(connection);
        createTableCustomer(connection);
        createTableSale(connection);

        //? ALTER TABLE / ADD FOREIGN KEYS
        alterTable(connection, "ALTER TABLE sales ADD COLUMN customer_id INTEGER NOT NULL;");
        alterTable(connection, "ALTER TABLE sales ADD CONSTRAINT fk_customer_id FOREIGN KEY(customer_id) REFERENCES customers(id);");
        alterTable(connection, "ALTER TABLE sales ADD COLUMN game_id INTEGER NOT NULL;");
        alterTable(connection, "ALTER TABLE sales ADD CONSTRAINT fk_game_id FOREIGN KEY(game_id) REFERENCES games(id);");
        System.out.println("-------------------------------------------------------------------");

        //* MAIN

        int option = 0;
        System.out.println("\nBienvenido al programa de gestión de la tienda de juegos.");
        do {
            showMenu();
            System.out.print("Elige una opcion: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> searchData();
                case 2 -> insertData();
                case 3 -> updateData();
                case 4 -> deleteData();
                case 0 -> System.out.print("¡Que tenga un buen dia!");
                default -> System.err.println("Selecciona un numero valido");
            }
        } while (option != 0);
    }

    //* SUBMENUS
    //* SEARCH
    private static void searchData() {
        int option = 0;
        do {
            showSearchMenu();
            System.out.print("Elige una opcion: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> searchGamesData();
                case 2 -> searchCustomersData();
                case 3 -> searchSalesData();
                case 0 -> System.out.println(" ");
                default -> System.err.println("Selecciona un numero valido");
            }
        } while (option != 0);
    }
    private static void searchGamesData() {
        int option = 0;
        do {
            showSearchGamesMenu();
            System.out.print("Elige una opcion: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> showAllGames(connection);
                case 2 -> showGamesById(connection);
                case 3 -> showGamesByName(connection);
                case 0 -> System.out.println(" ");
                default -> System.err.println("Selecciona un numero valido");
            }
        } while (option != 0);
    }
    private static void searchCustomersData() {
        int option = 0;
        do {
            showSearchCustomersMenu();
            System.out.print("Elige una opcion: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> showAllCustomers(connection);
                case 2 -> showCustomersByName(connection);
                case 0 -> System.out.println(" ");
                default -> System.err.println("Selecciona un numero valido");
            }
        } while (option != 0);
    }
    private static void searchSalesData() {
        int option = 0;
        do {
            showSearchSalesMenu();
            System.out.print("Elige una opcion: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> showAllSales(connection);
                case 2 -> showSalesByGameName(connection);
                case 3 -> showSalesByCustomerName(connection);
                case 0 -> System.out.println(" ");
                default -> System.err.println("Selecciona un numero valido");
            }
        } while (option != 0);
    }
    //* INSERT
    private static void insertData() {
        int option = 0;
        do {
            showInsertMenu();
            System.out.print("Elige una opcion: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> addGames(connection);
                case 2 -> addCustomers(connection);
                case 3 -> addSales(connection);
                case 0 -> System.out.println(" ");
                default -> System.err.println("Selecciona un numero valido");
            }
        } while (option != 0);
    }
    //* UPDATE
    private static void updateData() {
        int option = 0;
        do {
            showUpdateMenu();
            System.out.print("Elige una opcion: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> updateGames();
                case 2 -> updateCostumers();
                case 3 -> updateSales();
                case 0 -> System.out.println(" ");
                default -> System.err.println("Selecciona un numero valido");
            }
        } while (option != 0);
    }
    public static void updateGames() {
        System.out.print("Escribe el ID del videojuego que quieres actualizar: ");
        Integer id = sc.nextInt();
        int option = 0;
        do {
            showUpdateGamesMenu();
            System.out.print("Elige una opcion: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> updateGameName(connection, id);
                case 2 -> updateGameStock(connection, id);
                case 0 -> System.out.println(" ");
                default -> System.err.println("Selecciona un numero valido");
            }
        } while (option != 0);
    }
    public static void updateCostumers() {
        System.out.print("Escribe el ID del cliente que quieres actualizar: ");
        Integer id = sc.nextInt();
        int option = 0;
        do {
            showUpdateCustomersMenu();
            System.out.print("Elige una opcion: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> updateCustomerName(connection, id);
                case 2 -> updateCustomerAddress(connection, id);
                case 0 -> System.out.println(" ");
                default -> System.err.println("Selecciona un numero valido");
            }
        } while (option != 0);
    }
    public static void updateSales() {
        System.out.print("Escribe el ID de la venta que quieres actualizar: ");
        Integer id = sc.nextInt();
        int option = 0;
        do {
            showUpdateSalesMenu();
            System.out.print("Elige una opcion: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> updateSalePrice(connection, id);
                case 2 -> updateSaleCustomerId(connection, id);
                case 3 -> updateSaleGameId(connection, id);
                case 0 -> System.out.println(" ");
                default -> System.err.println("Selecciona un numero valido");
            }
        } while (option != 0);
    }
    //* DELETE
    private static void deleteData() {
        int option = 0;
        do {
            showDeleteMenu();
            System.out.print("Elige una opcion: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> deleteGamesById(connection);
                case 2 -> deleteCustomersById(connection);
                case 3 -> deleteSalesById(connection);
                case 0 -> System.out.println(" ");
                default -> System.err.println("Selecciona un numero valido");
            }
        } while (option != 0);
    }
    //* MENUS
    private static void showMenu() {
        System.out.print("""
                ┌―――――――――――――――――――――――――――――――――――――――――――――――――――┐
                │    1 -> Consultar datos.                                                              │
                │    2 -> Insertar datos.                                                               │
                │    3 -> Actualizar datos.                                                             │
                │    4 -> Eliminar datos.                                                               │
                │    0 -> Salir.                                                                        │
                └―――――――――――――――――――――――――――――――――――――――――――――――――――┘
                """);
    }
    //* SEARCH
    private static void showSearchMenu() {
        System.out.print("""
                ┌―――――――――――――――――――――――――――――――――――――――――――――――――――┐
                │    1 -> Buscar Videojuegos.                                                           │
                │    2 -> Buscar Clientes.                                                              │
                │    3 -> Buscar Ventas.                                                                │
                │    0 -> Volver.                                                                       │
                └―――――――――――――――――――――――――――――――――――――――――――――――――――┘
                """);
    }
    private static void showSearchGamesMenu() {
        System.out.print("""
                ┌―――――――――――――――――――――――――――――――――――――――――――――――――――┐
                │    1 -> Mostrar TODOS.                                                                │
                │    2 -> Mostrar por ID.                                                               │
                │    3 -> Mostrar por NOMBRE.                                                           │
                │    0 -> Volver.                                                                       │
                └―――――――――――――――――――――――――――――――――――――――――――――――――――┘
                """);
    }
    private static void showSearchCustomersMenu() {
        System.out.print("""
                ┌―――――――――――――――――――――――――――――――――――――――――――――――――――┐
                │    1 -> Mostrar TODOS.                                                                │
                │    2 -> Mostrar por NOMBRE.                                                           │
                │    0 -> Volver.                                                                       │
                └―――――――――――――――――――――――――――――――――――――――――――――――――――┘
                """);
    }
    private static void showSearchSalesMenu() {
        System.out.print("""
                ┌―――――――――――――――――――――――――――――――――――――――――――――――――――┐
                │    1 -> Mostrar TODAS.                                                                │
                │    2 -> Mostrar por NOMBRE de Videojuego.                                             │
                │    3 -> Mostrar por NOMBRE de Cliente.                                                │
                │    0 -> Volver.                                                                       │
                └―――――――――――――――――――――――――――――――――――――――――――――――――――┘
                """);
    }
    //* INSERT
    private static void showInsertMenu() {
        System.out.print("""
                ┌―――――――――――――――――――――――――――――――――――――――――――――――――――┐
                │    1 -> Insertar Videojuegos.                                                         │
                │    2 -> Insertar Clientes.                                                            │
                │    3 -> Insertar Ventas.                                                              │
                │    0 -> Volver.                                                                       │
                └―――――――――――――――――――――――――――――――――――――――――――――――――――┘
                """);
    }
    //* UPDATE
    public static void showUpdateMenu() {
        System.out.print("""
                ┌―――――――――――――――――――――――――――――――――――――――――――――――――――┐
                │    1 -> Actualizar Videojuegos.                                                       │
                │    2 -> Actualizar Clientes.                                                          │
                │    3 -> Actualizar Ventas.                                                            │
                │    0 -> Volver.                                                                       │
                └―――――――――――――――――――――――――――――――――――――――――――――――――――┘
                """);
    }
    private static void showUpdateGamesMenu() {
        System.out.print("""
                ┌―――――――――――――――――――――――――――――――――――――――――――――――――――┐
                │    1 -> Actualizar nombre.                                                            │
                │    2 -> Actualizar stock.                                                             │
                │    0 -> Volver.                                                                       │
                └―――――――――――――――――――――――――――――――――――――――――――――――――――┘
                """);
    }
    private static void showUpdateCustomersMenu() {
        System.out.print("""
                ┌―――――――――――――――――――――――――――――――――――――――――――――――――――┐
                │    1 -> Actualizar nombre.                                                            │
                │    2 -> Actualizar direccion.                                                         │
                │    0 -> Volver.                                                                       │
                └―――――――――――――――――――――――――――――――――――――――――――――――――――┘
                """);
    }
    private static void showUpdateSalesMenu() {
        System.out.print("""
                ┌―――――――――――――――――――――――――――――――――――――――――――――――――――┐
                │    1 -> Actualizar precio.                                                            │
                │    2 -> Actualizar ID de cliente.                                                     │
                │    3 -> Actualizar ID de videojuego.                                                  │
                │    0 -> Volver.                                                                       │
                └―――――――――――――――――――――――――――――――――――――――――――――――――――┘
                """);
    }
    //* DELETE
    private static void showDeleteMenu() {
        System.out.print("""
                ┌―――――――――――――――――――――――――――――――――――――――――――――――――――┐
                │    1 -> Borrar Videojuegos.                                                         │
                │    2 -> Borrar Clientes.                                                            │
                │    3 -> Borrar Ventas.                                                              │
                │    0 -> Volver.                                                                       │
                └―――――――――――――――――――――――――――――――――――――――――――――――――――┘
                """);
    }
}