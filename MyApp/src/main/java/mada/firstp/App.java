package mada.firstp;


import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.lang.Runnable;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application{
    //tout les variables et les instance afin que ce soit accessible n'importe  ou
    Thread ThreadP;
    Timer time;
    VBox box;
    Label label;
    String temp;
    String temp2;
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Pour facilité l'acces au données j'ai créé un objet pour les donné des heures
        object obj = new object();
        temp2 = obj.getMinute();
        temp = obj.getHeure();
        //Interface initiale
         label = new Label(temp +":"+ temp2);
        label.setFont(new javafx.scene.text.Font(50));
        box = new VBox();
        box.getChildren().addAll(label);
        box.setAlignment(Pos.CENTER);
        Scene root = new Scene(box);
        primaryStage.setScene(root);
        primaryStage.show();
        //Le  thread principale est fait pour l'interface  et  du coup on a créé un second thread pour récuperer les donner à tout moment
        Runnable myRunnable = new Runnable() {
            @Override
            public void run(){
                //Pour récupere lesdonnes tout les 1/2  de seconde set intervale  en JS
                Timer timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run(){
                        if (temp != Integer.toString(new Date().getHours())|| temp2 != Integer.toString(new Date().getMinutes())) {
                            temp = Integer.toString(new Date().getHours());
                            temp2 = Integer.toString(new Date().getMinutes());
                            //revenir dans le thread principale pour afficher le resultat
                            Platform.runLater(new Runnable(){
                                @Override
                                public void run(){
                                    label.setText(temp + ":" + temp2);
                                }
                            });
                            //Mbola mila amboarina le  ref chiffre en dessous de 0 de length 1 fotsiny nefa tokony atao 2;
                            //tokony  hiverina @thread principale de avy eo apetaka le nouelle element en le label;
                        }
                    }
                }, 0, 500);
            }            
        };
        //initier le second thread pour le traitement en parallele
      ThreadP = new Thread(myRunnable);
      ThreadP.start();
    }
    public static void main(String args){      
        launch(args);      
        //cool 
    }
}