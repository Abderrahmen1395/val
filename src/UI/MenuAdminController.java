/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.io.IOException;
import java.net.URL;
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
public class MenuAdminController implements Initializable {

    @FXML
    private Pane pane;
    @FXML
    private Label titreMenu;
    @FXML
    private VBox Menuadmin;
    @FXML
    private AnchorPane changeAnchor;
        AnchorPane mettreAJourAnchor;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         

        
                titreMenu.setText("Espace administrateur"); 
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
    private void verifagence(ActionEvent event)  throws IOException {
        mettreAJourAnchor = FXMLLoader.load(getClass().getResource("AfficherAgenceNonVerifie.fxml"));
        titreMenu.setText("Vérifier agence");
        setNode(mettreAJourAnchor);
    }

    @FXML
    private void bloqueragence(ActionEvent event) throws IOException {
        mettreAJourAnchor = FXMLLoader.load(getClass().getResource("BloquerUneAgence.fxml"));
        titreMenu.setText("Bloquer une agence");
        setNode(mettreAJourAnchor);
    }

    @FXML
    private void bloquerutilisateur(ActionEvent event)throws IOException {
        mettreAJourAnchor = FXMLLoader.load(getClass().getResource("BloquerUtilisateur.fxml"));
        titreMenu.setText("Bloquer un utilisateur");
        setNode(mettreAJourAnchor);
    }

    @FXML
    private void deconnecteradmin(ActionEvent event) throws IOException {
         ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("SignIn.fxml"));
            Parent root=loader.load();
            
            Stage stage= new Stage();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
       
    
    }
    
}
