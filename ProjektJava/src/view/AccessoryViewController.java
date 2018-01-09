package view;

import database.Database;

public class AccessoryViewController extends Database{

    /*@FXML
    TextField txtNazwa;
    @FXML
    TableView<Accessory> tvAccessory;
    @FXML
    TableColumn<Accessory, String> columnTb;

    /*@FXML
    private void btnDodajAkcesorium() throws SQLException
    {
        String nazwa = txtNazwa.getText().trim();
        setString("accessory", nazwa);
        txtNazwa.clear();
        //btnShowList();
    }*/

    /*@FXML
    private void btnShowList() throws SQLException
    {
            try {
                Connection conn = connectDatabase();
                Statement stm = conn.createStatement();

                ResultSet res = stm.executeQuery("SELECT name FROM accessory");
                if (res == null) return;
                while (res.next()) {
                    String name = res.getString("name");
                    ObservableList<Accessory> items = FXCollections.observableArrayList(new Accessory(name));
                    columnTb.setCellValueFactory(new PropertyValueFactory<>("Kategoria"));
                    tvAccessory.setItems(items);
                }

            }
            catch(Exception ex)
            {
                System.out.println("Blad getTable(): "+ex);
            }
        }*/
}