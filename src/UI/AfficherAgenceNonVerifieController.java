/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entites.Agence;
import Services.AdminService;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author challakh
 */
public class AfficherAgenceNonVerifieController implements Initializable {

    @FXML
    private TableView<Agence> tableau;
    @FXML
    private TableColumn<Agence, String> col_nom;
    @FXML
    private TableColumn<Agence, String> col_mail;
    @FXML
    private Button btn_accept;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            AdminService as=new AdminService();
            
            List<Agence> agences=as.getALLAgencesnNonVerifie();
            ObservableList obs;
            obs = FXCollections.observableArrayList(agences);
            tableau.setItems(obs);
            col_nom.setCellValueFactory(new  PropertyValueFactory<>("nom"));
            col_mail.setCellValueFactory(new PropertyValueFactory<>("email"));
            System.out.println(agences);
        } catch (SQLException ex) {
            Logger.getLogger(AfficherAgenceNonVerifieController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }    

    @FXML
    private void Accept(ActionEvent event) {
        try {
            try {
                Agence a =new Agence();
                a=tableau.getSelectionModel().getSelectedItem();
                AdminService as=new AdminService();
                as.VerifierCompteAgence(a.getId());
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("information Dialog");
                alert1.setHeaderText(null);
                alert1.setContentText("Compte verifié");
                alert1.show();
            } catch (SQLException ex) {
                Logger.getLogger(AfficherAgenceNonVerifieController.class.getName()).log(Level.SEVERE, null, ex);
            }
            AdminService as=new AdminService();
            
            List<Agence> agences=as.getALLAgencesnNonVerifie();
            ObservableList obs;
            obs = FXCollections.observableArrayList(agences);
            tableau.setItems(obs);
            col_nom.setCellValueFactory(new  PropertyValueFactory<>("nom"));
            col_mail.setCellValueFactory(new PropertyValueFactory<>("email"));
            System.out.println(agences);
        } catch (SQLException ex) {
            Logger.getLogger(AfficherAgenceNonVerifieController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
