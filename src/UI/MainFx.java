/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author challakh
 */
public class MainFx extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Parent root = null ;
        try {
            root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        } catch (IOException ex) {
           System.out.println(ex);
        }
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
