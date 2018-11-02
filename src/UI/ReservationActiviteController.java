
package UI;

import Entites.Activite;
import Entites.ReservationActivite;
import Entites.Utilisateur;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import Services.ActiviteService;
import Services.ServiceReservationActivite;
import Services.UtilisateurServices;

public class ReservationActiviteController implements Initializable {

    @FXML
    private TableView<Activite> tablereservation;
    @FXML
    private TableColumn<Activite, String> nom;
    @FXML
    private TableColumn<Activite, String> type;
    @FXML
    private TableColumn<Activite, String> adresse;
    @FXML
    private TableColumn<Activite, String> pays;
    @FXML
    private TableColumn<Activite, String> region;
    @FXML
    private TableColumn<Activite, String> description;
    @FXML
    private TableColumn<Activite, Float> prix;
    @FXML
    private Button reserver;
    @FXML
    private TextField nbrenfant;
    @FXML
    private TextField nbradulte;
    @FXML
    private TextField prixx;
    @FXML
    private TableColumn<Activite, Integer> place;

    
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
        ActiviteService service = new ActiviteService();
        ObservableList<Activite> listeHebergements = FXCollections.observableArrayList(service.afficherActivite());
        tablereservation.setItems(listeHebergements);
        
       
        
        
        nom.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Activite, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Activite, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getNom());
            }
        });
         TableColumn albumArt = new TableColumn("Album Art");
        albumArt.setCellValueFactory(new PropertyValueFactory("album"));
        albumArt.setPrefWidth(200);
        type.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Activite, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Activite, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getType());
            }
        });
        adresse.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Activite, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Activite, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getAdresse());
            }
        });
        pays.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Activite, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Activite, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getPays());
            }
        });
        region.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Activite, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Activite, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getRegion());
            }
        });
        description.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Activite, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Activite, String> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getDescription());
            }
        });
        prix.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Activite, Float>, ObservableValue<Float>>() {
            @Override
            public ObservableValue<Float> call(TableColumn.CellDataFeatures<Activite, Float> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getPrix());
            }
        });
        place.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Activite, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Activite, Integer> param) {
                return new ReadOnlyObjectWrapper(param.getValue().getPlacedisponible());
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
             float pr=tablereservation.getSelectionModel().getSelectedItem().getPrix();
             double p=pr*nbra+(pr*0.8*nbre);
             prixx.setText(Double.toString(p));
             int nbr=nbre+nbra;
             int pla=tablereservation.getSelectionModel().getSelectedItem().getPlacedisponible();
             if(nbr>pla)
             {Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("information Dialog");
            alert2.setHeaderText(null);
            alert2.setContentText("Seulement "+pla+" places disponible!");
            alert2.show();}else{
             UtilisateurServices su = new UtilisateurServices();
             Utilisateur u = su.retournerUtilisateur();
                 ReservationActivite v=new ReservationActivite(idv,u.getIdu(),ida);
             ServiceReservationActivite sa=new ServiceReservationActivite();
             sa.ajoutreservation(v);
             ServiceReservationActivite ee=new ServiceReservationActivite();
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