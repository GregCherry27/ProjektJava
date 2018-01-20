package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    public Connection connectDatabase() throws SQLException
    {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/projjava?requireSSL=false", "root", "");
    }

    public void setString(String tableName, String valueString) throws SQLException
    {
        try {
        Connection conn = connectDatabase();
        conn.createStatement().executeUpdate("INSERT INTO " + tableName + "(name) VALUES ('" + valueString +"')");
    } catch (Exception ex)
        {
            System.out.println("Błąd setString(): " + ex);
        }
    }

    public void setInt(String tableName, int valueInt) throws SQLException
    {
        try {
            Connection conn = connectDatabase();
            conn.createStatement().executeUpdate("INSERT INTO " + tableName + "(temperature) VALUES ('" + valueInt +"')");
        } catch (Exception ex)
        {
            System.out.println("Błąd setString(): " + ex);
        }
    }

    public void deleteRecord(String nameTable, String nameValue) throws SQLException
    {
        try {
            Connection conn = connectDatabase();
            conn.createStatement().executeUpdate("DELETE FROM " + nameTable + " WHERE name = '" + nameValue + "'");
        } catch (Exception ex)
        {
            System.out.println("Błąd deleteRecord(): " + ex);
        }
    }

    public String getString(String nameRecord, String nameTable) throws SQLException
    {
        String text = "";
        Connection conn = connectDatabase();
        ResultSet rs = conn.createStatement().executeQuery("SELECT " + nameRecord + " FROM " + nameTable);
        text = rs.getString(nameRecord);
        return text;
    }

    public void updateString(String nameRecord, String nameTable, String newValue) throws SQLException
    {
        Connection conn = connectDatabase();
        conn.createStatement().executeUpdate("UPDATE " + nameTable + " SET name = " + newValue + " WHERE name = " + nameRecord);
    }

    public void addProduct(String n, Double t, Double d) throws SQLException
    {
        Connection conn = connectDatabase();
        conn.createStatement().executeUpdate("INSERT INTO product VALUES ('" + n + "', " + t + ", " + d + ")");
    }

    public void addSurface(String name, String comment) throws SQLException
    {
        Connection conn = connectDatabase();
        conn.createStatement().executeUpdate("INSERT INTO surface VALUES ('" + name + "', '" + comment + "')");
    }

    public void addModel(String name, String surface, String product, String accessory) throws SQLException
    {
        Connection conn = connectDatabase();
        conn.createStatement().executeUpdate("INSERT INTO model VALUES ('" + name + "', '" + product + "', '" + accessory + "', '" + surface + "')");
    }
}





