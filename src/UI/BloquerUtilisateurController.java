/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;



import Entites.Utilisateur;
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
public class BloquerUtilisateurController implements Initializable {

    @FXML
    private TableView<Utilisateur> tableau;
    @FXML
    private TableColumn<Utilisateur, String> col_nom;
    @FXML
    private TableColumn<Utilisateur, String> col_mail;
    @FXML
    private Button btn_bloquer;
    @FXML
    private TableView<Utilisateur> tableau1;
    @FXML
    private TableColumn<Utilisateur, String> col_nom1;
    @FXML
    private TableColumn<Utilisateur, String> col_mail1;
    @FXML
    private Button btn_debloquer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            try {
                // TODO
                AdminService as=new AdminService();
                
                List<Utilisateur> utilisateurs=as.getALLUtilisateursNonbloque();
                ObservableList obs;
                obs = FXCollections.observableArrayList(utilisateurs);
                tableau.setItems(obs);
                col_nom.setCellValueFactory(new  PropertyValueFactory<>("nomu"));
                col_mail.setCellValueFactory(new PropertyValueFactory<>("emailu"));
                System.out.println(utilisateurs);
            } catch (SQLException ex) {
                Logger.getLogger(BloquerUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
            }
            AdminService as=new AdminService();
            List<Utilisateur> utilisateurs=as.getALLUtilisateursbloque();
            ObservableList obs;
            obs = FXCollections.observableArrayList(utilisateurs);
            tableau1.setItems(obs);
            col_nom1.setCellValueFactory(new  PropertyValueFactory<>("nomu"));
            col_mail1.setCellValueFactory(new PropertyValueFactory<>("emailu"));
            System.out.println(utilisateurs);
        } catch (SQLException ex) {
            Logger.getLogger(BloquerUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void Bloquer(ActionEvent event) {
        try {
            try {
                try {
                    Utilisateur a =new Utilisateur();
                    a=tableau.getSelectionModel().getSelectedItem();
                    AdminService as=new AdminService();
                    as.BloquerCompteUser(a.getIdu());
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.setTitle("information Dialog");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Compte bloqué");
                    alert1.show();
                } catch (SQLException ex) {
                    Logger.getLogger(BloquerUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
                }
                AdminService as=new AdminService();
                
                List<Utilisateur> utilisateurs=as.getALLUtilisateursNonbloque();
                ObservableList obs;
                obs = FXCollections.observableArrayList(utilisateurs);
                tableau.setItems(obs);
                col_nom.setCellValueFactory(new  PropertyValueFactory<>("nomu"));
                col_mail.setCellValueFactory(new PropertyValueFactory<>("emailu"));
                System.out.println(utilisateurs);
            } catch (SQLException ex) {
                Logger.getLogger(BloquerUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
            }
            AdminService as=new AdminService();
            List<Utilisateur> utilisateurs=as.getALLUtilisateursbloque();
            ObservableList obs;
            obs = FXCollections.observableArrayList(utilisateurs);
            tableau1.setItems(obs);
            col_nom1.setCellValueFactory(new  PropertyValueFactory<>("nomu"));
            col_mail1.setCellValueFactory(new PropertyValueFactory<>("emailu"));
            System.out.println(utilisateurs);
        } catch (SQLException ex) {
            Logger.getLogger(BloquerUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Debloquer(ActionEvent event) {
        try {
            try {
                try {
                    Utilisateur a =new Utilisateur();
                    a=tableau1.getSelectionModel().getSelectedItem();
                    AdminService as=new AdminService();
                    as.DebloquerCompteUser(a.getIdu());
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.setTitle("information Dialog");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Compte debloqué");
                    alert1.show();
                } catch (SQLException ex) {
                    Logger.getLogger(BloquerUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
                }
                AdminService as=new AdminService();
                
                List<Utilisateur> utilisateurs=as.getALLUtilisateursNonbloque();
                ObservableList obs;
                obs = FXCollections.observableArrayList(utilisateurs);
                tableau.setItems(obs);
                col_nom.setCellValueFactory(new  PropertyValueFactory<>("nomu"));
                col_mail.setCellValueFactory(new PropertyValueFactory<>("emailu"));
                System.out.println(utilisateurs);
            } catch (SQLException ex) {
                Logger.getLogger(BloquerUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
            }
            AdminService as=new AdminService();
            List<Utilisateur> utilisateurs=as.getALLUtilisateursbloque();
            ObservableList obs;
            obs = FXCollections.observableArrayList(utilisateurs);
            tableau1.setItems(obs);
            col_nom1.setCellValueFactory(new  PropertyValueFactory<>("nomu"));
            col_mail1.setCellValueFactory(new PropertyValueFactory<>("emailu"));
            System.out.println(utilisateurs);
        } catch (SQLException ex) {
            Logger.getLogger(BloquerUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
