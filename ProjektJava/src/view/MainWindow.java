package view;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;


public class MainWindow extends Application {
    private Stage primaryStage;
    private BorderPane mainLayout;
    private AnchorPane windowTab;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Database Application");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        showMainView();
    }


    public void showMainView() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainWindow.class.getResource("/view/MainWindow.fxml"));
        mainLayout = loader.load();
        MainWindowController mwc = loader.getController();
        mwc.setMainWindow(this);
        mwc.setMainStage(primaryStage);
        mwc.setMainBorderPane(mainLayout);
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
        mainLayout.requestFocus();
    }

    public static void main(String[] args) throws SQLException
    {
        Application.launch(args);
    }
}