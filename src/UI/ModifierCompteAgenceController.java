/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entites.Agence;
import Services.AgenceServices;
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
public class ModifierCompteAgenceController implements Initializable {

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
    private Button btn_modifierag;
    @FXML
    private Button retourbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Agence a=new Agence();
            AgenceServices as=new AgenceServices();
            
            a=as.AgenceConnecte();
         tfnomag.setText(a.getNom());
      tfmailag.setText(a.getEmail());
      tfmdpag.setText(a.getMdp());
      tfadresseag.setText(a.getAdresse());
      tftelephoneag.setText(a.getTelephone()+"");
      tffaxag.setText(a.getFax()+"");
      
            
        } catch (SQLException ex) {
            Logger.getLogger(ModifierCompteAgenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
            // TODO
      
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        try {
            Agence a=new Agence();
            Agence a1=new Agence();
            AgenceServices as =new AgenceServices();
            a=as.AgenceConnecte();
            a1.setNom(tfnomag.getText());
            a1.setEmail(tfmailag.getText());
            a1.setMdp(tfmdpag.getText());
            a1.setAdresse(tfadresseag.getText());
            a1.setTelephone(Integer.parseInt(tftelephoneag.getText()));
            a1.setFax(Integer.parseInt(tffaxag.getText()));
            as.modifierAgence(a1, a.getId());
        } catch (SQLException ex) {
            Logger.getLogger(ModifierCompteAgenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @FXML
    private void retourmenu(ActionEvent event) {
        
    }
    
}
