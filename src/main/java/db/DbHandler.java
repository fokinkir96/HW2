package db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public abstract class DbHandler{
    protected Properties config = new Properties();
    protected final String URL, USER, PASSWORD;

    public DbHandler(String path) throws IOException {
        config.load(this.getClassLoader(path));
        URL = config.getProperty("URL");
        USER = config.getProperty("USER");
        PASSWORD = config.getProperty("PASSWORD");
    }

    private InputStream getClassLoader(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public List<ArrayList<Integer>> getAll() throws SQLException {
        var result = new ArrayList<ArrayList<Integer>>();
        try {
            var dbConnection = this.getConnection();
            String sql = "SELECT id, parent_id FROM TREES";
            ResultSet allRows = dbConnection.createStatement().executeQuery(sql);
            while (allRows.next()) {
                var row = new ArrayList<Integer>();
                row.add(allRows.getInt("id"));
                row.add(allRows.getInt("parent_id"));
                result.add(row);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}
