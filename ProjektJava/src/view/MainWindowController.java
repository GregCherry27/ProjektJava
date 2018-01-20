package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Repository;

import java.io.IOException;

public class MainWindowController extends Repository{

    private view.MainWindow mainWindow;

    public void setMainWindow(view.MainWindow mWindow)
    {
        mainWindow = mWindow;
    }

    private Stage mainStage;

    public void setMainStage(Stage pr)
    {
        mainStage = pr;
    }

    private BorderPane mainBorderPane;

    public void setMainBorderPane(BorderPane bp)
    {
        mainBorderPane = bp;
    }

    @FXML
    public void showProductView() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(view.MainWindow.class.getResource("/view/ProductWindow.fxml"));
        AnchorPane mainItems = loader.load();
        ProductWindowController pwc = loader.getController();
        pwc.setMainWindow(mainWindow);
        pwc.showProductTable();
        mainBorderPane.setCenter(mainItems);
    }

    @FXML
    public void showAccessoryView() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(view.MainWindow.class.getResource("/view/AccessoryWindow.fxml"));
        AnchorPane mainItems = loader.load();
        AccessoryWindowController awc = loader.getController();
        awc.setMainWindow(mainWindow);
        awc.showAccessoryTable();
        mainBorderPane.setCenter(mainItems);
    }

    @FXML
    public void showModelView() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(view.MainWindow.class.getResource("/view/ModelWindow.fxml"));
        AnchorPane mainItems = loader.load();
        ModelWindowController mwc = loader.getController();
        mwc.setMainWindow(mainWindow);
        mwc.showModelTable();
        mainBorderPane.setCenter(mainItems);
    }

    @FXML
    public void showSurfaceView() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(view.MainWindow.class.getResource("/view/SurfaceWindow.fxml"));
        AnchorPane mainItems = loader.load();
        SurfaceWindowController swc = loader.getController();
        swc.setMainWindow(mainWindow);
        swc.showSurfaceTable();
        mainBorderPane.setCenter(mainItems);
    }


}
