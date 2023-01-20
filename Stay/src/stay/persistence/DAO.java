package stay.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Exequiel Hordt
 * @version 13 Jan 2023
 */
public class DAO {

    protected Connection connection;
    protected Statement statement;
    protected ResultSet result;

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASES = "estancias_exterior";
    private final String DRIVER = "com.mysql.jdbc.Driver";

    //Connect DB
    public void connectDB() throws Exception {
        try {
            Class.forName(DRIVER);
            String url = "jdbc:mysql://localhost:3306/" + DATABASES + "?useSSL=false";
            connection = DriverManager.getConnection(url, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    //Disconnect DB
    public void disconnectDB() throws Exception {
        try {
            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (result != null) {
                result.close();
            }

        } catch (Exception e) {
            throw e;
        }
    }

    //CRUD
    public void crud(String query) throws Exception {
        try {

            connectDB();
            statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException e) {

            throw e;

        } finally {

            disconnectDB();

        }
    }

    // QUERY DB
    public void queryDB(String query) throws Exception {
        try {
            connectDB();
            statement = connection.createStatement();
            result = statement.executeQuery(query);
        } catch (Exception e) {
            throw e;
        }
    }
}
