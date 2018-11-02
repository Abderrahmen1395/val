/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entites.Activite;
import static java.lang.Float.parseFloat;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import Services.ActiviteService;

/**
 * FXML Controller class
 *
 * @author challakh
 */
public class ModifierActiviteFXMLController implements Initializable {
public static Activite ab;

    @FXML
    private Button btn_modifieractivite;
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
    @FXML
    private TextField disp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public void setActivite(Activite a){
    ab=a;
    
      this.tf_nomactivite.setText(ab.getNom());
      this.tf_typeactivite.setText(ab.getType());
      this.tf_adresseactivite.setText(ab.getAdresse()+"");
      this.tf_paysactivite.setText(ab.getPays());
      this.tf_regionactivite.setText(ab.getRegion());
      this.tf_descriptionactivite.setText(ab.getDescription());
      this.tf_prixactivite.setText(ab.getPrix()+"");
      this.disp.setText(ab.getPlacedisponible()+"");
        BooleanBinding booleanBinding = 
      (
        tf_nomactivite.textProperty().isEqualTo("")).or(
        tf_typeactivite.textProperty().isEqualTo("")).or(
        tf_adresseactivite.textProperty().isEqualTo("")).or(
        tf_paysactivite.textProperty().isEqualTo("")).or(
        tf_regionactivite.textProperty().isEqualTo("")).or(
        tf_descriptionactivite.textProperty().isEqualTo("")).or(
        tf_prixactivite.textProperty().isEqualTo("")).or(
        disp.textProperty().isEqualTo(""));
        
        
    btn_modifieractivite.disableProperty().bind(booleanBinding);


      
   
}




    @FXML
    private void zzzz(ActionEvent event) {
        ActiviteService as=new ActiviteService();
        Activite a=new Activite();
    a.setNom(tf_nomactivite.getText());
    a.setType(tf_typeactivite.getText());
    a.setAdresse(tf_adresseactivite.getText());
    a.setRegion(tf_regionactivite.getText());
    a.setDescription(tf_descriptionactivite.getText());
    a.setPrix(parseFloat(tf_prixactivite.getText()));
    a.setPays(tf_paysactivite.getText());
    a.setPlacedisponible(Integer.parseInt(disp.getText()));
    if(Integer.parseInt(disp.getText())>=0&&Float.parseFloat(tf_prixactivite.getText())>=0){
    try {
        as.modifierActivite(a, ab.getId());
        Alert alert0 = new Alert(Alert.AlertType.INFORMATION);
            alert0.setTitle("information Dialog");
            alert0.setHeaderText(null);
            alert0.setContentText("modif avec succes ");
            alert0.show();
            ((Node)event.getSource()).getScene().getWindow().hide();
        
    } catch (SQLException ex) {
        Logger.getLogger(ModifierActiviteFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }else if (Integer.parseInt(disp.getText())<0||Float.parseFloat(tf_prixactivite.getText())<0){
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("information Dialog");
            alert1.setHeaderText(null);
            alert1.setContentText("disp ");
            alert1.show();
                }
    
            
    }
    
}
