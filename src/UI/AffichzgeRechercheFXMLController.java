/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Entites.ReservationVols;
import Entites.Utilisateur;
import Entites.Vols;
import Services.ReservationVolService;
import Services.UtilisateurServices;
import Services.VolService;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;


/**
 * FXML Controller class
 *
 * @author RANI
 */
public class AffichzgeRechercheFXMLController implements Initializable {

     @FXML
    private TableColumn<Vols, Date> dv;
    @FXML
    private TableColumn<Vols, Date> fv;
    @FXML
    private TableColumn<Vols, String> de;
    @FXML
    private TableColumn<Vols, String> ar;
    @FXML
    private TableColumn<Vols, Float> p;
    @FXML
    private TableColumn<Vols, String> des;
        @FXML
    private TableColumn<Vols, String> type;
    private TableView<Vols> tableVolsss;
    @FXML
    private TableView<Vols> tabrecherche;
    @FXML
    private Button btn_find;
    @FXML
    private TextField txt_dd;
    @FXML
    private TextField txt_aa;
    @FXML
    private Button btn_sshow;
    @FXML
    private TableColumn<Vols, Integer> placedisponible;
    @FXML
    private Button reserver;
    @FXML
    private TextField prixx;
    @FXML
    private TextField nbradulte;
    @FXML
    private TextField nbrenfant;
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
         BooleanBinding booleanBinding = 
      (
        nbradulte.textProperty().isEqualTo("")).or(
        nbrenfant.textProperty().isEqualTo(""));

    reserver.disableProperty().bind(booleanBinding);
        
    }
     @FXML
        public void find() throws SQLException {
        VolService service = new VolService();
      String arrive = txt_aa.getText();
        String depart  = txt_dd.getText();
         

        /* add column to the tableview and set its items */
        ObservableList<Vols> listeVols = FXCollections.observableArrayList(service.findVolParIdaff(arrive,depart));
         System.out.println(listeVols);
        tabrecherche.setItems(listeVols);

        de.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Vols, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getVille_arrive());
            }
        });
      
        dv.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, Date>, ObservableValue<Date>>() {
            @Override
            public ObservableValue<Date> call(TableColumn.CellDataFeatures<Vols, Date> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getDate_depart());
            }
        });
        fv.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, Date>, ObservableValue<Date>>() {
            @Override
            public ObservableValue<Date> call(TableColumn.CellDataFeatures<Vols, Date> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getDate_arrive());
            }
        });
        ar.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Vols, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getVille_depart());
            }
        });
        des.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, String>, ObservableValue<String>>() {
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
           p .setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, Float>, ObservableValue<Float>>() {
         @Override
         public ObservableValue<Float> call(TableColumn.CellDataFeatures<Vols, Float> param) {
         return new ReadOnlyObjectWrapper(param.getValue().getPrix());
         }
         });
           type.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Vols, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getType_vol());
            }
        });
           placedisponible.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Vols, Integer> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getPlacedisp());
            }
        });
              System.out.println(listeVols);
    }
        // TODO

  

    @FXML
    private void sshow(ActionEvent event) throws SQLException {
        VolService service = new VolService();


        /* add column to the tableview and set its items */
        ObservableList<Vols> listeVols = FXCollections.observableArrayList(service.getALLVolss());
        tabrecherche.setItems(listeVols);

          de.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Vols, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getVille_arrive());
            }
        });
      
        dv.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, Date>, ObservableValue<Date>>() {
            @Override
            public ObservableValue<Date> call(TableColumn.CellDataFeatures<Vols, Date> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getDate_depart());
            }
        });
        fv.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, Date>, ObservableValue<Date>>() {
            @Override
            public ObservableValue<Date> call(TableColumn.CellDataFeatures<Vols, Date> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getDate_arrive());
            }
        });
        ar.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Vols, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getVille_depart());
            }
        });
        des.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, String>, ObservableValue<String>>() {
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
           p .setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, Float>, ObservableValue<Float>>() {
         @Override
         public ObservableValue<Float> call(TableColumn.CellDataFeatures<Vols, Float> param) {
         return new ReadOnlyObjectWrapper(param.getValue().getPrix());
         }
         });
           type.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Vols, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getType_vol());
            }
        });
           placedisponible.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Vols, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Vols, Integer> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getPlacedisp());
            }
        });
          
    }

    @FXML
    private void reserver(ActionEvent event) throws SQLException {
        
          if (tabrecherche.getSelectionModel().getSelectedItem() != null) {

            
             int idv = tabrecherche.getSelectionModel().getSelectedItem().getId_vol();
             int ida = tabrecherche.getSelectionModel().getSelectedItem().getId_agence();
              System.out.println(idv);
              System.out.println(ida);
             int nbra=Integer.parseInt(nbradulte.getText());
             int nbre=Integer.parseInt(nbrenfant.getText());
             float pr=tabrecherche.getSelectionModel().getSelectedItem().getPrix();
             double p=pr*nbra+(pr*0.8*nbre);
             prixx.setText(Double.toString(p));
             int nbr=nbre+nbra;
             int pla=tabrecherche.getSelectionModel().getSelectedItem().getPlacedisp();
             if(nbr>pla)
             {Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("information Dialog");
            alert2.setHeaderText(null);
            alert2.setContentText("Seulement "+pla+" places disponible!");
            alert2.show();}else{
             UtilisateurServices su = new UtilisateurServices();
             Utilisateur u = su.retournerUtilisateur();
             ReservationVols v=new ReservationVols(idv,u.getIdu(),ida);
             ReservationVolService sa=new ReservationVolService();
                 try {
                     sa.ajoutreservation(v);
                 } catch (SQLException ex) {
                     Logger.getLogger(AffichzgeRechercheFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                 }
             ReservationVolService ee=new ReservationVolService();
             ee.updateplaces(idv,pla,nbr);
        
             }} else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez selectionner un voyage organise");
            alert.show();
        }
    
            
        
      
            
             
        
       
            
            
            
           
        
    }
    }    
    

