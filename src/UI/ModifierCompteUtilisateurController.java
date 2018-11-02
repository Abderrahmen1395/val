/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entites.Agence;
import Entites.Utilisateur;
import Services.AgenceServices;
import Services.UtilisateurServices;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author challakh
 */
public class ModifierCompteUtilisateurController implements Initializable {

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
    private Button btn_modifierut;
    @FXML
    private TextField tfsexeut;
    @FXML
    private Button Retourbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Utilisateur a=new Utilisateur();
            UtilisateurServices us=new UtilisateurServices();
            
            a=us.UserConnecte();
            tfnomut.setText(a.getNomu());
            tfprenomut.setText(a.getPrenomu());
            tfmailut.setText(a.getEmailu());
            tfmdput.setText(a.getMdpu());
            tfsexeut.setText(a.getSexeu());
            tfadresseut.setText(a.getAdresseu());
            tftelephoneut.setText(a.getTelephoneu()+"");
        } catch (SQLException ex) {
            Logger.getLogger(ModifierCompteUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }    

    @FXML
    private void modifier(ActionEvent event) {
        try {
            Utilisateur a=new Utilisateur();
            Utilisateur a1=new Utilisateur();
            UtilisateurServices us =new UtilisateurServices();
            a=us.UserConnecte();
            a1.setNomu(tfnomut.getText());
            a1.setPrenomu(tfprenomut.getText());            
            a1.setEmailu(tfmailut.getText());
            a1.setMdpu(tfmdput.getText());
            a1.setSexeu(tfsexeut.getText());            
            a1.setAdresseu(tfadresseut.getText());
            a1.setTelephoneu(Integer.parseInt(tftelephoneut.getText()));
            us.modifierUtilisateur(a1, a.getIdu());
        } catch (SQLException ex) {
            Logger.getLogger(ModifierCompteUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void RetourMenu(ActionEvent event) {
    }
    
}
