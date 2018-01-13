package view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Accessory;
import model.Repository;

public class AccessoryWindowController extends Repository{

    @FXML
    TableView<Accessory> tableAccessory;
    @FXML
    TableColumn<Accessory, String> nameColumn;

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
}
