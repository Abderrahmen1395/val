/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entites.Hebergement;
import java.io.IOException;
import java.net.URL;
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
import Services.serviceHebergement;

/**
 * FXML Controller class
 *
 * @author Y520-I7-1TR-4G
 */
public class ListeHebergementController implements Initializable {
 public static Hebergement he;
    @FXML
    private TableView<Hebergement> tableHebergement;
   
    @FXML
    private TableColumn<Hebergement, String> type_Hebergement;
    @FXML
    private TableColumn<Hebergement, String> nom_Hebergement;
    @FXML
    private TableColumn<Hebergement, Integer> nombre_etoile;
    @FXML
    private TableColumn<Hebergement, String> Adresse_Hebergement;
    @FXML
    private TableColumn<Hebergement, Integer> nombre_chambre;
    @FXML
    private TableColumn<Hebergement, Integer> prix_single;
    @FXML
    private TableColumn<Hebergement, Integer> prix_double;
    @FXML
  
    private TableColumn<Hebergement, Integer> taux_demi;
    @FXML
    private TableColumn<Hebergement, Integer> taux_complet;
    @FXML
    private TableColumn<Hebergement, Integer> tel;
    @FXML
    private TableColumn<Hebergement, String> description;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private TableColumn<Hebergement, ImageView> image;
    @FXML
    private TableColumn<Hebergement, String> nomAgence;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       rafrechir();
        
         supprimer.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if (tableHebergement.getSelectionModel().getSelectedItem() != null) {
            try {
                int id = tableHebergement.getSelectionModel().getSelectedItem().getIdHebergement();
                serviceHebergement s = new serviceHebergement();
                s.supprimerHebergement(id);
            } catch (SQLException ex) {
                Logger.getLogger(ListeHebergementController.class.getName()).log(Level.SEVERE, null, ex);
            }
            rafrechir();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez selectionner un Hebergement");
            alert.show();
        }
            }
         });
      
         modifier.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
         if (tableHebergement.getSelectionModel().getSelectedItem() != null) {

            
               try {
          Hebergement a = tableHebergement.getSelectionModel().getSelectedItem();
        he = a;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("./ModifierHebergementFXML.fxml"));
        Parent root = loader.load();
        ModifierHebergementFXMLController hc = loader.getController();
        hc.setHebergement(a);
        
        Stage stage= new Stage();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
        rafrechir();
        } catch (IOException ex) {
            Logger.getLogger(ListeHebergementController.class.getName()).log(Level.SEVERE, null, ex);
        }
                   } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez selectionner un hebergement");
            alert.show();
        }
    }
            
         });
        // TODO
    }    

     public void rafrechir()
    {
        serviceHebergement service = new serviceHebergement();
        /* add column to the tableview and set its items */
        ObservableList<Hebergement> listeHebergements = FXCollections.observableArrayList((Hebergement.generateImageViews(service.afficherHebergement())));
        tableHebergement.setItems(listeHebergements);
        
       
        image.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Hebergement, ImageView>, ObservableValue<ImageView>>() {
            @Override
            public ObservableValue<ImageView> call(TableColumn.CellDataFeatures<Hebergement, ImageView> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getImgview());
            }
        });
        
         nomAgence.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Hebergement, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Hebergement, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getNomAgence());
            }
        });
        type_Hebergement.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Hebergement, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Hebergement, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getType_Hebergement());
            }
        });
         TableColumn albumArt = new TableColumn("Album Art");
        albumArt.setCellValueFactory(new PropertyValueFactory("album"));
        albumArt.setPrefWidth(200);
        nom_Hebergement.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Hebergement, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Hebergement, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getNom_Hebergement());
            }
        });
        nombre_etoile.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Hebergement, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Hebergement, Integer> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getNombre_etoile());
            }
        });
        Adresse_Hebergement.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Hebergement, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Hebergement, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getAdresse_Hebergement());
            }
        });
        nombre_chambre.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Hebergement, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Hebergement, Integer> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getNombre_chambre());
            }
        });
        prix_single.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Hebergement, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Hebergement, Integer> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getPrix_single());
            }
        });
        prix_double.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Hebergement, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Hebergement, Integer> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getPrix_double());
            }
        });
        
        taux_demi.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Hebergement, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Hebergement, Integer> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getTaux_demi());
            }
        });
        taux_complet.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Hebergement, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Hebergement, Integer> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getTaux_complet());
            }
        });
        tel.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Hebergement, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Hebergement, Integer> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getTel());
            }
        });
        description.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Hebergement, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Hebergement, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getDescription());
            }
        });
}
    }