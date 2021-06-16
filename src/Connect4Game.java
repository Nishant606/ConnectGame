import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Connect4Game extends Application
{
        private Controller controller;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("game_layout.fxml"));
        GridPane rGridPane=loader.load();


        controller = loader.getController();
        controller.createPlayground();

           MenuBar menuBar=createMenu();
           menuBar.prefWidthProperty().bind(stage.widthProperty());

           Pane menuPane=(Pane) rGridPane.getChildren().get(0);
           menuPane.getChildren().add(menuBar);

        Scene scene=new Scene(rGridPane);


        stage.setScene(scene);
        stage.setTitle("Connect4");
        stage.setResizable(false);
        stage.show();
    }

    private MenuBar createMenu()
    {
        //file menu
        Menu fileMenu=new Menu("File");

        MenuItem newGame=new MenuItem("New Game");
        
        newGame.setOnAction(actionEvent -> controller.resetGame());
        
        MenuItem resetGame=new MenuItem("Reset Game");
        resetGame.setOnAction(actionEvent -> controller.resetGame());
        SeparatorMenuItem separator=new SeparatorMenuItem();
        MenuItem exitGame=new MenuItem("Exit Game");
        exitGame.setOnAction(actionEvent -> exitGame());
        fileMenu.getItems().addAll(newGame,resetGame,separator,exitGame);

       //help menu

        Menu helpMenu=new Menu("Help");

        MenuItem aboutGame=new MenuItem("About Connect4");
        aboutGame.setOnAction(actionEvent -> aboutConnect4());

        SeparatorMenuItem separator2=new SeparatorMenuItem();
        MenuItem aboutMe=new MenuItem("About Me");
        aboutMe.setOnAction(actionEvent -> aboutDev());

        helpMenu.getItems().addAll(aboutGame,separator2,aboutMe);

        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;

    }

    private void aboutDev() {
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About the Developer");
        alert.setHeaderText("Nishant Patil");
        alert.setContentText("I love to code and this Application is  developed by me.I am learning more creative ways to develop an Application and soon I will be an expert in Application Development.");
        alert.show();
    }

    private void aboutConnect4() {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four");
        alert.setHeaderText("How to Play?");
        alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid." +
                " The pieces fall straight down, occupying the next available space within the column. " +
                "The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs." +
                " Connect Four is a solved game." +
                " The first player can always win by playing the right moves.");
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {
    }

    public static void main(String[] args) {

        launch(args);
    }

}
