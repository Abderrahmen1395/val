/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entites.Hebergement;
import Entites.ReservationHebergement;
import Entites.Utilisateur;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import Services.UtilisateurServices;
import Services.serviceHebergement;
import Services.serviceReservationHebergement;

/**
 * FXML Controller class
 *
 * @author Y520-I7-1TR-4G
 */
public class ReservationhebergementController implements Initializable {

    @FXML
    private TableView<Hebergement> tab;
    @FXML
    private TableColumn<Hebergement, ImageView> image;
    @FXML
    private TableColumn<Hebergement, String> nomAgence;
    @FXML
    private TableColumn<Hebergement, String> type_Hebergement;
    @FXML
    private TableColumn<Hebergement, String> nom_Hebergement;
    @FXML
    private TableColumn<Hebergement, Integer> nombre_etoile;
   
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
    private TextField rechercherdestination;
    @FXML
    private TableColumn<Hebergement, String> Adresse_Heb;
    @FXML
    private Button reserver;
    @FXML
    private TextField nbrs;
    @FXML
    private TextField nbrn;
    @FXML
    private TextField nbrd;
    
    @FXML
    private TextField prixx;
    @FXML
    private RadioButton demip;
    @FXML
    private RadioButton completep;

    /**
     * Initializes the controller class.
     *
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        rafrechir();
        
        BooleanBinding booleanBinding = 
      (
        nbrs.textProperty().isEqualTo("")).or(
        nbrd.textProperty().isEqualTo("")).or(
        nbrn.textProperty().isEqualTo(""));

    reserver.disableProperty().bind(booleanBinding);
    }    

    @FXML
    private void reserver(ActionEvent event) throws SQLException {
         if (tab.getSelectionModel().getSelectedItem() != null) {
              int penn=1;
             if(completep.isSelected())
                 penn=tab.getSelectionModel().getSelectedItem().getTaux_complet();
             else if (demip.isSelected())
                 penn=tab.getSelectionModel().getSelectedItem().getTaux_demi();
            
             int idv = tab.getSelectionModel().getSelectedItem().getIdHebergement();
             int ida = tab.getSelectionModel().getSelectedItem().getIdAgence();
             
             int nbrss=Integer.parseInt(nbrs.getText());
             int nbrdd=Integer.parseInt(nbrd.getText());
             int nbrnn=Integer.parseInt(nbrn.getText());
             
             int prs=tab.getSelectionModel().getSelectedItem().getPrix_single();
             int prd=tab.getSelectionModel().getSelectedItem().getPrix_double();
             double p=((((nbrss*prs)+(nbrdd*prd))*(penn/100))+((nbrss*prs)+(nbrdd*prd)))*nbrnn;
             prixx.setText(Double.toString(p));
             int nbr=nbrss+nbrdd;
             int pla=tab.getSelectionModel().getSelectedItem().getNombre_chambre();
             if(nbr>pla)
             {Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("information Dialog");
            alert2.setHeaderText(null);
            alert2.setContentText("Seulement "+pla+" chambres disponibles!");
            alert2.show();}else{
             UtilisateurServices su = new UtilisateurServices();
             Utilisateur u = su.retournerUtilisateur();
            /* int a=u.getIdu();
                 System.out.println(a);
                 System.out.println(ida);*/
             ReservationHebergement v=new ReservationHebergement(idv,u.getIdu(),ida);
             serviceReservationHebergement sa=new serviceReservationHebergement();
             sa.ajoutreservation(v);
             serviceReservationHebergement ee=new serviceReservationHebergement();
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

    @FXML
    private void rechercher(ActionEvent event) throws SQLException {
        
         
        String ad=rechercherdestination.getText();
       serviceReservationHebergement ser = new serviceReservationHebergement();
        
        /* add column to the tableview and set its items */
        ObservableList<Hebergement> listeHebergements = FXCollections.observableArrayList((Hebergement.generateImageViews(ser.retournerHebergementadres(ad))));
       tab.setItems(listeHebergements);
        
       
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
        Adresse_Heb.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Hebergement, String>, ObservableValue<String>>() {
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
        
    
    public void rafrechir()
    {
        serviceHebergement service = new serviceHebergement();
        /* add column to the tableview and set its items */
        ObservableList<Hebergement> listeHebergements = FXCollections.observableArrayList((Hebergement.generateImageViews(service.afficherHebergement())));
       tab.setItems(listeHebergements);
        
       
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
        Adresse_Heb.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Hebergement, String>, ObservableValue<String>>() {
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


