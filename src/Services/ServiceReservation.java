
package Services;





import Entites.ReservationVoyageOrganise;
import Entites.Utilisateur;
import Services.ServiceVoyageOrganise;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import Utiles.Singleton;


public class ServiceReservation {
     public Connection con=  Singleton.getInstance().getConnection();
    public Statement ste;
     ResultSet rs;
    PreparedStatement pst;
    public ServiceReservation()
    {
        
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ServiceVoyageOrganise.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
    public void updateplaces(int idv,int pla,int nbr) throws SQLException{
        String sqlupdate = "update VoyageOrganise set nb_places=? where id="+idv ;
        PreparedStatement preupdate = con.prepareStatement(sqlupdate);

        
        preupdate.setInt(1, pla-nbr);
        
        
        preupdate.executeUpdate();
    }
    
    public void ajoutreservation(ReservationVoyageOrganise v) throws SQLException
    {
        
        
         String reqq="insert into reservervoyageorganise (id_voyageorganise,id_user,id_agence) values (?,?,?)";

        PreparedStatement pree=con.prepareStatement(reqq);
        

        pree.setInt(1, v.getId_voyageorganise());

        pree.setInt(2, v.getId_user());
        pree.setInt(3, v.getId_agence());

        pree.executeUpdate(); 
        System.out.println("reservation avec succes");
    }
    
   
    
}

