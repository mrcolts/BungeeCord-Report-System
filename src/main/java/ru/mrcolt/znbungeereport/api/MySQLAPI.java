package ru.mrcolt.znbungeereport.api;

import ru.mrcolt.znbungeereport.utils.MySQLUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLAPI {
    private static MySQLUtil mySQLUtil = new MySQLUtil();

    public static void connect() {
        mySQLUtil.connect();
    }

    public static void disconnect() {
        mySQLUtil.disconnect();
    }

    private static Connection getConnection() {
        return mySQLUtil.getConnection();
    }

    public static ResultSet get(String query) {
        try {
            return getConnection().createStatement().executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void execute(String query) {
        try {
            getConnection().createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
