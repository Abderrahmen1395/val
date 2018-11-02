/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entites.Activite;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Utiles.Singleton;

/**
 *
 * @author challakh
 */
public class ActiviteService {
    Connection connexion;

    public ActiviteService(Connection connexion) {
        this.connexion = connexion;
    }

    public ActiviteService() {
        connexion =Singleton.getInstance().getConnection();
    }
    
    
    // AJOUTER UNE ACTIVITE
     public void ajouteractivite(Activite a) throws SQLException
  {
     String req= "INSERT INTO `activite` (`Nom`, `Type`, `Adresse`, `Pays`, `Region`, `Description`, `Prix`,`idAgence`,`PlaceDisponible`) VALUES ( ?,?,?,?,?,?,?,?,?) ";
     PreparedStatement PS=connexion.prepareStatement(req);
     PS.setString(1,a.getNom());
     PS.setString(2,a.getType());
     PS.setString(3,a.getAdresse());
     PS.setString(4,a.getPays());
     PS.setString(5,a.getRegion());
     PS.setString(6,a.getDescription());
     PS.setFloat(7,a.getPrix());
     PS.setInt(8,a.getId_agence());
     PS.setInt(9,a.getPlacedisponible());
     
     
     PS.executeUpdate();
     }
     
      /*public void ajouteractivite2(Activite a) throws SQLException
  {
     String req= "INSERT INTO `activite` (`Nom`, `Type`, `Adresse`, `Pays`, `Region`, `Description`, `Prix`,`id_agence`) VALUES ( ?,?,?,?,?,?,?,8)";
     PreparedStatement PS=connexion.prepareStatement(req);
     PS.setString(1,a.getNom());
     PS.setString(2,a.getType());
     PS.setString(3,a.getAdresse());
     PS.setString(4,a.getPays());
     PS.setString(5,a.getRegion());
     PS.setString(6,a.getDescription());
     PS.setFloat(7,a.getPrix());
     PS.setInt(8,a.getId_agence());
     PS.executeUpdate();
     
     }*/
      // AFFICHAGE 
     public List<Activite> afficherActivite() {
       List<Activite> maListe = new ArrayList();
        try {
            
            Statement sta = connexion.createStatement();
            String requette = "SELECT * from activite ";
            ResultSet rs = sta.executeQuery(requette);
            
            while (rs.next()) {
                Activite U=new Activite();
                U.setId(rs.getInt(1));
                U.setNom(rs.getString(2));
                U.setType(rs.getString(3));
                U.setAdresse(rs.getString(4));
                U.setPays(rs.getString(5));
                U.setRegion(rs.getString(6));
                U.setDescription(rs.getString(7));
                U.setPrix(rs.getFloat(8));
                U.setId_agence(rs.getInt(9));
                U.setPlacedisponible(rs.getInt(10));
                
                maListe.add(U);
            }
        } catch (SQLException ex) {
         System.err.println(ex.getMessage());  
        }

        return maListe;
        
    }
      
    /* public List<Activite> getALLActivities(String pays) throws SQLException
  { List<Activite> activites= new ArrayList<>();
  
      String req="SELECT * FROM activite WHERE Pays=?";
      PreparedStatement ps=connexion.prepareStatement(req);
      ps.setString(1, pays);
      ResultSet rs=ps.executeQuery();
      while(rs.next())
      {
          ps=connexion.prepareStatement(req);
          ps.setString(1, pays);
          Activite a=new Activite();
          a.setId(rs.getInt(1));
          a.setNom(rs.getString(2));
          a.setType(rs.getString(3));
          a.setAdresse(rs.getString(4));
          a.setPays(rs.getString(5));
          a.setRegion(rs.getString(6));
          a.setDescription(rs.getString(7));
          a.setPrix(rs.getFloat(8));
          a.setId_agence(rs.getInt(9));
          a.getPlacedisponible(rs.getInt(10));
         //Activite a=new Activite(rst.getInt("Id"),rst.getString("Nom"),rst.getString("Type"),rst.getString("Adresse"),rst.getString("Pays"),rst.getString("Region")
                //  ,rst.getString("Description"),rst.getFloat("Prix"));
          activites.add(a);
      }
      return activites;}*/
     
      
      
      
     //Modifier une activite
     public void modifierActivite(Activite a,int id) throws SQLException
  {
     String req= "UPDATE `activite` SET `Nom`=?,`Type`=?,`Adresse`=?,`Pays`=?,`Region`=?,`Description`=?,`Prix`=?,`PlaceDisponible`=? WHERE `id_activite`=?";
     PreparedStatement PS=connexion.prepareStatement(req);
     PS.setString(1,a.getNom());
     PS.setString(2,a.getType());
     PS.setString(3,a.getAdresse());
     PS.setString(4,a.getPays());
     PS.setString(5,a.getRegion());
     PS.setString(6,a.getDescription());
     PS.setFloat(7,a.getPrix());
     PS.setInt(8,a.getPlacedisponible());
     PS.setInt(9,id);
     PS.executeUpdate();
     }
     
   
     //Supprimer une activite
     public void supprimerProduit(int id) throws SQLException
  {
     String req= "DELETE FROM `activite` WHERE `id_activite`=?";
      PreparedStatement PS=connexion.prepareStatement(req);
     PS.setInt(1,id);
     PS.executeUpdate();
     }  
     
     
}
