/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entites.Agence;
import Entites.Utilisateur;
import Services.UtilisateurServices;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author challakh
 */
public class AjouterUtilisateurFXMLController implements Initializable {

    @FXML
    private TextField tftelephoneut;
    @FXML
    private TextField tfadresseut;
    @FXML
    private TextField tfmdput;
    @FXML
    private TextField tfmailut;
    @FXML
    private TextField tfprenomut;
    @FXML
    private TextField tfnomut;
    @FXML
    private Button btn_ajouterut;
    private RadioButton tfsexeut;
    @FXML
    private Button Retourbtn;
    @FXML
    private ToggleGroup sexe;
    @FXML
    private RadioButton homme;
    @FXML
    private RadioButton femme;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                BooleanBinding booleanBinding = 
      (
        tfadresseut.textProperty().isEqualTo("")).or(
        tfmdput.textProperty().isEqualTo("")).or(
        tfmailut.textProperty().isEqualTo("")).or(
        tfprenomut.textProperty().isEqualTo("")).or(
        tfnomut.textProperty().isEqualTo("")).or(
        tftelephoneut.textProperty().isEqualTo(""));

    btn_ajouterut.disableProperty().bind(booleanBinding);
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        if(tftelephoneut.getText().length()!=8){
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
                alert2.setTitle("information Dialog");
                alert2.setHeaderText(null);
                alert2.setContentText("Erreur dans le numero de telephone");
                alert2.show();
            
        }else{
        
        try {
            String rbb="";
        if(homme.isSelected()){
            rbb = "Homme";}
        else if(femme.isSelected()){
                        rbb = "Femme";}

            
            UtilisateurServices us=new UtilisateurServices();
            boolean b=false;
            if(validateEmaill()){
                b=true;
                        }
            else if(!validateEmaill()){b=false;}
            if(us.TrouveUtilisateur(tfmailut.getText())||!b)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Erreur dans Email");
                alert.show();
            }
            else
            { Utilisateur a=new Utilisateur(tfnomut.getText(), tfprenomut.getText(), tfmailut.getText(), tfmdput.getText(),rbb, tfadresseut.getText(),Integer.parseInt(tftelephoneut.getText()));
            us.ajouterUtilisateur(a);
            FXMLLoader loader=new FXMLLoader(getClass().getResource("SignIn.fxml"));
                       Parent root ;
        try {
            root=loader.load();
             btn_ajouterut.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("information Dialog");
                alert1.setHeaderText(null);
                alert1.setContentText("Compte ajouter avec succes");
                alert1.show();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AjouterUtilisateurFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         
    }}

    @FXML
    private void RetourMenu(ActionEvent event) {
         FXMLLoader loader=new FXMLLoader(getClass().getResource("SignIn.fxml"));
                       Parent root ;
        try {
            root=loader.load();
             Retourbtn.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

       private boolean validateEmaill(){
Pattern p=Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
Matcher m=p.matcher(tfmailut.getText());
if(m.find()&&m.group().equals(tfmailut.getText())){
return true;}
else{
return false;}}
}
