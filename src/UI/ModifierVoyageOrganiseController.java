/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entites.VoyageOrganise;
import Services.ServiceVoyageOrganise;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class ModifierVoyageOrganiseController implements Initializable {

    @FXML
    private Button vide;
    @FXML
    private Button modifier;
    @FXML
    private Button annuler;
    @FXML
    private TextField nomagencem;
    @FXML
    private TextField idagencem;
    @FXML
    private TextField hotaelm;
    @FXML
    private TextField nbplacesm;
    @FXML
    private TextField villedestinationm;
    @FXML
    private TextField paysdestinationm;
    @FXML
    private TextField originem;
    @FXML
    private TextField prixvoyagem;
    @FXML
    private DatePicker dateretourm;
    @FXML
    private DatePicker datedepartm;

 public void setVoyageOrganise(VoyageOrganise h){
     
     int t=0;
                
      he=h;          
                
    
      this.prixvoyagem.setText(String.valueOf(he.getPrix_voyage()));
      
      this.originem.setText(he.getOrigine());
      this.paysdestinationm.setText(he.getPays_destination());
      this.villedestinationm.setText(he.getVille_destination());
      this.nbplacesm.setText(String.valueOf(he.getnb_places()));
      this.hotaelm.setText(he.getHotel());
      this.idagencem.setText(String.valueOf(he.getId_agence()));
      this.nomagencem.setText(he.getNom_agence());
      
}
    public static VoyageOrganise he;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        modifier.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
              ServiceVoyageOrganise sh=new ServiceVoyageOrganise();
        VoyageOrganise h=new VoyageOrganise();
        h.setPrix_voyage(Integer.parseInt(prixvoyagem.getText()));

        h.setOrigine(originem.getText());
        h.setPays_destination(paysdestinationm.getText());
        h.setVille_destination(villedestinationm.getText());
        h.setnb_places(Integer.parseInt(nbplacesm.getText()));
        h.setHotel(hotaelm.getText());
        h.setId_agence(Integer.parseInt(idagencem.getText()));
        h.setNom_agence(nomagencem.getText());
        
       
           if  (originem.getText().length() != 0&&prixvoyagem.getText().length() != 0&&paysdestinationm.getText().length() != 0&&villedestinationm.getText().length() != 0&&nbplacesm.getText().length() != 0&&hotaelm.getText().length() != 0&&idagencem.getText().length() != 0&&nomagencem.getText().length() != 0) {
        try {
            sh.modifierVoyageOrganise(h, he.getId());
            ((Node)event.getSource()).getScene().getWindow().hide();
        } catch (SQLException ex) {
            Logger.getLogger(ModifierVoyageOrganiseController.class.getName()).log(Level.SEVERE, null, ex);
        }}
           else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("fill all the fields");
            alert.show();
        }
      
            }
        });
        //button Precedent
        annuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("./GererVoyageOrganise.fxml"));
                       Parent root;
                       try {
                            root=loader.load();
                            annuler.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(GererVoyageOrganiseController.class.getName()).log(Level.SEVERE, null, ex);
                        }
    
};
        
    });
       
        vide.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 prixvoyagem.clear();
                   originem.clear();
                datedepartm.setValue(null);
                dateretourm.setValue(null);
                paysdestinationm.clear();
                villedestinationm.clear();
                nbplacesm.clear();
                hotaelm.clear();
                idagencem.clear();
                nomagencem.clear();
    
};
        
    });
    }    

    
}
