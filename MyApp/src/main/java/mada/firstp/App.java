package mada.firstp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application{
    private String WINDOW_SETTITLE = "Nomena Walker";
    @Override
    public void start(Stage primaryStage){
        try{
            primaryStage.initStyle(StageStyle.UNDECORATED);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PageDeCalcul.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root, 800, 400,Color.TRANSPARENT);
        scene.getStylesheets().add(getClass().getResource("file.css").toString());
        primaryStage.setTitle(WINDOW_SETTITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
        }catch(Exception e){
            System.out.println("Il y a une erreur quelques part !" + e);
        }
    }
    public static void main( String[] args){
        launch(args);
    }
}