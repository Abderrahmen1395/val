/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entites.Agence;
import Entites.Hebergement;
import Services.AgenceServices;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import Services.Upload;
import Services.serviceHebergement;
import java.sql.SQLException;

/**
 * FXML Controller class
 *
 * @author Y520-I7-1TR-4G
 */
public class AjouterHebergementFXMLController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private Color x2;
    @FXML
    private Color x3;
    @FXML
    private TextField nom_Hebergement;
    @FXML
    private TextField nombre_etoile;
    @FXML
    private TextField nombre_chambre;
    @FXML
    private TextField Adresse_Hebergement;
    @FXML
    private TextField prix_single;
    @FXML
    private TextField prix_double;
    
    @FXML
    private TextField taux_demi;
    @FXML
    private TextField taux_complet;
    @FXML
    private TextField tel;
    @FXML
    private TextField description;
    @FXML
    private Font x4;
    @FXML
    private Button browse;
    @FXML
    private ListView imageupload;
     File selectedfile;
    String path_img;
    Upload u = new Upload();
    @FXML
    private TextField nomAgence;
    @FXML
    private TextField type_Hebergement;
    @FXML
    private Button AjouterHebergement;

    
   
   
    @FXML
    private Button vider;
    private TextField idAgence;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         BooleanBinding booleanBinding = 
        ( nom_Hebergement.textProperty().isEqualTo("")).or(
        nombre_etoile.textProperty().isEqualTo("")).or(
        nombre_chambre.textProperty().isEqualTo("")).or(
        Adresse_Hebergement.textProperty().isEqualTo("")).or(
        prix_single.textProperty().isEqualTo("")).or(
        prix_double.textProperty().isEqualTo("")).or(
       
        taux_demi.textProperty().isEqualTo("")).or(
        taux_complet.textProperty().isEqualTo("")).or(
        tel.textProperty().isEqualTo("")).or(
        description.textProperty().isEqualTo("")).or(
        nomAgence.textProperty().isEqualTo("")).or(
        type_Hebergement.textProperty().isEqualTo(""));
        
        
    AjouterHebergement.disableProperty().bind(booleanBinding);
        
        
        
        browse.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
         FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("image","*.jpg", "*.png")
        );
        selectedfile = fc.showOpenDialog(null);
        if (selectedfile != null) {
            System.out.println("aaaaaaaaaa");
            Upload u= new Upload();
             try {
                 u.upload(selectedfile);
             } catch (IOException ex) {
                 Logger.getLogger(AjouterHebergementFXMLController.class.getName()).log(Level.SEVERE, null, ex);
             }
             imageupload.getItems().add(selectedfile.getName());

            path_img = selectedfile.getAbsolutePath();
            System.out.println("sssssssssssssssss");
        } else {
            System.out.println("FICHIER erroné");
        }
    

            }
                
            });
  
        AjouterHebergement.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                   Agence ab=new Agence();
                    AgenceServices aa= new AgenceServices();
                    try {
                        ab=aa.AgenceConnecte();
                    } catch (SQLException ex) {
                        Logger.getLogger(AjouterUneActiviteFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }
               
                 Hebergement h = new Hebergement(ab.getId(),nomAgence.getText(),type_Hebergement.getText(),nom_Hebergement.getText(),Integer.parseInt(nombre_etoile.getText()), Adresse_Hebergement.getText(),Integer.parseInt(nombre_chambre.getText()), Integer.parseInt(prix_single.getText()),Integer.parseInt(prix_double.getText()),Integer.parseInt(taux_demi.getText()),Integer.parseInt(taux_complet.getText()),Integer.parseInt(tel.getText()),description.getText());
     h.setImage(selectedfile.getName());
     if (Integer.parseInt(prix_single.getText())<=0 || Integer.parseInt(prix_double.getText())<=0  || Integer.parseInt(taux_demi.getText()) <=0 || Integer.parseInt(taux_complet.getText())<0 ) {
         Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Le prix doit etre positive");
            alert.show();
     }
    else if (Integer.toString(Integer.parseInt(tel.getText())).length() != 8) {
          Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vérifiez votre numéro de téléphone");
            alert.show();
     }    
           
     else{ serviceHebergement sv = new serviceHebergement();
             sv.ajouterHebergement(h);
            Alert alert0 = new Alert(Alert.AlertType.INFORMATION);
            alert0.setTitle("information Dialog");
            alert0.setHeaderText(null);
            alert0.setContentText("ajout avec succes ");
            alert0.show();
            
            }}
        });    
     

  /* prec.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("./GererHebergementFXML.fxml"));
                       Parent root;
                       try {
                            root=loader.load();
                            prec.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(AjouterHebergementFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                        }
    

 }
    });*/
    
     vider.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                type_Hebergement.clear();
                nom_Hebergement.clear();
                nombre_etoile.clear();
                nombre_chambre.clear();
                Adresse_Hebergement.clear();
                prix_single.clear();
                prix_double.clear();
                taux_demi.clear();
                taux_complet.clear();
                tel.clear();
                description.clear();
                imageupload.getItems().clear();
                idAgence.clear();
            }
            });
    // TODO
     
}
}
    

