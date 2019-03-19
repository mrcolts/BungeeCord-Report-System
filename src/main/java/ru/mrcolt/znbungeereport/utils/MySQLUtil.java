package ru.mrcolt.znbungeereport.utils;

import ru.mrcolt.znbungeereport.api.ConfigAPI;
import ru.mrcolt.znbungeereport.api.LoggerAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLUtil {

    private Connection connection;

    public void connect() {
        if (!isConnected()) {
            try {
                String databaseUrl = String.format("jdbc:mysql://%s:%s/%s",
                        ConfigAPI.getMYSQL("host"),
                        ConfigAPI.getMYSQL("port"),
                        ConfigAPI.getMYSQL("database"));
                connection = DriverManager.getConnection(
                        databaseUrl,
                        ConfigAPI.getMYSQL("username"),
                        ConfigAPI.getMYSQL("password"));
                if (!connection.isClosed()) {
                    LoggerAPI.info("MYSQL successfully connected");
                } else {
                    LoggerAPI.info("Connection failed");
                }
            } catch (SQLException e) {
                LoggerAPI.warning("Error: " + e.getMessage());
            }

        }
    }

    public boolean isConnected() {
        return (connection != null);
    }

    public Connection getConnection() {return connection;}

    public void update(String query){
        if(isConnected()){
            try {
                connection.createStatement().execute(query);
            } catch (SQLException e) {
                LoggerAPI.warning(e.getMessage());
            }
        }
    }


    public void disconnect() {
        if (isConnected()) {
            try {
                connection.close();
                LoggerAPI.info("MYSQL successfully disconnected");
            } catch (SQLException e) {
                LoggerAPI.warning(e.getMessage());
            }
        }
    }


}
