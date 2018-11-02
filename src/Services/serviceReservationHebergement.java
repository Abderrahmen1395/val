/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entites.Hebergement;
import Entites.ReservationHebergement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Utiles.Singleton;

/**
 *
 * @author Y520-I7-1TR-4G
 */
public class serviceReservationHebergement {
     
    Connection con = Singleton.getInstance().getConnection();
    private Statement st;

    public serviceReservationHebergement() {
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
   
       
       
    public List<Hebergement> retournerHebergementadres(String adresse) {
        List<Hebergement> list=new ArrayList<>();
       
            String req ="SELECT idHebergement, idAgence,nomAgence ,type_Hebergement, nom_Hebergement, nombre_etoile,Adresse_Hebergement,nombre_chambre,prix_single, prix_double,taux_demi,taux_complet ,tel,description , image FROM hebergement WHERE Adresse_Hebergement= ? " ;
            PreparedStatement preparedStatement;
            try{  preparedStatement = con.prepareStatement(req);
            preparedStatement.setString(1,adresse);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                preparedStatement = con.prepareStatement(req);
            preparedStatement.setString(1,adresse);
                Hebergement p=new Hebergement();
               
                 p.setIdHebergement(rs.getInt(1));
               p.setIdAgence(rs.getInt(2));
                p.setNomAgence(rs.getString(3));
                p.setType_Hebergement(rs.getString(4));
                p.setNom_Hebergement(rs.getString(5));
               p.setNombre_etoile(rs.getInt(6));
                              
  p.setAdresse_Hebergement(rs.getString(7)); 
                p.setNombre_chambre(rs.getInt(8));
                p.setPrix_single(rs.getInt(9));
                p.setPrix_double(rs.getInt(10));
                p.setTaux_demi(rs.getInt(11));
                p.setTaux_complet(rs.getInt(12));
                p.setTel(rs.getInt(13));
                 p.setDescription(rs.getString(14));
                  p.setImage(rs.getString(15));
                       
                     
                
                list.add(p);
            }
           
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(serviceReservationHebergement.class.getName()).log(Level.SEVERE, null, ex);
        }
 return list;    }

    public void updateplaces(int idv,int pla,int nbr) throws SQLException{
        String sqlupdate = "update hebergement set nombre_chambre=? where idHebergement="+idv ;
        PreparedStatement preupdate = con.prepareStatement(sqlupdate);

        
        preupdate.setInt(1, pla-nbr);
        
        
        preupdate.executeUpdate();
    }
     public void ajoutreservation(ReservationHebergement v) throws SQLException
    {
        
        
         String reqq="insert into reservation_hebergement (idHebergement,idUtilisateur,idAgence) values (?,?,?)";

        PreparedStatement pree=con.prepareStatement(reqq);
        

        pree.setInt(1, v.getIdHebergement());

        pree.setInt(2, v.getIdUtilisateur());
        pree.setInt(3, v.getIdAgence());

        pree.executeUpdate(); 
        System.out.println("reservation avec succes");
    }




}
    

    
     
  