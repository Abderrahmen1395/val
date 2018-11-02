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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author challakh
 */
public class UtilOuAgenceFXMLController implements Initializable {

    @FXML
    private Button btn_ut;
    @FXML
    private Button btn_ag;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goutilisateur(ActionEvent event) {
         FXMLLoader loader=new FXMLLoader(getClass().getResource("AjouterUtilisateurFXML.fxml"));
                       Parent root ;
        
        try {
            root=loader.load();
                         btn_ut.getScene().setRoot(root);

        } catch (IOException ex) {
            Logger.getLogger(UtilOuAgenceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void goagence(ActionEvent event) {
        try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("AjouterAgenceFXML.fxml"));
            Parent root ;
            
            root=loader.load();
            btn_ag.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(UtilOuAgenceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
