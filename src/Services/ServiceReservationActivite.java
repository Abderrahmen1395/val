
package Services;





import Entites.ReservationActivite;
import Entites.Utilisateur;
import Services.ActiviteService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import Utiles.Singleton;


public class ServiceReservationActivite {
     public Connection con=  Singleton.getInstance().getConnection();
    public Statement ste;
     ResultSet rs;
    PreparedStatement pst;
    public ServiceReservationActivite()
    {
        
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ServiceReservationActivite.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
    public void updateplaces(int idv,int pla,int nbr) throws SQLException{
        String sqlupdate = "update activite set PlaceDisponible=? where id_activite="+idv ;
        PreparedStatement preupdate = con.prepareStatement(sqlupdate);

        
        preupdate.setInt(1, pla-nbr);
        
        
        preupdate.executeUpdate();
    }
    
    public void ajoutreservation(ReservationActivite v) throws SQLException
    {
        
        
         String reqq="insert into reserveractivite (Id_activite,Id_user,Id_agence) values (?,?,?)";
         
        PreparedStatement pree=con.prepareStatement(reqq);
        

        pree.setInt(1, v.getId_activite());

        pree.setInt(2, v.getId_user());
        pree.setInt(3, v.getId_agence());

        pree.executeUpdate(); 
        System.out.println("reservation avec succes");
    }
    
   
    
}

