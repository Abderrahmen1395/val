/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entites.Activite;
import Entites.Agence;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Services.ActiviteService;
import Services.AgenceServices;


/**
 * FXML Controller class
 *
 * @author challakh
 */
public class AjouterUneActiviteFXMLController implements Initializable {


    @FXML
    private Button btn_ajouteractiviter;
    @FXML
    private TextField tf_nomactivite;
    @FXML
    private TextField tf_typeactivite;
    @FXML
    private TextField tf_adresseactivite;
    @FXML
    private TextField tf_paysactivite;
    @FXML
    private TextField tf_regionactivite;
    @FXML
    private TextField tf_descriptionactivite;
    @FXML
    private TextField tf_prixactivite;
public int a;
    @FXML
    private TextField dispo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BooleanBinding booleanBinding = 
      (
        tf_nomactivite.textProperty().isEqualTo("")).or(
        tf_typeactivite.textProperty().isEqualTo("")).or(
        tf_adresseactivite.textProperty().isEqualTo("")).or(
        tf_paysactivite.textProperty().isEqualTo("")).or(
        tf_regionactivite.textProperty().isEqualTo("")).or(
        tf_descriptionactivite.textProperty().isEqualTo("")).or(
        tf_prixactivite.textProperty().isEqualTo("")).or(
        dispo.textProperty().isEqualTo(""));
        
        
    btn_ajouteractiviter.disableProperty().bind(booleanBinding);
        
        
        
        btn_ajouteractiviter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(Integer.parseInt(dispo.getText())>=0&&Float.parseFloat(tf_prixactivite.getText())>=0){
                    Agence ab=new Agence();
                    AgenceServices aa= new AgenceServices();
                    try {
                        ab=aa.AgenceConnecte();
                    } catch (SQLException ex) {
                        Logger.getLogger(AjouterUneActiviteFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                            
                Activite a=new Activite(tf_nomactivite.getText(), tf_typeactivite.getText(), tf_adresseactivite.getText(), tf_paysactivite.getText(), tf_regionactivite.getText(),tf_descriptionactivite.getText(),Float.parseFloat(tf_prixactivite.getText()),ab.getId(),Integer.parseInt(dispo.getText()));
               ActiviteService as=new ActiviteService();
                    System.out.println(ab);
                    System.out.println(a);
                    try {
                        as.ajouteractivite(a);
                    } catch (SQLException ex) {
                        Logger.getLogger(AjouterUneActiviteFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     
                Alert alert0 = new Alert(Alert.AlertType.INFORMATION);
            alert0.setTitle("information Dialog");
            alert0.setHeaderText(null);
            alert0.setContentText("ajout avec succes ");
            alert0.show();
                }else if (Integer.parseInt(dispo.getText())<0||Float.parseFloat(tf_prixactivite.getText())<0){
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("information Dialog");
            alert1.setHeaderText(null);
            alert1.setContentText("disp ");
            alert1.show();
                }
            }
        });
        }

    @FXML
    private void zzzz(ActionEvent event) {
        
    }
}
          
                
