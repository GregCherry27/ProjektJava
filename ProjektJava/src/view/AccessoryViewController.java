package view;

import database.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccessoryViewController extends Database{

    @FXML
    TextField txtNazwa;
    @FXML
    ListView lvlista;
    @FXML
    ListView lvlid;

    @FXML
    private void btnDodajAkcesorium() throws SQLException
    {
        String nazwa = txtNazwa.getText().trim();
        setString("accessory", nazwa);
        txtNazwa.clear();


        btnShowList();
    }

    @FXML
    private void btnShowList() throws SQLException
    {
            try {
                Connection conn = connectDatabase();
                Statement stm = conn.createStatement();

                //List<ResultSet> lista = new ArrayList<>();
                ResultSet res = stm.executeQuery("SELECT * FROM accessory");
                if (res == null) return;
                ObservableList<String> items = FXCollections.observableArrayList();
                ObservableList<String> itemsID = FXCollections.observableArrayList();
                while (res.next())
                {
                    //lista.add(res);
                    itemsID.add(res.getString(1));
                    lvlid.setItems(itemsID);
                    items.add(res.getString(2));
                    lvlista.setItems(items);
                }
            }
            catch(Exception ex)
            {
                System.out.println("Blad getTable(): "+ex);
            }
        }
}