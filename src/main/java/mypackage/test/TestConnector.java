package mypackage.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import mypackage.connector.LocalConnector;
import java.sql.Statement;
import java.sql.ResultSet;

public class TestConnector {

    public static void main(String[] args) throws SQLException {

        try(
                Connection connection = LocalConnector.getLocalConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM alumnos LIMIT 1;");
        ) {
            
        System.out.println("\n==============================================");   
        System.out.println("======Conexion Local Establecida Correctamente========");
        System.out.println("==============================================\n");   

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
