/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entites.Vols;
import Utiles.Singleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RANI
 */
public class VolService {

    Connection connexion;

    public VolService(Connection connexion) {
        this.connexion = connexion;
    }

    public VolService() {
        connexion = Singleton.getInstance().getConnection();
    }

    //*********************************ajout*****************

    public void ajouteVol(Vols p) throws SQLException {
        String req = "INSERT INTO vols (date_depart,date_arrive,ville_depart,ville_arrive,prix,description,Type,nb_places,id_agence) VALUES (  ? ,? ,? ,? ,? ,? , ?,?,?  )";
        PreparedStatement PS = connexion.prepareStatement(req);
        PS.setDate(1, p.getDate_depart());
        PS.setDate(2, p.getDate_arrive());
        PS.setString(3, p.getVille_depart());
        PS.setString(4, p.getVille_arrive());
        PS.setFloat(5, p.getPrix());
        PS.setString(6, p.getDescription());
        PS.setString(7, p.getType_vol());
        PS.setInt(8, p.getPlacedisp());
        PS.setInt(9, p.getId_agence());

        PS.executeUpdate();
    }

    //**********affichage*************

    public List<Vols> getALLVols() throws SQLException {
        List<Vols> vols = new ArrayList<>();
        String req = "SELECT * FROM `vols`";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
            Vols p = new Vols(rst.getInt("id_vol"),rst.getDate("date_depart"), rst.getDate("date_arrive"), rst.getString("ville_depart"), rst.getString("ville_arrive"), rst.getFloat("prix"), rst.getString("description"), rst.getString("Type"), rst.getInt("nb_places"));
            vols.add(p);
        }
        return vols;
    }
     public List<Vols> getALLVolss() throws SQLException {
        List<Vols> vols = new ArrayList<>();
        String req = "SELECT  * FROM vols ";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);
        
        while (rst.next()) {
            Vols p = new Vols(rst.getInt(1),rst.getDate(2), rst.getDate(3), rst.getString(4), rst.getString(5), rst.getFloat(6), rst.getString(7), rst.getString(8), rst.getInt(9), rst.getInt(10));
            vols.add(p);
            System.out.println(p);
        }
        return vols;
    }

  public List<Vols> getALLVolsR(String depart, String arrive) throws SQLException {
        List<Vols> vols = new ArrayList<>();
                 System.out.println("*"+depart+"*");

        String req = "SELECT  `id_vol` ,`date_depart`, `date_arrive`, `ville_depart`, `ville_arrive`, `prix`, `description` , `type_vol` FROM `vols` WHERE `ville_depart`=? ";
        PreparedStatement PS = connexion.prepareStatement(req);
        PS.setString(1,"tunisia");
        ResultSet rst = PS.executeQuery(req);
        while (rst.next()) {
            Vols p = new Vols(rst.getInt("id_vol"), rst.getDate("date_depart"), rst.getDate("date_arrive"), rst.getString("ville_depart"), rst.getString("ville_arrive"), rst.getFloat("prix"), rst.getString("description"), rst.getString("type_vol"));
            vols.add(p);
        }
        return vols;
    }
  
    /*
  
     public ArrayList<Exercice> retournerExercice() throws SQLException
     {
     ArrayList<Exercice> listeExercice = new ArrayList();
     String req = "select id_exercice,type_exercice, nom_exercice,"
     + " description_exercice, duree_exercice,nombre_place_exercice,"
     + "date_exercice from Exercice";
     PreparedStatement pre = con.prepareStatement(req);
     ResultSet rs = pre.executeQuery();
     if(rs != null)
     {
     while (rs.next()) {
     int id= rs.getInt("id_exercice");
     String type = rs.getString("type_exercice");
     String nom = rs.getString("nom_exercice");
     String description = rs.getString("description_exercice");
     int duree = rs.getInt("duree_exercice");
     Date date = rs.getDate("date_exercice");
     int place = rs.getInt("nombre_place_exercice");
     Exercice e= new Exercice(id, nom, type, description, duree, date , place);
     listeExercice.add(e);
     }
     }   
     return listeExercice;
        
     }
     public ArrayList<Exercice> retournerExercice(String typeRecherche) throws SQLException
     {
     ArrayList<Exercice> listeExercice = new ArrayList();
     String req = "select id_exercice,type_exercice, nom_exercice,"
     + " description_exercice, duree_exercice,nombre_place_exercice,"
     + "date_exercice from Exercice where (type_exercice = ?)";
     PreparedStatement pre = con.prepareStatement(req);
     pre.setString(1, typeRecherche);
     ResultSet rs = pre.executeQuery();
     if(rs != null)
     {
     while (rs.next()) {
     int id= rs.getInt("id_exercice");
     String type = rs.getString("type_exercice");
     String nom = rs.getString("nom_exercice");
     String description = rs.getString("description_exercice");
     int duree = rs.getInt("duree_exercice");
     Date date = rs.getDate("date_exercice");
     int place = rs.getInt("nombre_place_exercice");
     Exercice e= new Exercice(id, nom, type, description, duree, date , place);
     listeExercice.add(e);
     }
     }   
     return listeExercice;
        
     }
     */

    //***************sup**************
    public void deleteVol(int id_vol) throws SQLException {
        String requete = "DELETE FROM vols WHERE id_vol=" + id_vol;
        Statement ste = connexion.createStatement();
        ste.executeUpdate(requete);
        System.out.println("vol supprime avec succes");
    }
             //***************recherche par id*****************

    public Vols findVolParId(int id_vol) {

        String sql = "SELECT * FROM `vols` WHERE `id_vol`= ? ";
        Vols p = new Vols();
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement(sql);
            preparedStatement.setInt(1, id_vol);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                p.setId_vol(resultSet.getInt(1));
                p.setDate_depart(resultSet.getDate(2));
                p.setDate_arrive(resultSet.getDate(3));
                p.setVille_depart(resultSet.getString(4));
                p.setVille_arrive(resultSet.getString(5));
                p.setPrix(resultSet.getFloat(6));
                p.setType_vol(resultSet.getString(7));

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return p;

    }

    //***********************update**********

    public void modifierVol(Vols e, int id) throws SQLException {
       
        String req = "UPDATE vols SET   ville_depart = ?, ville_arrive = ?, prix = ?, description = ? , Type = ?, nb_places = ?  where id_vol = " + id;
        PreparedStatement pre = connexion.prepareStatement(req);
      
        pre.setString(1, e.getVille_depart());
        pre.setString(2, e.getVille_arrive());
        pre.setFloat(3, e.getPrix());
        pre.setString(4, e.getDescription());
        pre.setString(5, e.getType_vol());
        pre.setInt(6, e.getPlacedisp());
        
        pre.executeUpdate();

    }

    public Vols rechercheVolVille(Vols e, int id) throws SQLException {
        return null;

    }

    public Vols trierVolPrix() throws SQLException {
        return null;

    }

    //******************************

    public List<Vols> getALLVols1() throws SQLException {
        List<Vols> vols = new ArrayList<>();
        String req = "SELECT * FROM `vols` WHERE `ville_depart`= ? ";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
            Vols p = new Vols(rst.getInt("id_vol"), rst.getDate("date_depart"), rst.getDate("date_arrive"), rst.getString("ville_depart"), rst.getString("ville_arrive"), rst.getFloat("prix"), rst.getString("description"), rst.getString("type_vol"));
            vols.add(p);
        }
        return vols;
    }

    //***********************************************

    public List<Vols> getALLVols2() throws SQLException {
        List<Vols> vols = new ArrayList<>();
        String req = "SELECT * FROM `vols` WHERE `date_arrive`= ? ";
        Statement stm = connexion.createStatement();
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
            Vols p = new Vols(rst.getInt("id_vol"), rst.getDate("date_depart"), rst.getDate("date_arrive"), rst.getString("ville_depart"), rst.getString("ville_arrive"), rst.getFloat("prix"), rst.getString("description"), rst.getString("type_vol"));
            vols.add(p);
        }
        return vols;
    }

    //*********************************

    public List<Vols> getALLVols3(String depart, String arrive) throws SQLException {
        List<Vols> vols = new ArrayList<>();
        String req = "SELECT *   FROM vols  WHERE (ville_depart=" + depart + "and ville_arrive=" + arrive+")";
        Statement stm = connexion.createStatement();
    //  PreparedStatement pre = connexion.prepareStatement(req);

        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {

            Vols p = new Vols(rst.getInt("id_vol"), rst.getDate("date_depart"), rst.getDate("date_arrive"), rst.getString("ville_depart"), rst.getString("ville_arrive"), rst.getFloat("prix"), rst.getString("description"), rst.getString("type_vol"));
            vols.add(p);

        }
        return vols;
    }

    //************
    public List<Vols> findVolParIdaff(String depart, String arrive) throws SQLException {

        String sql = "SELECT * FROM vols WHERE ville_depart= ? and ville_arrive=? ";
        
        List<Vols> vols = new ArrayList<>();

        PreparedStatement preparedStatement = connexion.prepareStatement(sql);
         preparedStatement.setString(1, depart);
        preparedStatement.setString(2, arrive);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            preparedStatement=connexion.prepareStatement(sql);
            preparedStatement.setString(1, depart);
        preparedStatement.setString(2, arrive);
       Vols p = new Vols();
            p.setId_vol(resultSet.getInt(1));
            p.setDate_depart(resultSet.getDate(2));
            p.setDate_arrive(resultSet.getDate(3));
            p.setVille_depart(resultSet.getString(4));
            p.setVille_arrive(resultSet.getString(5));
            //p.setDescription(resultSet.getString(6));
            p.setPrix(resultSet.getFloat(6));
            p.setDescription(resultSet.getString(7));
            p.setType_vol(resultSet.getString(8));

            vols.add(p);

        }
        return vols;
    }
}

/*PreparedStatement pre = connexion.prepareStatement(req);
        pre.setString(1, username);
        pre.setString(2, passe);
       ResultSet rs = pre.executeQuery();*/
