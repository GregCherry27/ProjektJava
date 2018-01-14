package view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Product;
import model.Repository;

import java.sql.SQLException;

public class ProductWindowController extends Repository{

    @FXML
    TableView<Product> tableProduct;
    @FXML
    TableColumn<Product, String> nameColumn;
    @FXML
    TableColumn<Product, Double> tempColumn;
    @FXML
    TableColumn<Product, Double> dosageColumn;
    @FXML
    TextField nameTBox;
    @FXML
    TextField temperatureTBox;
    @FXML
    TextField dosageTBox;

    private view.MainWindow mainWindow;

    public void setMainWindow(view.MainWindow mWindow)
    {
        mainWindow = mWindow;
    }

    @FXML
    public void showProductTable()
    {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        tempColumn.setCellValueFactory(new PropertyValueFactory<>("temperature"));

        dosageColumn.setCellValueFactory(new PropertyValueFactory<>("dosage"));

        tableProduct.setItems(getProduct());
    }

    @FXML
    public void addProduct() throws SQLException
    {
        String name = nameTBox.getText().trim();
        Double temperature = Double.valueOf(temperatureTBox.getText());
        Double dosage = Double.valueOf(dosageTBox.getText());

        addProduct(name,temperature,dosage);

        refreshAccessories();
        nameTBox.clear();
        temperatureTBox.clear();
        dosageTBox.clear();
    }

   /* @FXML
    public void deleteAccessory() throws SQLException
    {
        TablePosition<Accessory, String> positionAccessory = tableAccessory.getSelectionModel().getSelectedCells().get(0);
        int row = positionAccessory.getRow();
        String selectedName = String.valueOf( nameColumn.getCellObservableValue(row).getValue());
        deleteRecord("accessory", selectedName);
        refreshAccessories();
    }

    @FXML
    public void editNameAccessory() throws SQLException
    {
        TablePosition<Accessory, String> positionAccessory = tableAccessory.getSelectionModel().getSelectedCells().get(0);
        int row = positionAccessory.getRow();
        String selectedName = String.valueOf( nameColumn.getCellObservableValue(row).getValue());
        String newName = editNameTBox.getText().trim();
        updateString(selectedName, "accessory", newName);
        refreshAccessories();
        editNameTBox.clear();
    }*/
}

