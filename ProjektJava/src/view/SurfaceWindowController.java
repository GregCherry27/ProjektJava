package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Repository;
import model.Surface;

import java.io.IOException;
import java.sql.SQLException;

public class SurfaceWindowController extends Repository{

    @FXML
    TableView<Surface> tableSurface;
    @FXML
    TableColumn<Surface, String> nameColumn;
    @FXML
    TableColumn<Surface, String> commentsColumn;
    @FXML
    TextField nameTBox;
    @FXML
    TextArea commentTArea;

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
    public void showSurfaceTable()
    {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        commentsColumn.setCellValueFactory(new PropertyValueFactory<>("comments"));

        tableSurface.setItems(getSurface());
    }

    @FXML
    public void addSurface() throws SQLException
    {
        String name = nameTBox.getText().trim();
        if (name.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("UWAGA!");
            alert.setHeaderText(null);
            alert.setContentText("Nazwa powierzchni jest wymagana!");
            alert.showAndWait();
            return;
        }
        String comment = commentTArea.getText().trim();
        addSurface(name, comment);
        refreshSurface();
        nameTBox.clear();
        commentTArea.clear();
    }

    @FXML
    public void deleteSurface() throws SQLException
    {
        try {
            TablePosition<Surface, String> positionAccessory = tableSurface.getSelectionModel().getSelectedCells().get(0);
            int row = positionAccessory.getRow();
            String selectedName = String.valueOf(nameColumn.getCellObservableValue(row).getValue());
            deleteRecord("surface", selectedName);
            refreshSurface();
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

    @FXML
    public void editSurface() throws SQLException
    {
        TablePosition<Surface, String> positionProduct = tableSurface.getSelectionModel().getSelectedCells().get(0);
        int row = positionProduct.getRow();
        String selectedName = String.valueOf( nameColumn.getCellObservableValue(row).getValue());
        String selectedcomm = String.valueOf( commentsColumn.getCellObservableValue(row).getValue());
        String newName = nameTBox.getText().trim();
        updateString(selectedName, "surface", newName);
        String newcomm = commentTArea.getText().trim();
        updatecomm(selectedcomm, "surface", newcomm);


        refreshSurface();

        nameTBox.clear();
        commentTArea.clear();

    }




}
