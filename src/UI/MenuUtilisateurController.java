/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Services.UtilisateurServices;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Y520-I7-1TR-4G
 */
public class MenuUtilisateurController implements Initializable {

    @FXML
    private AnchorPane changeAnchor;
    AnchorPane mettreAJourAnchor;
    @FXML
    private Pane pane;
    @FXML
    private Label titreMenu;
    @FXML
    private VBox Menuutilisateur;
    @FXML
    private VBox Menureservation;
    @FXML
    private VBox gererresrutil;
    @FXML
    private VBox Menureclamation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Menuutilisateur.setVisible(true);
        Menureservation.setVisible(false);
        gererresrutil.setVisible(false);
        Menureclamation.setVisible(false);
        
        
                titreMenu.setText("Espace voyageur");

    }    
  public void setNode(Node node)
    {
        
        
        changeAnchor.getChildren().clear();
        AnchorPane.setTopAnchor(node, 0.0);
        AnchorPane.setRightAnchor(node, 0.0);
        AnchorPane.setLeftAnchor(node, 0.0);
        AnchorPane.setBottomAnchor(node, 0.0);
        changeAnchor.getChildren().add((Node) node);
        
        FadeTransition fT = new FadeTransition(Duration.millis(1500));
        fT.setNode(node);
        fT.setFromValue(0.1);
        fT.setToValue(1);
        fT.setCycleCount(1);
        fT.setAutoReverse(false);
        fT.play();
    }

    @FXML
    private void deconnecter(ActionEvent event) {
       try {
            UtilisateurServices us=new UtilisateurServices();
            try {
                us.MettreAZero();
            } catch (SQLException ex) {
                Logger.getLogger(MenuUtilisateurController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("SignIn.fxml"));
            Parent root=loader.load();
            
            Stage stage= new Stage();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void reservation(ActionEvent event) {
        Menuutilisateur.setVisible(false);
        Menureservation.setVisible(true);
        gererresrutil.setVisible(false);
        Menureclamation.setVisible(false);
        
        
                titreMenu.setText("Réservation");

    }

    @FXML
    private void profilutil(ActionEvent event) {
         Menuutilisateur.setVisible(false);
        Menureservation.setVisible(false);
        gererresrutil.setVisible(true);
        Menureclamation.setVisible(false);
        
        
                titreMenu.setText("Mon profil");
    }

    @FXML
    private void reclamationutil(ActionEvent event) {
         Menuutilisateur.setVisible(false);
        Menureservation.setVisible(false);
        gererresrutil.setVisible(false);
        Menureclamation.setVisible(true);
        
        
                titreMenu.setText("Mon profil");
    }

    @FXML
    private void gererreservationutil(ActionEvent event) {
    }

    @FXML
    private void heberegementutil(ActionEvent event) throws IOException {
        mettreAJourAnchor = FXMLLoader.load(getClass().getResource("Reservationhebergement.fxml"));
        titreMenu.setText("Réserver un hébergement");
        setNode(mettreAJourAnchor);
    }

    @FXML
    private void volutil(ActionEvent event) throws IOException {
           mettreAJourAnchor = FXMLLoader.load(getClass().getResource("affichzgeRechercheFXML.fxml"));
        titreMenu.setText("Réserver un vol");
        setNode(mettreAJourAnchor);
    }

    @FXML
    private void transportutil(ActionEvent event) {
    }

    @FXML
    private void activiteutil(ActionEvent event) throws IOException {
           mettreAJourAnchor = FXMLLoader.load(getClass().getResource("ReservationActivite.fxml"));
        titreMenu.setText("Réserver une activité");
        setNode(mettreAJourAnchor);

        
    }

    @FXML
    private void retourmenureserv(ActionEvent event) {
          Menuutilisateur.setVisible(true);
        Menureservation.setVisible(false);
        gererresrutil.setVisible(false);
        Menureclamation.setVisible(false);
    }

    @FXML
    private void restaurantutil(ActionEvent event) {
    }

    @FXML
    private void voyageorgutil(ActionEvent event) throws IOException {
           mettreAJourAnchor = FXMLLoader.load(getClass().getResource("Reservation.fxml"));
        titreMenu.setText("Réserver un voyage organisé");
        setNode(mettreAJourAnchor);
    }

    @FXML
    private void modifcompteutil(ActionEvent event) throws IOException {
           mettreAJourAnchor = FXMLLoader.load(getClass().getResource("ModifierCompteUtilisateur.fxml"));
        titreMenu.setText("Modifier votre profil");
        setNode(mettreAJourAnchor);
    }

    @FXML
    private void desactiverutil(ActionEvent event) {
    }

    @FXML
    private void retourmenuprofil(ActionEvent event) {
          Menuutilisateur.setVisible(true);
        Menureservation.setVisible(false);
        gererresrutil.setVisible(false);
        Menureclamation.setVisible(false);
    }

    @FXML
    private void envoyerreclamation(ActionEvent event) {
    }

    @FXML
    private void Consulterreclamation(ActionEvent event) {
    }

    @FXML
    private void retourmenureclam(ActionEvent event) {
          Menuutilisateur.setVisible(true);
        Menureservation.setVisible(false);
        gererresrutil.setVisible(false);
        Menureclamation.setVisible(false);
    }
    
}
