package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Model;
import model.Pdftest;
import model.Repository;
import model.Surface;

import java.sql.SQLException;

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
    @FXML
    private ComboBox<String> cbSurface;
    @FXML
    private ComboBox<String> cbProduct;
    @FXML
    private ChoiceBox<String> cobAccessory;
    @FXML
    private TextField tfName;
    @FXML
    private Button btHome;
    @FXML
    private Button btExit;

    private view.MainWindow mainWindow;

    private ObservableList<Model> OlModel = getModel();


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

        tableModel.setItems(OlModel);

        fillComboBSurface();
        fillComboBProduct();
        fillChoiceAccessory();
    }

    public void fillComboBSurface() {

        ObservableList<String> srName = FXCollections.observableArrayList();
        String x;
        int size = getSurface().size();

        for(int i=0; i < size; ++i)
        {
           x = getSurface().get(i).getName();
            srName.add(i,x);
           cbSurface.setItems(srName);
        }
    }

    public void fillComboBProduct() {

        ObservableList<String> prName = FXCollections.observableArrayList();
        String x;
        int size = getProduct().size();

        for(int i=0; i < size; ++i)
        {
            x = getProduct().get(i).getName();
            prName.add(i,x);
            cbProduct.setItems(prName);
        }
    }

    public void fillChoiceAccessory()
    {
        ObservableList<String> acName = FXCollections.observableArrayList();
        String x;
        int size = getAccessory().size();

        for(int i=0; i < size; ++i)
        {
            x = getAccessory().get(i).getName();
            acName.add(i,x);
            cobAccessory.setItems(acName);
        }
    }

    @FXML
    public void addModel() throws SQLException
    {
            String nameModel = tfName.getText().trim();
            if (nameModel.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("UWAGA!");
                alert.setHeaderText(null);
                alert.setContentText("Nazwa modułu jest wymagana!");
                alert.showAndWait();
                return;
            }
            String surfaceModel = cbSurface.getSelectionModel().getSelectedItem().trim();
            String productModel = cbProduct.getSelectionModel().getSelectedItem().trim();
            String accessoryModel = cobAccessory.getSelectionModel().getSelectedItem().trim();

            addModel(nameModel, surfaceModel, productModel, accessoryModel);
            refreshModel();


        tfName.clear();
        cbSurface.getSelectionModel().clearSelection();
        cbProduct.getSelectionModel().clearSelection();
        cobAccessory.getSelectionModel().clearSelection();
    }

    @FXML
    public void deleteModel() throws SQLException {
        try {
            TablePosition<Surface, String> positionAccessory = tableModel.getSelectionModel().getSelectedCells().get(0);
            int row = positionAccessory.getRow();
            String selectedName = String.valueOf(nameColumn.getCellObservableValue(row).getValue());
            deleteRecord("model", selectedName);
            refreshModel();
        }catch(Exception ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("UWAGA!");
            alert.setHeaderText(null);
            alert.setContentText("Wybierz element do usunięcia!");
            alert.showAndWait();
        }
    }

    @FXML
    public void generatePdf()
    {
        Pdftest.gen(OlModel);
        refreshModel();
    }
}