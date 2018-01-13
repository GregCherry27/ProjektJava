package view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Product;
import model.Repository;

public class ProductWindowController extends Repository{

    @FXML
    TableView<Product> tableProduct;
    @FXML
    TableColumn<Product, String> nameColumn;
    @FXML
    TableColumn<Product, Double> tempColumn;
    @FXML
    TableColumn<Product, Double> dosageColumn;

    private MainWindow mainWindow;

    public void setMainWindow(MainWindow mWindow)
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
}
