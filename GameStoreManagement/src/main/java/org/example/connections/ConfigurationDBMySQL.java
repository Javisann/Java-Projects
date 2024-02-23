package org.example.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigurationDBMySQL {
    public static final String driver = "com.mysql.cj.jdbc.Driver";
    public static final String HOSTDB = "localhost";
    public static final String PUERTOMYSQL = "3306";
    public static final String NOMBREDB = "game_store";
    public static final String USUARIODB = "root";
    public static final String CLAVEDB = "";
    public static final String URLMYSQL = "jdbc:mysql://"+ HOSTDB +":"+PUERTOMYSQL + "/" + NOMBREDB;
    public static Connection connectionDB(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.err.println("No se ha encontrado el Driver: " + driver);
            System.exit(-1);
        }
        //---------------------------------------------------------------------------------
        try {
            return DriverManager.getConnection(URLMYSQL, USUARIODB, CLAVEDB);
        } catch (SQLException e) {
            System.err.println("Error al conectarse con la BBDD: " + NOMBREDB);
            return null;
        }
    }

}
