/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entites.Hebergement;
import java.io.InputStream;
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
public class serviceHebergement {
     Connection con = Singleton.getInstance().getConnection();
    private Statement st;

    public serviceHebergement() {
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void ajouterHebergement(Hebergement h)  {
        try {
        String sqlInsert = "INSERT INTO hebergement (nomAgence,idAgence,type_Hebergement, nom_Hebergement, nombre_etoile, Adresse_Hebergement,nombre_chambre,prix_single,prix_double,taux_demi,taux_complet,tel,description,image ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        PreparedStatement pre = con.prepareStatement(sqlInsert);
            
        pre.setString(1, h.getNomAgence());
        pre.setInt(2, h.getIdAgence());
        pre.setString(3, h.getType_Hebergement());
        pre.setString(4, h.getNom_Hebergement());
        pre.setInt(5, h.getNombre_etoile());
        pre.setString(6, h.getAdresse_Hebergement());
pre.setInt(7, h.getNombre_chambre());
        pre.setInt(8, h.getPrix_single());
                pre.setInt(9,h.getPrix_double());

       
        pre.setInt(10, h.getTaux_demi());
        pre.setInt(11, h.getTaux_complet());
         pre.setInt(12, h.getTel());
          pre.setString(13, h.getDescription());
 pre.setString(14,h.getImage());
        
        
        pre.executeUpdate(); 
   } catch (SQLException ex) {
        Logger.getLogger(serviceHebergement.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
     public void supprimerHebergement(int idHebergement) throws SQLException {
        String sql = "DELETE FROM hebergement WHERE idHebergement="+idHebergement;
        PreparedStatement stat= con.prepareStatement(sql);
        stat.executeUpdate();
        System.out.println("Hébergement supprime avec succes");
    }
    
      public void modifierHebergement(Hebergement h1,int idHebergement) throws SQLException {

        String sqlupdate = "update hebergement SET nomAgence=? ,type_Hebergement=?, nom_Hebergement=?, nombre_etoile=?,Adresse_Hebergement=?,nombre_chambre=?,prix_single=?, prix_double=?,taux_demi=?,taux_complet=? ,tel=?,description=? , image=?  WHERE idHebergement="+idHebergement;
        PreparedStatement preupdate = con.prepareStatement(sqlupdate);
        preupdate.setString(1, h1.getNomAgence());
        preupdate.setString(2, h1.getType_Hebergement());
        preupdate.setString(3,h1.getNom_Hebergement());
        preupdate.setInt(4, h1.getNombre_etoile());
        preupdate.setString(5, h1.getAdresse_Hebergement());
preupdate.setInt(6, h1.getNombre_chambre());
        preupdate.setInt(7, h1.getPrix_single());
               preupdate.setInt(8, h1.getPrix_double());

        
       preupdate.setInt(9, h1.getTaux_demi());
        preupdate.setInt(10, h1.getTaux_complet());
         preupdate.setInt(11, h1.getTel());
          preupdate.setString(12, h1.getDescription());
          preupdate.setString(13, h1.getImage());
          
          

        
        preupdate.executeUpdate();
        System.out.println("Modification  avec succes");

    }
     
      public List<Hebergement> afficherHebergement() {
       List<Hebergement> maListe = new ArrayList();
        try {
            Hebergement k=new Hebergement();
               
            Statement sta = con.createStatement();
            String requette = "SELECT idHebergement, idAgence,nomAgence ,type_Hebergement, nom_Hebergement, nombre_etoile, Adresse_Hebergement , nombre_chambre, prix_single, prix_double, taux_demi , taux_complet , tel , description , image from hebergement";
                     /*+ "nomAgence ,type_Hebergement, nom_Hebergement, nombre_etoile, Adresse_Hebergement , nombre_chambre, prix_single, prix_double, taux_demi , taux_complet , tel , description from hebergement WHERE idHebergement= ?";*/
           /*sta.setInt(1,U.getIdHebergement());*/
            ResultSet rs = sta.executeQuery(requette);
            
            while (rs.next()) {
                Hebergement U=new Hebergement();
               U.setIdHebergement(rs.getInt(1));
               U.setIdAgence(rs.getInt(2));
                U.setNomAgence(rs.getString(3));
                U.setType_Hebergement(rs.getString(4));
                U.setNom_Hebergement(rs.getString(5));
               U.setNombre_etoile(rs.getInt(6));
                U.setAdresse_Hebergement(rs.getString(7));
                U.setNombre_chambre(rs.getInt(8));
                U.setPrix_single(rs.getInt(9));
                U.setPrix_double(rs.getInt(10));
                U.setTaux_demi(rs.getInt(11));
                U.setTaux_complet(rs.getInt(12));
                U.setTel(rs.getInt(13));
                 U.setDescription(rs.getString(14));
                  U.setImage(rs.getString(15));
                  
                maListe.add(U);
            }
        } catch (SQLException ex) {
         System.err.println(ex.getMessage());  
        }

        return maListe;
        
    }
    
      
    }

