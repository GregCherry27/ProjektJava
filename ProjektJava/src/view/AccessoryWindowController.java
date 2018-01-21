package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Accessory;
import model.Repository;

import java.sql.SQLException;

public class AccessoryWindowController extends Repository{

    @FXML
    TableView<Accessory> tableAccessory;
    @FXML
    TableColumn<Accessory, String> nameColumn;
    @FXML
    TextField nameTBox;
    @FXML
    TextField editNameTBox;

    private MainWindow mainWindow;

    public void setMainWindow(MainWindow mWindow)
    {
        mainWindow = mWindow;
    }

    @FXML
    public void showAccessoryTable()
    {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        tableAccessory.setItems(getAccessory());
    }

    @FXML
    public void addAccessory() throws SQLException
    {
        String name = nameTBox.getText().trim();
        if (name.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("UWAGA!");
            alert.setHeaderText(null);
            alert.setContentText("Nazwa akcesorium jest wymagana!");
            alert.showAndWait();
            return;
        }
        setString("accessory", name);
        refreshAccessories();
        nameTBox.clear();
    }

    @FXML
    public void deleteAccessory() throws SQLException
    {
        try {
            TablePosition<Accessory, String> positionAccessory = tableAccessory.getSelectionModel().getSelectedCells().get(0);
            int row = positionAccessory.getRow();
            String selectedName = String.valueOf(nameColumn.getCellObservableValue(row).getValue());
            deleteRecord("accessory", selectedName);
            refreshAccessories();
        }catch (Exception ex)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("UWAGA!");
            alert.setHeaderText(null);
            alert.setContentText("Wybierz element do usunięcia!");
            alert.showAndWait();
        }
    }

    @FXML
    public void editNameAccessory() throws SQLException
    {
        TablePosition<Accessory, String> positionAccessory = tableAccessory.getSelectionModel().getSelectedCells().get(0);
        int row = positionAccessory.getRow();
        String selectedName = String.valueOf( nameColumn.getCellObservableValue(row).getValue());
        String newName = nameTBox.getText().trim();
        updateString(selectedName, "accessory", newName);
        refreshAccessories();
        nameTBox.clear();
    }
}
