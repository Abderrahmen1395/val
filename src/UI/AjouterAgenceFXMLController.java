/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entites.Agence;
import Services.AgenceServices;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author challakh
 */
public class AjouterAgenceFXMLController implements Initializable {

    @FXML
    private TextField tffaxag;
    @FXML
    private TextField tftelephoneag;
    @FXML
    private TextField tfadresseag;
    @FXML
    private TextField tfmdpag;
    @FXML
    private TextField tfmailag;
    @FXML
    private TextField tfnomag;
    @FXML
    private Button btn_ajouterag;
    @FXML
    private Button retourbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        BooleanBinding booleanBinding = 
      (
        tffaxag.textProperty().isEqualTo("")).or(
        tftelephoneag.textProperty().isEqualTo("")).or(
        tfadresseag.textProperty().isEqualTo("")).or(
        tfmdpag.textProperty().isEqualTo("")).or(
        tfmailag.textProperty().isEqualTo("")).or(
        tfnomag.textProperty().isEqualTo(""));

    btn_ajouterag.disableProperty().bind(booleanBinding);
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        if(tftelephoneag.getText().length()!=8||tffaxag.getText().length()!=8){
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("information Dialog");
                alert2.setHeaderText(null);
                alert2.setContentText("Erreur dans le numero de telephone ou Fax");
                alert2.show();
            
        }else{
        
        try {
            AgenceServices as1=new AgenceServices();
            
           
            AgenceServices as=new AgenceServices();
            boolean b=false;
            if(validateEmaill()){
                b=true;
                        }
            else if(!validateEmaill()){b=false;}
            
            if(as.TrouveAgence(tfmailag.getText())||!b)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Erreur dans Email");
                alert.show();
            }
            else
            {
                 Agence a=new Agence(tfnomag.getText(), tfmailag.getText(), tfmdpag.getText(), tfadresseag.getText(), Integer.parseInt(tftelephoneag.getText()), Integer.parseInt(tffaxag.getText()));
            as.ajouterAgence(a);
            FXMLLoader loader=new FXMLLoader(getClass().getResource("SignIn.fxml"));
                       Parent root ;
        try {
            root=loader.load();
             btn_ajouterag.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("information Dialog");
                alert1.setHeaderText(null);
                alert1.setContentText("Compte ajouter en attente de validation");
                alert1.show();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AjouterAgenceFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }}

    @FXML
    private void retourmenu(ActionEvent event) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("SignIn.fxml"));
                       Parent root ;
        try {
            root=loader.load();
             retourbtn.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private boolean validateEmaill(){
Pattern p=Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
Matcher m=p.matcher(tfmailag.getText());
if(m.find()&&m.group().equals(tfmailag.getText())){
return true;}
else{
return false;}}
    
}
