package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Repository;
import model.Surface;

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
        String comment = commentTArea.getText().trim();
        addSurface(name, comment);
        refreshSurface();
        nameTBox.clear();
        commentTArea.clear();
    }

    @FXML
    public void deleteSurface() throws SQLException
    {
        TablePosition<Surface, String> positionAccessory = tableSurface.getSelectionModel().getSelectedCells().get(0);
        int row = positionAccessory.getRow();
        String selectedName = String.valueOf(nameColumn.getCellObservableValue(row).getValue());
        deleteRecord("surface", selectedName);
        refreshSurface();
    }
}
