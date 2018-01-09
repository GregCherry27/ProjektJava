package view;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


public class MainWindow extends Application {
    private Stage primaryStage;
    private TabPane mainLayout;
    //private TitledPane anchor;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Database Application");

        showMainView();
        //showAccessoryView();
        /*FileInputStream input = new FileInputStream("resources/hqdefault.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        HBox hbox = new HBox(imageView);*/
    }

    private void showMainView() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainWindow.class.getResource("/view/MainWindow.fxml"));
        mainLayout = loader.load();
        MainWindowController mwc = loader.getController();
        mwc.setMainWindow(this);
        mwc.showProductTable();
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showAccessoryView() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        Pane mainItems = loader.load(MainWindow.class.getResource("/view/AccessoryView.fxml"));
        //mainLayout.setCenter(mainItems);
        Scene scene = new Scene(mainItems, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) throws SQLException
    {
        Application.launch(args);
    }
}