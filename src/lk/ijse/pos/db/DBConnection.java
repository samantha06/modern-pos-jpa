package lk.ijse.pos.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection(){
        try {

            File file = new File("resources/application.properties");
            FileInputStream is = new FileInputStream(file);

            Properties dbProp = new Properties();
            dbProp.load(is);

            String ip = dbProp.getProperty("ip");
            String port = dbProp.getProperty("port");
            String database = dbProp.getProperty("db");
            String user= dbProp.getProperty("user");
            String password = dbProp.getProperty("password");

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + database,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DBConnection getInstance(){
        if (dbConnection == null){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }

}
