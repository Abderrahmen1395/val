/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Y520-I7-1TR-4G
 */
public class GererHebergementFXMLController implements Initializable {

    @FXML
    private Button listeh;
    @FXML
    private Button ajouterh;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ajouterh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("./AjouterHebergementFXML.fxml"));
                       Parent root;
                       try {
                            root=loader.load();
                            ajouterh.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(GererHebergementFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                        }
    
};
        
    });
        listeh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("./ListeHebergement.fxml"));
                       Parent root;
                       try {
                            root=loader.load();
                            listeh.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(GererHebergementFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                        }
    
};
        
    });
    }    
    
}
