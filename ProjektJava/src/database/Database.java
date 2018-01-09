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

    public void setDouble(String tableName, double valueDouble) throws SQLException
    {
        try {
            Connection conn = connectDatabase();
            conn.createStatement().executeUpdate("INSERT INTO " + tableName + "(temperature) VALUES ('" + valueDouble +"')");
        } catch (Exception ex)
        {
            System.out.println("Błąd setString(): " + ex);
        }
    }

    /*public String getTable(String nameTable) throws SQLException
    {
        try
        {
            Connection conn = connectDatabase();
            Statement stm = conn.createStatement();

            List<ResultSet> lista = new ArrayList<>();
            ResultSet res = stm.executeQuery("SELECT * FROM "+ nameTable);
            if(res == null) return;
            while(res.next())
            {
                lista.add(res);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Blad getTable(): "+ex);
        }
    }*/

    private void deleteRecord(String nameTable, String nameValue) throws SQLException
    {
        try {
            Connection conn = connectDatabase();
            conn.createStatement().executeUpdate("DELETE FROM " + nameTable + " WHERE name = " + nameValue);
        } catch (Exception ex)
        {
            System.out.println("Błąd setString(): " + ex);
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
}





