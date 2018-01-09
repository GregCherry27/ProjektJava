package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Product;
import model.Repository;

public class MainWindowController extends Repository{

    private MainWindow mainWindow;

    @FXML
    TableView<Product> tableProduct;
    @FXML
    TableColumn<Product, String> nameColumn;
    @FXML
    TableColumn<Product, Double> tempColumn;
    @FXML
    TableColumn<Product, Double> dosageColumn;
    @FXML
    Button showBt;



    public void setMainWindow(MainWindow mWindow)
    {
        mainWindow = mWindow;
    }
    @FXML
    private void handleButtonAction() throws Exception
    {
        mainWindow.showAccessoryView();
    }

    @FXML
    public void showProductTable()
    {
        //Repository repository = new Repository();
        //repository.setRepository(repository);
        //repository.loadAll();
        //repository.getProduct();

        //Name column
        //tableProduct.setMinWidth(600);
        //nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Temperature column
        //tempColumn.setMinWidth(200);
        tempColumn.setCellValueFactory(new PropertyValueFactory<>("temperature"));

        //Dosage column
        //dosageColumn.setMinWidth(200);
        dosageColumn.setCellValueFactory(new PropertyValueFactory<>("dosage"));

        //tableProduct = new TableView<>();
        tableProduct.setItems(getProduct());
        //tableProduct.getColumns().addAll(nameColumn, tempColumn, dosageColumn);
    }

}
