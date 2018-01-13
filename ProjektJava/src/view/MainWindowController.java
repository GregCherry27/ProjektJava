package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Model;
import model.Repository;

public class MainWindowController extends Repository{


    @FXML
    TableView<Model> tableModel;
    @FXML
    TableColumn<Model, String> nameColumn;
    @FXML
    TableColumn<Model, String> surfaceColumn;
    @FXML
    TableColumn<Model, String> productColumn;
    @FXML
    TableColumn<Model, String> accessoryColumn;
    @FXML
    Button showBt;

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

        accessoryColumn.setCellValueFactory(new PropertyValueFactory<>("accessory"));

        tableModel.setItems(getModel());
    }
    /*@FXML
    public ProductWindowController productWindowController;
    @FXML
    public Window productWindow;

    /*@FXML
    public SurfaceWindowController surfaceWindowController;
    @FXML
    public Window surfaceWindow;*/

    /*@FXML
    public AccessoryWindowController accessoryWindowController;
    @FXML
    public Window accessoryWindow;*/







}
