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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.sql.*;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author RANI
 */
public class AfficherVolsFXMLController implements Initializable {

    @FXML
    private TableColumn<Vols, Date> columnDebutvol;
    @FXML
    private TableColumn<Vols, Date> columnFinVol;
    @FXML
    private TableColumn<Vols, String> columnVilleDepart;
    @FXML
    private TableColumn<Vols, String> columnVilleArrive;
    @FXML
    private TableColumn<Vols, Float> columnPrix;
    @FXML
    private TableColumn<Vols, String> columnDescription;
        @FXML
    private TableColumn<Vols, String> columTypeVol;
    @FXML
    private Button btn_supprimerVol;
    @FXML
    private Button btn_modifierVol;
    @FXML
    private TableView<Vols> tableVolss;
    
        public static Vols ab;
    @FXML
    private TableColumn<Vols, Integer> placedisp;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Afficher();
            /*  columnDebutvol.setCellValueFactory(new PropertyValueFactory<Vols, Date>("date_depart"));
             columnFinVol.setCellValueFactory(new PropertyValueFactory<Vols, Date>("date_arrive"));
             columnVilleDepart.setCellValueFactory(new PropertyValueFactory<Vols, String>("ville_depart"));
             columnVilleArrive.setCellValueFactory(new PropertyValueFactory<Vols, String>("ville_arrive"));
             columnPrix.setCellValueFactory(new PropertyValueFactory<Vols, Float>("prix"));
             columnDescription.setCellValueFactory(new PropertyValueFactory<Vols, String>("description"));
             raffrechir();*/
        } catch (SQLException ex) {
            Logger.getLogger(AfficherVolsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void raffrechir() {
    
    }

    @FXML
    private void Supprimer_vols(ActionEvent event) throws SQLException {

         
            
            
                 if (tableVolss.getSelectionModel().getSelectedItem() != null) {
            try {
                int id = tableVolss.getSelectionModel().getSelectedItem().getId_vol();
                System.out.println(id);
               VolService service = new VolService();
                service.deleteVol(id);
                 Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("supression avec succes");
            alert.show();
            } catch (SQLException ex) {
            Logger.getLogger(AfficherVolsFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Afficher();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez selectionner une Vol");
            alert.show();
        }
    }

    /* private void ModifierVols(ActionEvent event) 
     {
     if(tableVolss.getSelectionModel().getSelectedItem()!=null)
     {
     FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierVol.fxml"));
     Parent root = loader.load();
     ModifierExerciceController ac = loader.getController();
     ac.setText(tableExercice.getSelectionModel().getSelectedItem().getNom(),
     tableExercice.getSelectionModel().getSelectedItem().getType(),
     tableExercice.getSelectionModel().getSelectedItem().getDureeExercice(),
     tableExercice.getSelectionModel().getSelectedItem().getDescription(),
     tableExercice.getSelectionModel().getSelectedItem().getId(),
     tableExercice.getSelectionModel().getSelectedItem().getDate(),
     tableExercice.getSelectionModel().getSelectedItem().getPlaceDispo());
     Stage stage= new Stage();
     Scene scene=new Scene(root);
     stage.setScene(scene);
     stage.showAndWait();
     raffrechir();
     }
     }*/
   
    @FXML
    private void ModifierVols(ActionEvent event) throws IOException, SQLException {
        
                 
        if (tableVolss.getSelectionModel().getSelectedItem() != null) {
Vols a = tableVolss.getSelectionModel().getSelectedItem();
        ab = a;
               FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateVol.fxml"));
        Parent root = loader.load();
        UpdateVolController ac = loader.getController();
        ac.setVol(a);
        
        Stage stage= new Stage();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
        Afficher();
           
                   } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez selectionner un Vols");
            alert.show();
        }
    }

    public void Afficher() throws SQLException {
        VolService service = new VolService();


        /* add column to the tableview and set its items */
        ObservableList<Vols> listeVols = FXCollections.observableArrayList(service.getALLVols());
        tableVolss.setItems(listeVols);

        columnVilleArrive.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Vols, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getVille_arrive());
            }
        });
      
        columnDebutvol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, Date>, ObservableValue<Date>>() {
            @Override
            public ObservableValue<Date> call(TableColumn.CellDataFeatures<Vols, Date> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getDate_depart());
            }
        });
        columnFinVol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, Date>, ObservableValue<Date>>() {
            @Override
            public ObservableValue<Date> call(TableColumn.CellDataFeatures<Vols, Date> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getDate_arrive());
            }
        });
        columnVilleDepart.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Vols, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getVille_depart());
            }
        });
        columnDescription.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Vols, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getDescription());
            }
        });

        /*    columnPrix .setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, float>, ObservableValue<float>>() {
         @Override
         public ObservableValue<String> call(TableColumn.CellDataFeatures<Vols, float> param) {
         return new ReadOnlyObjectWrapper(param.getValue().getPrix());
         }
         });    */
           columnPrix .setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, Float>, ObservableValue<Float>>() {
         @Override
         public ObservableValue<Float> call(TableColumn.CellDataFeatures<Vols, Float> param) {
         return new ReadOnlyObjectWrapper(param.getValue().getPrix());
         }
         });
           columTypeVol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Vols, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getType_vol());
            }
        });
           placedisp.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Vols, Integer> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getPlacedisp());
            }
        });
    }

}
