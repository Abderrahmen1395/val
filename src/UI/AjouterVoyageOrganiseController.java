
package UI;

import Entites.Agence;
import Entites.VoyageOrganise;
import Services.AgenceServices;
import Services.ServiceVoyageOrganise;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

public class AjouterVoyageOrganiseController implements Initializable {

    @FXML
    private Button btn_ajout;

    @FXML
    private Spinner<Integer> tf_prixvoyage;
    @FXML
    private DatePicker tf_datedepart;
    @FXML
    private DatePicker tf_dateretour;
    @FXML
    private TextField tf_origine;
    @FXML
    private TextField tf_paysdestination;
    @FXML
    private TextField tf_villedestination;
    @FXML
    private Spinner<Integer> tf_nbplaces;
    @FXML
    private TextField tf_hotel;
    private Spinner<Integer> tf_idagence;
    @FXML
    private TextField tf_nomagence;
    private Button prec;
    @FXML
    private Button vide;
    private TextField test;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        SpinnerValueFactory<Integer> gradesvaluefactory1=new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999, 0);
        SpinnerValueFactory<Integer> gradesvaluefactory2=new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 9999, 0);
        
        this.tf_prixvoyage.setValueFactory(gradesvaluefactory1);
        this.tf_nbplaces.setValueFactory(gradesvaluefactory2);
        
        tf_prixvoyage.setEditable(true);
        tf_nbplaces.setEditable(true);
        
        //champ vide
        BooleanBinding booleanBinding = 
      (
        tf_nomagence.textProperty().isEqualTo("")).or(
        tf_hotel.textProperty().isEqualTo("")).or(
        tf_villedestination.textProperty().isEqualTo("")).or(
        tf_paysdestination.textProperty().isEqualTo("")).or(
        tf_origine.textProperty().isEqualTo(""));

    btn_ajout.disableProperty().bind(booleanBinding);
        
        
        
        
        
        
        
        
        
        
        
        
        
        btn_ajout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                
                //Covertir les dates  
                
                Date DDS=convertToDateViaSqlDate(tf_datedepart.getValue());
                Date DRS=convertToDateViaSqlDate(tf_dateretour.getValue());
                java.sql.Date today = new java.sql.Date(Calendar.getInstance().getTime().getTime());   
                
                
                
                //ajouter les annonces de voyages
                           Agence ab=new Agence();
                    AgenceServices aa= new AgenceServices();
                    try {
                        ab=aa.AgenceConnecte();
                    } catch (SQLException ex) {
                        Logger.getLogger(AjouterUneActiviteFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    VoyageOrganise v =new VoyageOrganise(tf_prixvoyage.getValue(),DDS,DRS,tf_origine.getText(),tf_paysdestination.getText(),tf_villedestination.getText(),tf_nbplaces.getValue(),tf_hotel.getText(),ab.getId(),tf_nomagence.getText());
                    
                    ServiceVoyageOrganise sv=new ServiceVoyageOrganise();
                    if (DDS.after(DRS)||!DDS.after(today)||!DRS.after(today)||DDS==null||DRS==null)
                {Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("erreur dans la date");
            alert.show();
            
            
                
                  
        } else {
            sv.ajouterVoyageOrganise(v);
            Alert alert0 = new Alert(Alert.AlertType.INFORMATION);
            alert0.setTitle("information Dialog");
            alert0.setHeaderText(null);
            alert0.setContentText("ajout avec succes ");
            alert0.show();
            
           
        }};
                   
                    
                    
            
        });
    }

    //Vider les champs
    ;
    @FXML
    private void handle(ActionEvent event) {
    tf_prixvoyage.setValueFactory(null);
    tf_origine.clear();
    tf_datedepart.setValue(null);
    tf_dateretour.setValue(null);
    tf_paysdestination.clear();
    tf_villedestination.clear();
    tf_nbplaces.setValueFactory(null);
    tf_hotel.clear();
    tf_idagence.setValueFactory(null);
    tf_nomagence.clear();
    
    }
    public Date convertToDateViaSqlDate(LocalDate dateToConvert) {
    return java.sql.Date.valueOf(dateToConvert);
}
}
