/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entites.Agence;
import Entites.Utilisateur;
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
 * @author challakh
 */
public class AdminService {
    Connection connexion;

    public AdminService() {
                connexion =Singleton.getInstance().getConnection();

    }

    public AdminService(Connection connexion) {
        this.connexion = connexion;
    }
 public List<Agence> getALLAgencesnNonVerifie() throws SQLException
  { List<Agence> agences= new ArrayList<>();
      String req="SELECT * FROM `agence` where `verifier`=?";
      PreparedStatement stm=connexion.prepareStatement(req);
              stm.setInt(1,0);
      ResultSet rst= stm.executeQuery();
      
      while(rst.next())
      {Agence a=new Agence();
           a.setId(rst.getInt(1));
     a.setNom(rst.getString(2));
     a.setEmail(rst.getString(3));
     a.setMdp(rst.getString(4));
     a.setAdresse(rst.getString(5));
     a.setTelephone(rst.getInt(6));
     a.setFax(rst.getInt(7));
     a.setConnecter_agence(rst.getInt(8));
     a.setRole(rst.getInt(9));
          agences.add(a);
      }
      return agences;}
     public List<Agence> getALLAgencesnNonBloque() throws SQLException
  { List<Agence> agences= new ArrayList<>();
      String req="SELECT * FROM `agence` where `bloquer`=?";
      PreparedStatement stm=connexion.prepareStatement(req);
              stm.setInt(1,0);
      ResultSet rst= stm.executeQuery();
      
      while(rst.next())
      {Agence a=new Agence();
           a.setId(rst.getInt(1));
     a.setNom(rst.getString(2));
     a.setEmail(rst.getString(3));
     a.setMdp(rst.getString(4));
     a.setAdresse(rst.getString(5));
     a.setTelephone(rst.getInt(6));
     a.setFax(rst.getInt(7));
     a.setConnecter_agence(rst.getInt(8));
     a.setRole(rst.getInt(9));
          agences.add(a);
      }
      return agences;}
      public List<Agence> getALLAgencesnBloque() throws SQLException
  { List<Agence> agences= new ArrayList<>();
      String req="SELECT * FROM `agence` where `bloquer`=?";
      PreparedStatement stm=connexion.prepareStatement(req);
              stm.setInt(1,1);
      ResultSet rst= stm.executeQuery();
      
      while(rst.next())
      {Agence a=new Agence();
           a.setId(rst.getInt(1));
     a.setNom(rst.getString(2));
     a.setEmail(rst.getString(3));
     a.setMdp(rst.getString(4));
     a.setAdresse(rst.getString(5));
     a.setTelephone(rst.getInt(6));
     a.setFax(rst.getInt(7));
     a.setConnecter_agence(rst.getInt(8));
     a.setRole(rst.getInt(9));
          agences.add(a);
      }
      return agences;}
    public void VerifierCompteAgence(int id) throws SQLException
    {
        String req= "UPDATE `agence` SET`verifier`=? WHERE  `Id_agence`=?";
     PreparedStatement PS=connexion.prepareStatement(req);
     PS.setInt(1,1);
     PS.setInt(2,id);
     
     PS.executeUpdate();
    }
      public void BloquerCompteAgence(int id) throws SQLException
    {
        String req= "UPDATE `agence` SET `bloquer`=? WHERE  `Id_agence`=?";
     PreparedStatement PS=connexion.prepareStatement(req);
     PS.setInt(1,1);
     PS.setInt(2,id);
     
     PS.executeUpdate();
    }
       public void DebloquerCompteAgence(int id) throws SQLException
    {
        String req= "UPDATE `agence` SET `bloquer`=? WHERE  `Id_agence`=?";
     PreparedStatement PS=connexion.prepareStatement(req);
     PS.setInt(1,0);
     PS.setInt(2,id);
     
     PS.executeUpdate();
    }
        public List<Utilisateur> getALLUtilisateursbloque() throws SQLException
  { List<Utilisateur> utilisateurs= new ArrayList<>();
      String req="SELECT * FROM `utilisateur` where `bloquer`=?";
     PreparedStatement stm=connexion.prepareStatement(req);
              stm.setInt(1,1);
      ResultSet rst= stm.executeQuery();
      
      while(rst.next())
      {
          Utilisateur a=new Utilisateur();
         a.setIdu(rst.getInt(1));
     a.setNomu(rst.getString(2));
     a.setPrenomu(rst.getString(3));
     a.setEmailu(rst.getString(4));
     a.setMdpu(rst.getString(5));
     a.setSexeu(rst.getString(6));
     a.setConnecteru(rst.getInt(7));
     a.setAdresseu(rst.getString(8));
     a.setTelephoneu(rst.getInt(9));
          a.setRole(rst.getInt(10));
          utilisateurs.add(a);
      }
      return utilisateurs;}
         public List<Utilisateur> getALLUtilisateursNonbloque() throws SQLException
  { List<Utilisateur> utilisateurs= new ArrayList<>();
      String req="SELECT * FROM `utilisateur` where `bloquer`=?";
     PreparedStatement stm=connexion.prepareStatement(req);
              stm.setInt(1,0);
      ResultSet rst= stm.executeQuery();
      
      while(rst.next())
      { Utilisateur a=new Utilisateur();
         a.setIdu(rst.getInt(1));
     a.setNomu(rst.getString(2));
     a.setPrenomu(rst.getString(3));
     a.setEmailu(rst.getString(4));
     a.setMdpu(rst.getString(5));
     a.setSexeu(rst.getString(6));
     a.setConnecteru(rst.getInt(7));
     a.setAdresseu(rst.getString(8));
     a.setTelephoneu(rst.getInt(9));
          a.setRole(rst.getInt(10));
          utilisateurs.add(a);
      }
      return utilisateurs;}
       public void DebloquerCompteUser(int id) throws SQLException
    {
        String req= "UPDATE `utilisateur` SET `bloquer`=? WHERE  `Id_user`=?";
     PreparedStatement PS=connexion.prepareStatement(req);
     PS.setInt(1,0);
     PS.setInt(2,id);
     
     PS.executeUpdate();
    }
        public void BloquerCompteUser(int id) throws SQLException
    {
        String req= "UPDATE `utilisateur` SET `bloquer`=? WHERE  `Id_user`=?";
     PreparedStatement PS=connexion.prepareStatement(req);
     PS.setInt(1,1);
     PS.setInt(2,id);
     
     PS.executeUpdate();
    }
}
