/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entites.Hebergement;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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

/**
 * FXML Controller class
 *
 * @author Y520-I7-1TR-4G
 */
public class ModifierHebergementFXMLController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private Color x2;
    @FXML
    private Color x3;
    @FXML
    private TextField nom_Hebergementm;
    @FXML
    private TextField nombre_etoilem;
    @FXML
    private TextField nombre_chambrem;
    @FXML
    private TextField Adresse_Hebergementm;
    @FXML
    private TextField prix_singlem;
    @FXML
    private TextField prix_doublem;
    
    @FXML
    private TextField taux_demim;
    @FXML
    private TextField taux_completm;
    @FXML
    private TextField telm;
    @FXML
    private TextField descriptionm;
    @FXML
    private Font x4;
    @FXML
    private Button browsem;
    @FXML
    private ListView imageuploadm;
    File selectedfile;
    String path_img;
    Upload u = new Upload();
    @FXML
    private TextField type_Hebergementm;
    @FXML
    private Button modifierh;
    @FXML
    private Label nomAgence;
    @FXML
    private TextField nomAgencem;

    
   
public void setHebergement(Hebergement h){
    he=h;
    
      this.nom_Hebergementm.setText(he.getNom_Hebergement());
      this.nombre_etoilem.setText(String.valueOf(he.getNombre_etoile()));
      this.nombre_chambrem.setText(String.valueOf(he.getNombre_chambre()));
      this.Adresse_Hebergementm.setText(he.getAdresse_Hebergement());
      this.prix_singlem.setText(String.valueOf(he.getPrix_single()));
      this.prix_doublem.setText(String.valueOf(he.getPrix_double()));
            this.nomAgencem.setText(he.getNomAgence());

      this.taux_demim.setText(String.valueOf(he.getTaux_demi()));
      this.taux_completm.setText(String.valueOf(he.getTaux_complet()));
      this.telm.setText(String.valueOf(he.getTel()));
      this.descriptionm.setText(he.getDescription());
       this.type_Hebergementm.setText(he.getType_Hebergement());
       this.imageuploadm.setAccessibleText(he.getImage());
      /* this.imageuploadm.setAccessibleText(he.getImage());*/
}
    public static Hebergement he;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
         BooleanBinding booleanBinding = 
        ( nom_Hebergementm.textProperty().isEqualTo("")).or(
        nombre_etoilem.textProperty().isEqualTo("")).or(
        nombre_chambrem.textProperty().isEqualTo("")).or(
        Adresse_Hebergementm.textProperty().isEqualTo("")).or(
        prix_singlem.textProperty().isEqualTo("")).or(
        prix_doublem.textProperty().isEqualTo("")).or(
        taux_demim.textProperty().isEqualTo("")).or(
        taux_completm.textProperty().isEqualTo("")).or(
        telm.textProperty().isEqualTo("")).or(
        descriptionm.textProperty().isEqualTo("")).or(
        nomAgencem.textProperty().isEqualTo("")).or(
        type_Hebergementm.textProperty().isEqualTo(""));
        
        
    modifierh.disableProperty().bind(booleanBinding);
        
        
        
        modifierh.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
              serviceHebergement sh=new serviceHebergement();
        Hebergement h=new Hebergement();
        if (Integer.parseInt(prix_singlem.getText())<=0 || Integer.parseInt(prix_doublem.getText())<=0  || Integer.parseInt(taux_demim.getText()) <=0 || Integer.parseInt(taux_completm.getText())<=0 ) {
         Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Le prix doit etre positive");
            alert.show();
     }
    else if (Integer.toString(Integer.parseInt(telm.getText())).length() != 8) {
          Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vérifiez votre numéro de téléphone");
            alert.show();
     }   
    else {
        h.setNom_Hebergement(nom_Hebergementm.getText());
        h.setNombre_etoile(Integer.parseInt(nombre_etoilem.getText()));
        h.setType_Hebergement(type_Hebergementm.getText());
        h.setNombre_chambre(Integer.parseInt(nombre_chambrem.getText()));
        h.setAdresse_Hebergement(Adresse_Hebergementm.getText());
        h.setPrix_single(Integer.parseInt(prix_singlem.getText()));
        h.setPrix_double(Integer.parseInt(prix_doublem.getText()));
        h.setTaux_demi(Integer.parseInt(taux_demim.getText()));
        h.setTaux_complet(Integer.parseInt(taux_completm.getText()));
        h.setTel(Integer.parseInt(telm.getText())); 
        h.setDescription(descriptionm.getText());
        h.setNomAgence(nomAgencem.getText());
       
                    h.setImage(selectedfile.getName());
                    
                    
                  try {
                      /* h.setImage(selectedfile.getName());*/
                      
                      
                      sh.modifierHebergement(h, he.getIdHebergement());
                  } catch (SQLException ex) {
                      Logger.getLogger(ModifierHebergementFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                  }
                      Alert alert0 = new Alert(Alert.AlertType.INFORMATION);
            alert0.setTitle("information Dialog");
            alert0.setHeaderText(null);
            alert0.setContentText("Votre modification est enregistrée avec succes ");
            alert0.show();
            ((Node)event.getSource()).getScene().getWindow().hide();
                
    }}
            
        });
            
      
    
   browsem.setOnAction(new EventHandler<ActionEvent>(){
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
             imageuploadm.getItems().add(selectedfile.getName());

            path_img = selectedfile.getAbsolutePath();
            System.out.println("sssssssssssssssss");
        } else {
            System.out.println("FICHIER erroné");
        }
    

            }
                
            });
}
}