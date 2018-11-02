/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entites.Vols;
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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.converter.LocalDateStringConverter;

/**
 * FXML Controller class
 *
 * @author RANI
 */
public class UpdateVolController implements Initializable {

      @FXML
    private TextField ville_arr;
        @FXML
    private TextField ville_dep; 
        @FXML
    private TextArea desc;
        @FXML
    private TextField prix;
        @FXML
    private DatePicker dt1;
                @FXML
    private DatePicker dt2;
    private ComboBox<String> comboUpdate;
    
           List Typee = new ArrayList();
    @FXML
    private TextField dispo;
    @FXML
    private RadioButton ar;
    @FXML
    private RadioButton as;
        
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        
    }    
           
            
    public void setVol(Vols a){
    ab=a;
    
      this.ville_arr.setText(ab.getVille_arrive());
      this.ville_dep.setText(ab.getVille_depart());
      this.prix.setText(ab.getPrix()+"");
      this.desc.setText(ab.getDescription());
    //  this.comboUpdate.getSelectedItem.toString(ab.getType_vol());
    this.dispo.setText(Integer.toString(ab.getPlacedisp()));

       
      
      
       

      
   
}
        public static Vols ab;
        
        
            @FXML
    private void con(ActionEvent event) throws IOException, SQLException {
                VolService sa=new VolService();
        String rbb="";
        if(as.isSelected()){
            rbb = "Aller Simple";}
        else if(ar.isSelected()){
                        rbb = "Aller-Retour";}
                Vols a=new Vols();
    a.setVille_arrive(ville_arr.getText());
    a.setVille_depart(ville_dep.getText());
     float prixxx=  Float. parseFloat(prix.getText());
    a.setPrix(prixxx);
    a.setDescription(desc.getText());
    
    a.setType_vol(rbb);
    int disp=Integer.parseInt(dispo.getText());
    a.setPlacedisp(disp);

    
         
            sa.modifierVol(a, ab.getId_vol());
            ((Node)event.getSource()).getScene().getWindow().hide();

      
    }

    
}
