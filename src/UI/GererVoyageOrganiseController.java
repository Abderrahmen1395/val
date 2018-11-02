/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entites.VoyageOrganise;
import Services.ServiceVoyageOrganise;
import java.io.IOException;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class GererVoyageOrganiseController implements Initializable {
 public static VoyageOrganise he;
    @FXML
    private TableView<VoyageOrganise> voyageorganise;
    @FXML
    private TableColumn<VoyageOrganise, Integer> id;
    @FXML
    private TableColumn<VoyageOrganise, Integer> prixvoyage;
    @FXML
    private TableColumn<VoyageOrganise, Date> datedepart;
    @FXML
    private TableColumn<VoyageOrganise, Date> dateretour;
    @FXML
    private TableColumn<VoyageOrganise, String> origine;
    @FXML
    private TableColumn<VoyageOrganise, String> paysdestination;
    @FXML
    private TableColumn<VoyageOrganise, String> villedestination;
    @FXML
    private TableColumn<VoyageOrganise, Integer> nbplaces;
    @FXML
    private TableColumn<VoyageOrganise, String> hotel;
    @FXML
    private TableColumn<VoyageOrganise, Integer> idagence;
    @FXML
    private TableColumn<VoyageOrganise, String> nomagence;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    private Button retour;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rafrechir();
        
         supprimer.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if (voyageorganise.getSelectionModel().getSelectedItem() != null) {
            try {
                int id = voyageorganise.getSelectionModel().getSelectedItem().getId();
                ServiceVoyageOrganise s = new ServiceVoyageOrganise();
                s.supprimerVoyageOrganise(id);
            } catch (SQLException ex) {
                Logger.getLogger(GererVoyageOrganiseController.class.getName()).log(Level.SEVERE, null, ex);
            }
            rafrechir();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez selectionner un voyage organise");
            alert.show();
        }
            }
         });
      
         modifier.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
         if (voyageorganise.getSelectionModel().getSelectedItem() != null) {

            
               try {
          VoyageOrganise a = voyageorganise.getSelectionModel().getSelectedItem();
        he = a;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("./ModifierVoyageOrganise.fxml"));
        Parent root = loader.load();
        ModifierVoyageOrganiseController hc = loader.getController();
        hc.setVoyageOrganise(a);
        
        Stage stage= new Stage();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
        rafrechir();
        } catch (IOException ex) {
            Logger.getLogger(GererVoyageOrganiseController.class.getName()).log(Level.SEVERE, null, ex);
        }
                   } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez selectionner un voyage organise");
            alert.show();
        }
    }
            
         });
        // TODO
    }    

     public void rafrechir()
    {
        ServiceVoyageOrganise service = new ServiceVoyageOrganise();
        /* add column to the tableview and set its items */
        ObservableList<VoyageOrganise> listeHebergements = FXCollections.observableArrayList(service.afficherVoyageOrganise());
        voyageorganise.setItems(listeHebergements);
        
       
        
        id.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<VoyageOrganise, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<VoyageOrganise, Integer> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getId());
            }
        });
         id.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<VoyageOrganise, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<VoyageOrganise, Integer> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getId());
            }
        });
        prixvoyage.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<VoyageOrganise, Integer>, ObservableValue<Integer>>() {
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
        villedestination.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<VoyageOrganise, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<VoyageOrganise, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getVille_destination());
            }
        });
        nbplaces.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<VoyageOrganise, Integer>, ObservableValue<Integer>>() {
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
        idagence.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<VoyageOrganise, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<VoyageOrganise, Integer> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getId_agence());
            }
        });
        nomagence.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<VoyageOrganise, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<VoyageOrganise, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getNom_agence());
            }
        });
        
        
}
    }