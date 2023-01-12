/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Exequiel Hordt
 * @version 15 Nov 2022
 */
public abstract class DAO {

    protected Connection connection;
    protected ResultSet result;
    protected Statement statement;

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASES = "tienda";
    private final String DRIVER = "com.mysql.jdbc.Driver";

    protected void db_Connection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            String db_URL = "jdbc:mysql://localhost:3306/" + DATABASES + "?useSSL=false";
            connection = DriverManager.getConnection(db_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException exception) {
            throw exception;
        }

    }

    protected void db_disconnection() throws Exception {
        try {
            if (result != null) {
                result.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception exception) {
            throw exception;
        }
    }

    protected void crud(String query) throws Exception {
        try {
            db_Connection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (ClassNotFoundException | SQLException exception) {
            throw exception;
        } finally {
            db_disconnection();
        }

    }

    protected void query_db(String query) throws Exception {
        try {
            db_Connection();
            statement = connection.createStatement();
            result = statement.executeQuery(query);
        } catch (Exception exception) {
            throw exception;
        }
    }

}
