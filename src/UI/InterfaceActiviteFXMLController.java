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
public class InterfaceActiviteFXMLController implements Initializable {

    @FXML
    private Button btn_goajout;
    @FXML
    private Button btn_goshow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goajout(ActionEvent event) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("AjouterUneActiviteFXML.fxml"));
            Parent root = null;
        try {
            root=loader.load();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceActiviteFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
              btn_goajout.getScene().setRoot(root);
    }

    @FXML
    private void goshow(ActionEvent event) {
          FXMLLoader loader=new FXMLLoader(getClass().getResource("AfficheractiviteFXML.fxml"));
            Parent root = null;
        try {
            root=loader.load();
        } catch (IOException ex) {
            Logger.getLogger(InterfaceActiviteFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
              btn_goshow.getScene().setRoot(root);
    }
    
}
