package view;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Repository;
import model.Surface;

public class SurfaceWindowController extends Repository{

    @FXML
    TableView<Surface> tableSurface;
    @FXML
    TableColumn<Surface, String> nameColumn;
    @FXML
    TableColumn<Surface, String> commentsColumn;

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
}
