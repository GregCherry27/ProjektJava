package view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Model;
import model.Repository;

public class ModelWindowController extends Repository{

    @FXML
    private TableView<Model> tableModel;
    @FXML
    private TableColumn<Model, String> nameColumn;
    @FXML
    private TableColumn<Model, String> surfaceColumn;
    @FXML
    private TableColumn<Model, String> productColumn;
    @FXML
    private TableColumn<Model, String> accessoryColumn;

    private view.MainWindow mainWindow;

    public void setMainWindow(view.MainWindow mWindow)
    {
        mainWindow = mWindow;
    }

    @FXML
    public void showModelTable()
    {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        surfaceColumn.setCellValueFactory(new PropertyValueFactory<>("surface"));

        productColumn.setCellValueFactory(new PropertyValueFactory<>("product"));

        accessoryColumn.setCellValueFactory(new PropertyValueFactory<>("accessories"));

        tableModel.setItems(getModel());
    }
}
