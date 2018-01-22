package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Product;
import model.Repository;

import java.io.IOException;
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

    private Stage mainStage;

    public void setMainStage(Stage pr)
    {
        mainStage = pr;
    }

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

    @FXML
    public void Exit()
    {
        mainStage.close();
    }

    @FXML
    public void Home()
    {
        try {
            mainWindow.showMainView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO: dokończyć
    @FXML
    public void editNameProduct() throws SQLException
    {
        TablePosition<Product, String> positionProduct = tableProduct.getSelectionModel().getSelectedCells().get(0);
        int row = positionProduct.getRow();
        String selectedName = String.valueOf( nameColumn.getCellObservableValue(row).getValue());
        String selectedTemp = String.valueOf( tempColumn.getCellObservableValue(row).getValue());
        String selectedDos = String.valueOf( dosageColumn.getCellObservableValue(row).getValue());
        String newName = nameTBox.getText().trim();
        updateString(selectedName, "product", newName);
        String newTemp = temperatureTBox.getText().trim();
        updateTemp(selectedTemp, "product", newTemp);
        String newDos = dosageTBox.getText().trim();
        updateDos(selectedDos, "product", newDos);

        refreshProduct();

        nameTBox.clear();
        temperatureTBox.clear();
        dosageTBox.clear();

    }
}

