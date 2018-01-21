package eu.servermanager.dev.spigot.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private String host;
    private int port;
    private String database;
    private String user;
    private String password;
    private Connection connection;
    private Statement state;

    public Database(String host, int port, String database, String user, String passeword){
        this.database = database;
        this.host = host;
        this.password = passeword;
        this.port = port;
        this.user = user;
    }
    public void connect() throws SQLException, ClassNotFoundException {
        if (connection != null && !connection.isClosed()) {
            return;
        }

        synchronized (this) {
            if (connection != null && !connection.isClosed()) {
                return;
            }
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + this.host+ ":" + this.port + "/" + this.database, this.user, this.password);

        }
        try {
            Statement statement = connection.createStatement();
            state = statement;

        }catch(Exception e){}
    }

    public void disconnect() throws SQLException, ClassNotFoundException{
        if (connection != null && !connection.isClosed()) {
            return;
        }

        synchronized (this) {
            if (connection != null && !connection.isClosed()) {
                return;
            }
            connection.close();
        }
    }
    public Object get(String object, String table, String column, String columnvar){
        try{

            ResultSet rs = state.executeQuery("SELECT * FROM " + table + " WHERE " + column + " = " + columnvar);
            if (rs.next()) {
                return rs.getObject(object);
            }
        }
        catch (Exception localException) {}
        return null;
    }
}
