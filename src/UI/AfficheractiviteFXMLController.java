/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entites.Activite;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
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
import javafx.stage.Stage;
import javafx.util.Callback;
import Services.ActiviteService;

/**
 * FXML Controller class
 *
 * @author challakh
 */
public class AfficheractiviteFXMLController implements Initializable {
public static Activite ab;
    @FXML
    private TableView<Activite> tableannonce;
    @FXML
    private TableColumn<Activite, String> col_nom;
    @FXML
    private TableColumn<Activite, String> col_type;
    @FXML
    private TableColumn<Activite,String > col_adresse;
    @FXML
    private TableColumn<Activite,String > col_pays;
    @FXML
    private TableColumn<Activite, String> col_region;
    @FXML
    private TableColumn<Activite, String> col_description;
    @FXML
    private TableColumn<Activite, Float> col_prix;
    @FXML
    private TableColumn<Activite, Integer> dispo;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
         rafrechir();
        
         supprimer.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if (tableannonce.getSelectionModel().getSelectedItem() != null) {
            try {
                int id = tableannonce.getSelectionModel().getSelectedItem().getId();
                
                ActiviteService s = new ActiviteService();
                s.supprimerProduit(id);
            } catch (SQLException ex) {
                Logger.getLogger(AfficheractiviteFXMLController.class.getName()).log(Level.SEVERE, null, ex);
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
         if (tableannonce.getSelectionModel().getSelectedItem() != null) {

            
               try {
          Activite a = tableannonce.getSelectionModel().getSelectedItem();
        ab = a;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierActiviteFXML.fxml"));
        Parent root = loader.load();
        ModifierActiviteFXMLController hc = loader.getController();
        hc.setActivite(a);
        
        Stage stage= new Stage();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
        rafrechir();
        } catch (IOException ex) {
            Logger.getLogger(AfficheractiviteFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
                   } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez selectionner une activite");
            alert.show();
        }
    }
            
         });
        // TODO
        
    }    
public void rafrechir()
    {
        ActiviteService service = new ActiviteService();
        /* add column to the tableview and set its items */
        ObservableList<Activite> listeHebergements = FXCollections.observableArrayList(service.afficherActivite());
        tableannonce.setItems(listeHebergements);
        
       
        
        col_nom.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Activite, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Activite, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getNom());
            }
        });
         col_nom.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Activite, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Activite, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getNom());
            }
        });
        col_type.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Activite, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Activite, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getType());
            }
        });
         TableColumn albumArt = new TableColumn("Album Art");
        albumArt.setCellValueFactory(new PropertyValueFactory("album"));
        albumArt.setPrefWidth(200);
        col_adresse.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Activite, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Activite, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getAdresse());
            }
        });
        col_pays.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Activite, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Activite, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getPays());
            }
        });
        col_region.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Activite, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Activite, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getRegion());
            }
        });
        col_description.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Activite, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Activite, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getDescription());
            }
        });
        col_prix.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Activite, Float>, ObservableValue<Float>>() {
            @Override
            public ObservableValue<Float> call(TableColumn.CellDataFeatures<Activite, Float> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getPrix());
            }
        });
        dispo.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Activite, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Activite, Integer> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getPlacedisponible());
            }
        });
        
       
        
}

    
        
}
