/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Services.AgenceServices;
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
public class MenuPrincipalController implements Initializable {

    @FXML
    private Label titreMenu;
    @FXML
    private VBox Menu;
    @FXML
    private VBox Menuheber;
    @FXML
    private AnchorPane changeAnchor;
    AnchorPane mettreAJourAnchor;
    @FXML
    private Pane pane;
    @FXML
    private VBox Menuact;
    @FXML
    private VBox MenuV;
    @FXML
    private VBox Menuorganise;
    @FXML
    private VBox gereragence;
    @FXML
    private VBox Menurestau;

    /**
     * Initializes the controller class.
     */
            
   
    public void initialize(URL url, ResourceBundle rb) {
        Menu.setVisible(true);
        Menuheber.setVisible(false);
        Menuact.setVisible(false);
        MenuV.setVisible(false);
        Menuorganise.setVisible(false);
        gereragence.setVisible(false);
        Menurestau.setVisible(false);

        
                titreMenu.setText("Espace agence");

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
    private void Menuhebergement(ActionEvent event) {
         Menu.setVisible(false);
        Menuheber.setVisible(true);
        Menuact.setVisible(false);
        MenuV.setVisible(false);
        Menuorganise.setVisible(false);
         gereragence.setVisible(false);
    }

    @FXML
    private void Ajouterhebergement(ActionEvent event) throws IOException {
        mettreAJourAnchor = FXMLLoader.load(getClass().getResource("AjouterHebergementFXML.fxml"));
        titreMenu.setText("Ajouter un hébergement");
        setNode(mettreAJourAnchor);
        
    }

    @FXML
    private void Gererhebergement(ActionEvent event) throws IOException {
        mettreAJourAnchor = FXMLLoader.load(getClass().getResource("ListeHebergement.fxml"));
        titreMenu.setText("Gérer hébergement");
        setNode(mettreAJourAnchor);
    }

    @FXML
    private void Menuvol(ActionEvent event) {
         Menu.setVisible(false);
        Menuheber.setVisible(false);
        Menuact.setVisible(false);
        MenuV.setVisible(true);
        Menuorganise.setVisible(false);
         gereragence.setVisible(false);
    }


    @FXML
    private void Menuactivite(ActionEvent event) {
         Menu.setVisible(false);
        Menuheber.setVisible(false);
        Menuact.setVisible(true);
        MenuV.setVisible(false);
        Menuorganise.setVisible(false);
         gereragence.setVisible(false);
    }

    @FXML
    private void Menurestauration(ActionEvent event) {
         Menu.setVisible(false);
        Menuheber.setVisible(false);
        Menuact.setVisible(false);
        MenuV.setVisible(false);
        Menuorganise.setVisible(false);
         gereragence.setVisible(false);
         Menurestau.setVisible(true);
    }

    @FXML
    private void Menuvoyageorganise(ActionEvent event) {
         Menu.setVisible(false);
        Menuheber.setVisible(false);
        Menuact.setVisible(false);
        MenuV.setVisible(false);
        Menuorganise.setVisible(true);
         gereragence.setVisible(false);
    }

    @FXML
    private void Ajouteractivite(ActionEvent event) throws IOException {
        mettreAJourAnchor = FXMLLoader.load(getClass().getResource("AjouterUneActiviteFXML.fxml"));
        titreMenu.setText("Ajouter une activité");
        setNode(mettreAJourAnchor);
    }

    @FXML
    private void Gereractivite(ActionEvent event) throws IOException {
        mettreAJourAnchor = FXMLLoader.load(getClass().getResource("AfficheractiviteFXML.fxml"));
        titreMenu.setText("Gérer activité");
        setNode(mettreAJourAnchor);
    }
    

    @FXML
    private void Ajoutervol(ActionEvent event) throws IOException {
        mettreAJourAnchor = FXMLLoader.load(getClass().getResource("FXMLajouterr.fxml"));
        titreMenu.setText("Ajouter vol");
        setNode(mettreAJourAnchor);
    }

    @FXML
    private void Gerervol(ActionEvent event) throws IOException {
        mettreAJourAnchor = FXMLLoader.load(getClass().getResource("AfficherVolsFXML.fxml"));
        titreMenu.setText("Gérer vol");
        setNode(mettreAJourAnchor);
    }

    @FXML
    private void Ajoutervoyageorganise(ActionEvent event) throws IOException {
        mettreAJourAnchor = FXMLLoader.load(getClass().getResource("AjouterVoyageOrganise.fxml"));
        titreMenu.setText("Ajouter un voyage organisé");
        setNode(mettreAJourAnchor);
    }

    @FXML
    private void Gerervoyageorganise(ActionEvent event)throws IOException {
        mettreAJourAnchor = FXMLLoader.load(getClass().getResource("GererVoyageOrganise.fxml"));
        titreMenu.setText("Gérer voyage organisé");
        setNode(mettreAJourAnchor);
    }

    @FXML
    private void gerercompagence(ActionEvent event) {
         Menu.setVisible(false);
        Menuheber.setVisible(false);
        Menuact.setVisible(false);
        MenuV.setVisible(false);
        Menuorganise.setVisible(false);
         gereragence.setVisible(true);
    }

    @FXML
    private void retourmenuhebergement(ActionEvent event) {
        Menu.setVisible(true);
        Menuheber.setVisible(false);
        Menuact.setVisible(false);
        MenuV.setVisible(false);
        Menuorganise.setVisible(false);
         gereragence.setVisible(false);
    }

    @FXML
    private void retourmenuactivite(ActionEvent event) {
         Menu.setVisible(true);
        Menuheber.setVisible(false);
        Menuact.setVisible(false);
        MenuV.setVisible(false);
        Menuorganise.setVisible(false);
         gereragence.setVisible(false);
    }

    @FXML
    private void retourmenuvol(ActionEvent event) {
         Menu.setVisible(true);
        Menuheber.setVisible(false);
        Menuact.setVisible(false);
        MenuV.setVisible(false);
        Menuorganise.setVisible(false);
         gereragence.setVisible(false);
    }

    @FXML
    private void retourmenuvoyageorg(ActionEvent event) {
         Menu.setVisible(true);
        Menuheber.setVisible(false);
        Menuact.setVisible(false);
        MenuV.setVisible(false);
        Menuorganise.setVisible(false);
         gereragence.setVisible(false);
    }


    @FXML
    private void deconnecter(ActionEvent event) {
     try {
            AgenceServices us=new AgenceServices();
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
    private void retourgererag(ActionEvent event) {
        Menu.setVisible(true);
        Menuheber.setVisible(false);
        Menuact.setVisible(false);
        MenuV.setVisible(false);
        Menuorganise.setVisible(false);
         gereragence.setVisible(false);
    }

    @FXML
    private void ajoterrestau(ActionEvent event) throws IOException {
        mettreAJourAnchor = FXMLLoader.load(getClass().getResource("pathislam.fxml"));
        titreMenu.setText("Ajouter un restaurant");
        setNode(mettreAJourAnchor);
    }

    @FXML
    private void Gererrestau(ActionEvent event) throws IOException {
        mettreAJourAnchor = FXMLLoader.load(getClass().getResource("pathislam.fxml"));
        titreMenu.setText("Gérer restaurant");
        setNode(mettreAJourAnchor);
    }

    @FXML
    private void retourmenurest(ActionEvent event) {
         Menu.setVisible(true);
        Menuheber.setVisible(false);
        Menuact.setVisible(false);
        MenuV.setVisible(false);
        Menuorganise.setVisible(false);
         gereragence.setVisible(false);
         Menurestau.setVisible(false);
    }

    @FXML
    private void Menutransport(ActionEvent event) {
    }

    @FXML
    private void modifcompteag(ActionEvent event) throws IOException 
    {  mettreAJourAnchor = FXMLLoader.load(getClass().getResource("ModifierCompteAgence.fxml"));
        titreMenu.setText("Modifier votre profil");
        setNode(mettreAJourAnchor);
    }

    @FXML
    private void histreservationag(ActionEvent event) {
    }

    @FXML
    private void desactiveragence(ActionEvent event) {
    }

    
}
