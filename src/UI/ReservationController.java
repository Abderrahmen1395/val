/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entites.Agence;
import Entites.ReservationVoyageOrganise;
import Entites.Utilisateur;
import Entites.VoyageOrganise;
import Services.ServiceReservation;
import Services.ServiceVoyageOrganise;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import Services.UtilisateurServices;
import static UI.GererVoyageOrganiseController.he;
import Utiles.Singleton;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javafx.beans.binding.BooleanBinding;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class ReservationController implements Initializable {

    @FXML
    private TableView<VoyageOrganise> tablereservation;
    
    @FXML
    private TableColumn<VoyageOrganise, Integer> prix;
    @FXML
    private TableColumn<VoyageOrganise, Date> datedepart;
    @FXML
    private TableColumn<VoyageOrganise, Date> dateretour;
    @FXML
    private TableColumn<VoyageOrganise, String> origine;
    @FXML
    private TableColumn<VoyageOrganise, String> paysdestination;
    @FXML
    private TableColumn<VoyageOrganise, String> villeddestination;
    @FXML
    private TableColumn<VoyageOrganise, Integer> placesdisponibles;
    @FXML
    private TableColumn<VoyageOrganise, String> hotel;
    
    @FXML
    private TableColumn<VoyageOrganise, String> nomagence;
    @FXML
    private TextField nbrenfant;
    @FXML
    private TextField nbradulte;
    @FXML
    private TextField prixx;
    @FXML
    private Button reserver;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rafrechir();
        BooleanBinding booleanBinding = 
      (
        nbradulte.textProperty().isEqualTo("")).or(
        nbrenfant.textProperty().isEqualTo(""));

    reserver.disableProperty().bind(booleanBinding);
        
    }    
    public void rafrechir()
    {
        ServiceVoyageOrganise service = new ServiceVoyageOrganise();
        ObservableList<VoyageOrganise> listeHebergements = FXCollections.observableArrayList(service.afficherVoyageOrganise());
        tablereservation.setItems(listeHebergements);
        
       
        
        
        prix.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<VoyageOrganise, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<VoyageOrganise, Integer> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getPrix_voyage());
            }
        });
         TableColumn albumArt = new TableColumn("Album Art");
        albumArt.setCellValueFactory(new PropertyValueFactory("album"));
        albumArt.setPrefWidth(200);
        datedepart.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<VoyageOrganise, Date>, ObservableValue<Date>>() {
            @Override
            public ObservableValue<Date> call(TableColumn.CellDataFeatures<VoyageOrganise, Date> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getDate_depart());
            }
        });
        dateretour.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<VoyageOrganise, Date>, ObservableValue<Date>>() {
            @Override
            public ObservableValue<Date> call(TableColumn.CellDataFeatures<VoyageOrganise, Date> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getDate_retour());
            }
        });
        origine.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<VoyageOrganise, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<VoyageOrganise, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getOrigine());
            }
        });
        paysdestination.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<VoyageOrganise, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<VoyageOrganise, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getPays_destination());
            }
        });
        villeddestination.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<VoyageOrganise, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<VoyageOrganise, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getVille_destination());
            }
        });
        placesdisponibles.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<VoyageOrganise, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<VoyageOrganise, Integer> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getnb_places());
            }
        });
        hotel.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<VoyageOrganise, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<VoyageOrganise, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getHotel());
            }
        });
        
        nomagence.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<VoyageOrganise, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<VoyageOrganise, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getNom_agence());
            }
        });
        
        
}

    @FXML
    private void reserver(ActionEvent event) throws SQLException{
        
        
        
         if (tablereservation.getSelectionModel().getSelectedItem() != null) {

            
             int idv = tablereservation.getSelectionModel().getSelectedItem().getId();
             int ida = tablereservation.getSelectionModel().getSelectedItem().getId_agence();
             int nbra=Integer.parseInt(nbradulte.getText());
             int nbre=Integer.parseInt(nbrenfant.getText());
             int pr=tablereservation.getSelectionModel().getSelectedItem().getPrix_voyage();
             double p=pr*nbra+(pr*0.8*nbre);
             prixx.setText(Double.toString(p));
             int nbr=nbre+nbra;
             int pla=tablereservation.getSelectionModel().getSelectedItem().getnb_places();
             if(nbr>pla)
             {Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("information Dialog");
            alert2.setHeaderText(null);
            alert2.setContentText("Seulement "+pla+" places disponible!");
            alert2.show();}else{
             UtilisateurServices su = new UtilisateurServices();
             Utilisateur u = su.retournerUtilisateur();
             ReservationVoyageOrganise v=new ReservationVoyageOrganise(idv,u.getIdu(),ida);
             ServiceReservation sa=new ServiceReservation();
             sa.ajoutreservation(v);
             ServiceReservation ee=new ServiceReservation();
             ee.updateplaces(idv,pla,nbr);
        rafrechir();
             }} else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez selectionner un voyage organise");
            alert.show();
        }
    
            
        
      
            
             
        
       
            
            
            
           
            
        
    }
    
}

    

