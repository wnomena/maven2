package mada.firstp;

import javafx.application.Application;
import javafx.beans.binding.IntegerBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application{
     private Label label;
     private TextField input;
     private TextField input2;
     private Button bouton;
     public IntegerBinding integer;
     public object value;

    public void start(Stage primaryStage) throws Exception{
        VBox root = new VBox();
        value = new object();
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        label = new Label("La somme du calcul actuelle est de  : " + value.getSomme());
        input = new TextField("5");
        input2 = new TextField("20");
        bouton = new Button("Valider");
        root.getChildren().addAll(label,input,input2,bouton);
        bouton.setOnAction(new HandleBouton());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String args0){
        launch(args0);
    }
    public class HandleBouton implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent e){
           try {
                value.setSomme(Integer.parseInt(input.getText()) + Integer.parseInt(input2.getText()));
                label.setText("La somme du calcul actuelle est de : " + value.getSomme());
           } catch (Exception i) {
            System.out.println(i);
           }
        }
    }
} 