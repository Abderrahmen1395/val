/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entites.Agence;
import Entites.Vols;
import Services.AgenceServices;
import Services.VolService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RANI
 */
public class FXMLajouterrController implements Initializable {
    @FXML
    private TextField departvoltext;
    @FXML
    private TextField arrivevoltext;
    @FXML
    private TextField prixtext;
     @FXML
    private TextArea descriptiontext;
     
    @FXML
    private DatePicker pickerdepart;
    @FXML
    private DatePicker datepickerfin;
    
      
    
   
    @FXML
    private TextField places;
    @FXML
    private RadioButton ar;
    @FXML
    private RadioButton as;
    @FXML
    private AnchorPane datepickerdepart;
    @FXML
    private Button btn_aajoutVol;
    @FXML
    private Button btnRetour;
    @FXML
    private Button btnDeconnecter;
    @FXML
    private ToggleGroup type;
  
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    }    
    @FXML
    private void AjouterVoll(ActionEvent event)
    {   String rbb="";
        if(as.isSelected()){
            rbb = "Aller Simple";}
        else if(ar.isSelected()){
                        rbb = "Aller-Retour";}

        
        int year = pickerdepart.getValue().getYear()-1900;
        int month = pickerdepart.getValue().getMonthValue();
         int day = pickerdepart.getValue().getDayOfMonth();
            Date d=new Date(year, month, day) ;
            
 int year1 = datepickerfin.getValue().getYear()-1900;
        int month1 = datepickerfin.getValue().getMonthValue();
         int day1 = datepickerfin.getValue().getDayOfMonth();
            Date d1=new Date(year1, month1, day1) ;
            
    VolService volservice=new VolService();
        
         if (!departvoltext.getText().equalsIgnoreCase("") && !arrivevoltext.getText().equalsIgnoreCase("") && !descriptiontext.getText().equalsIgnoreCase("") &&  !prixtext.getText().equalsIgnoreCase("") 
          &&  d1.compareTo(d) >0   ){
                    // &&d.compareTo(LocalDate)>=0 
        
            try {
                   Agence ab=new Agence();
                    AgenceServices aa= new AgenceServices();
                    try {
                        ab=aa.AgenceConnecte();
                    } catch (SQLException ex) {
                        Logger.getLogger(AjouterUneActiviteFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                Vols v;

             v = new Vols( d , d1,departvoltext.getText(),arrivevoltext.getText(),Float.parseFloat(prixtext.getText()),descriptiontext.getText(),rbb,Integer.parseInt(places.getText()),ab.getId());
        
        String prix=prixtext.getText();
            volservice.ajouteVol(v);
            System.out.println("ajouté");
        } catch (SQLException ex) {
            System.out.println(ex);        }
         }
      
         
         
         
         
         
         
       if(departvoltext.getText().equalsIgnoreCase("") ||arrivevoltext.getText().equalsIgnoreCase("")|| descriptiontext.getText().equalsIgnoreCase("") ||  prixtext.getText().equalsIgnoreCase("")  ) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Echec de l'ajout");
            alert.setHeaderText(null);
            alert.setContentText("fill all the fields");
            alert.show();
        }
          if (d1.compareTo(d) < 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Echec de l'ajout");
                alert.setHeaderText(null);
                alert.setContentText("Attention ! Date invalide !");
                alert.showAndWait();
            }
    }
    @FXML
    private void Retour(ActionEvent event)
    {
        try {
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("choixmenueFXML.fxml"));
            Parent root=loader.load();
            
            Stage stage= new Stage();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    @FXML
    private void Deconnecter(ActionEvent event)
    {
        try {
            ((Node)event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader=new FXMLLoader(getClass().getResource("SigninFXML.fxml"));
            Parent root=loader.load();
            
            Stage stage= new Stage();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    
}
