package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
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
        if (name.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("UWAGA!");
            alert.setHeaderText(null);
            alert.setContentText("Nazwa produktu jest wymagana!");
            alert.showAndWait();
            return;
        }
        Double temperature = Double.valueOf(temperatureTBox.getText());
        Double dosage = Double.valueOf(dosageTBox.getText());
        addProduct(name,temperature,dosage);
        refreshProduct();
        nameTBox.clear();
        temperatureTBox.clear();
        dosageTBox.clear();
    }

    @FXML
    public void deleteProduct() throws SQLException
    {
        try {
            TablePosition<Product, String> positionAccessory = tableProduct.getSelectionModel().getSelectedCells().get(0);
            int row = positionAccessory.getRow();
            String selectedName = String.valueOf(nameColumn.getCellObservableValue(row).getValue());
            deleteRecord("product", selectedName);
            refreshProduct();
        }catch (Exception ex)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("UWAGA!");
            alert.setHeaderText(null);
            alert.setContentText("Wybierz element do usunięcia!");
            alert.showAndWait();
        }
    }

    //TODO: dokończyć
    /*@FXML
    public void editNameProduct() throws SQLException
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

