package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    public Connection connectDatabase() throws SQLException
    {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/projjava", "root", "");
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
        conn.createStatement().executeUpdate("UPDATE " + nameTable + " SET NAME = '" + newValue + "' WHERE name = '" + nameRecord +"'" );  //updatowanie akcesorium poprawion działa
    }
    public void updateTemp(String nameRecord, String nameTable, String newValue) throws SQLException
    {
        Connection conn = connectDatabase();
        conn.createStatement().executeUpdate("UPDATE " + nameTable + " SET temperature = '" + newValue + "' WHERE temperature = '" + nameRecord +"'" );
    }
    public void updateDos(String nameRecord, String nameTable, String newValue) throws SQLException
    {
        Connection conn = connectDatabase();
        conn.createStatement().executeUpdate("UPDATE " + nameTable + " SET dosage = '" + newValue + "' WHERE dosage = '" + nameRecord +"'" );
    }
    public void updatecomm(String nameRecord, String nameTable, String newValue) throws SQLException
    {
        Connection conn = connectDatabase();
        conn.createStatement().executeUpdate("UPDATE " + nameTable + " SET comments = '" + newValue + "' WHERE comments = '" + nameRecord +"'" );
    }
    public void updateModelSurf(String nameRecord, String nameTable, String newValue) throws SQLException
    {
        Connection conn = connectDatabase();
        conn.createStatement().executeUpdate("UPDATE " + nameTable + " SET surface = '" + newValue + "' WHERE surface = '" + nameRecord +"'" );
    }
    public void updateModelProd(String nameRecord, String nameTable, String newValue) throws SQLException
    {
        Connection conn = connectDatabase();
        conn.createStatement().executeUpdate("UPDATE " + nameTable + " SET product = '" + newValue + "' WHERE product = '" + nameRecord +"'" );
    }
    public void updateModelAcc(String nameRecord, String nameTable, String newValue) throws SQLException
    {
        Connection conn = connectDatabase();
        conn.createStatement().executeUpdate("UPDATE " + nameTable + " SET accessories = '" + newValue + "' WHERE accessories = '" + nameRecord +"'" );
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





