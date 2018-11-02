/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Services.AgenceServices;
import Services.UtilisateurServices;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author challakh
 */
public class SignInController implements Initializable {

  
    @FXML
    private TextField text_usrname;
    @FXML
    private TextField text_password;
    @FXML
    private Button btn_seconnecter;
    @FXML
    private Button Signupbtn;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   

    @FXML
    private void seconnecter(ActionEvent event) throws SQLException {
        String a=text_usrname.getText();
        String b=text_password.getText();
        AgenceServices as=new AgenceServices();
        UtilisateurServices us=new UtilisateurServices();
        
        
        if((a.equals("admin"))&&(b.equals("admin")))
       {
            try {
                Parent root ;
                as.MettreAUn(text_usrname.getText());
                root = FXMLLoader.load(getClass().getResource("MenuAdminFXML.fxml"));
                
                Stage stage =new Stage();
                Scene scene = new Scene(root);
                
                stage.setTitle("");
                stage.setScene(scene);
                stage.show();
                ((Node)event.getSource()).getScene().getWindow().hide();
            } catch (IOException ex) {
                Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
        if((as.exist(a)==false)&&(us.exist(a)==false)&&(!a.equals("admin"))&&(!b.equals("admin")))
        {
             Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("incorrecte");
            alert.show();
        }
        else if((as.MotDePassseCorrect(a, b)==false)&&(us.MotDePassseCorrect(a, b)==false)&&(!a.equals("admin"))&&(!b.equals("admin")))
        {
           Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("information Dialog");
            alert1.setHeaderText(null);
            alert1.setContentText("incorrecte");
            alert1.show();  
        }
        else if(((as.exist(a))||(us.exist(a))&&((as.MotDePassseCorrect(a, b))||(us.MotDePassseCorrect(a, b)))))
        {   
           if(as.TrouveAgence(a))
           {
               try {
                   Parent root ;
                   as.MettreAUn(text_usrname.getText());
                   root = FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
                   
                   Stage stage =new Stage();
                   Scene scene = new Scene(root);
                   
                   stage.setTitle("");
                   stage.setScene(scene);
                   stage.show();
                   ((Node)event.getSource()).getScene().getWindow().hide();
               } catch (IOException ex) {
                   Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           if(us.TrouveUtilisateur(a))
           {
               try {
                   us.MettreAUn(text_usrname.getText());
                   Parent root ;
                   
                   root = FXMLLoader.load(getClass().getResource("MenuUtilisateur.fxml"));
                   
                   Stage stage =new Stage();
                   Scene scene = new Scene(root);
                   
                   stage.setTitle("");
                   stage.setScene(scene);
                   stage.show();
                   ((Node)event.getSource()).getScene().getWindow().hide();
               }
               /*  as.MettreAUn(text_usrname.getText());
               us.MettreAUn(text_usrname.getText());
               Parent root ;
               root = FXMLLoader.load(getClass().getResource("MenuPrincipal.fxml"));
               Stage stage =new Stage();
               Scene scene = new Scene(root);
               stage.setTitle("");
               stage.setScene(scene);
               stage.show();
               ((Node)event.getSource()).getScene().getWindow().hide();*/ catch (IOException ex) {
                   Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
               }
           
           }
           
               
              

           }


           
    }
    

    @FXML
    private void SignUp(ActionEvent event) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("UtilOuAgenceFXML.fxml"));
                       Parent root ;
        try {
            root=loader.load();
             Signupbtn.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
