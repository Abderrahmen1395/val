/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utiles.Singleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import Entites.ReservationVols;

public class ReservationVolService {
     public Connection con=  Singleton.getInstance().getConnection();
    public Statement ste;
     ResultSet rs;
    PreparedStatement pst;
    public ReservationVolService()
    {
        
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(VolService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
    public void updateplaces(int idv,int pla,int nbr) throws SQLException{
        String sqlupdate = "update vols set nb_places=? where id_vol="+idv ;
        PreparedStatement preupdate = con.prepareStatement(sqlupdate);

        
        preupdate.setInt(1, pla-nbr);
        
        
        preupdate.executeUpdate();
    }
    
    public void ajoutreservation(ReservationVols v) throws SQLException
    {
        
        
         String reqq="insert into reservationvol (Id_vol,Id_user,Id_agence) values (?,?,?)";

        PreparedStatement pree=con.prepareStatement(reqq);
        

        pree.setInt(1, v.getId_vol());

        pree.setInt(2, v.getId_user());
        pree.setInt(3, v.getId_agence());

        pree.executeUpdate(); 
        System.out.println("reservation avec succes");
    }
    
   
}