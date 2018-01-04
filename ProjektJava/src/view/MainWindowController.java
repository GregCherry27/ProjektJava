package view;

import javafx.fxml.FXML;


public class MainWindowController {

    private MainWindow mainWindow;

    public void setMainWindow(MainWindow mWindow)
    {
        mainWindow = mWindow;
    }
    @FXML
    private void handleButtonAction() throws Exception
    {
        mainWindow.showAccessoryView();
    }
}
