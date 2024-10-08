package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnector {

    private static final Logger logger = LoggerFactory.getLogger(DataBaseConnector.class);
    private static final String URL = "jdbc:mysql://localhost:3307/Employee_Crud";
    private static final String USER = "root";
    private static final String PASSWORD = "Girish@02";

    // Connection conn =
    private Connection connection;
    Connection conn = null;
    Statement statement = null;

    public DataBaseConnector() throws SQLException, ClassNotFoundException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            logger.info("Database connected successfully!");
        }catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Include it in your library path.");
            logger.error("Mysql jdbc driver not found"+e.getMessage());
        } catch (SQLException e) {
            System.err.println("Connection failed. Check output console.");
            logger.error("Mysql jdbc driver not found"+e.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                logger.info("Database connection closed.");
            } catch (SQLException e) {
                System.err.println("Failed to close the connection.");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DataBaseConnector db = new DataBaseConnector();
    }
}