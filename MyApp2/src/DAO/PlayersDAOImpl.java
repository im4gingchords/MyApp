package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Players;

public class PlayersDAOImpl implements PlayersDAO{

	public void retrieveAll() throws ClassNotFoundException, SQLException {
	  ArrayList<Players> players = new ArrayList<Players>();
	  System.out.println("Hey");
	  String namei = "05XyRxBcfa";
		String username = "05XyRxBcfa";
		String password = "C7MMoHmL97";
		String dbURL = "jdbc:mysql://localhost:3306/"; 
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con = DriverManager.getConnection(dbURL+namei, username, password);
      PreparedStatement pt = con.prepareStatement("Select * from Players");
      ResultSet rs = pt.executeQuery();
      while(rs.next()) {
    	  int id  = rs.getInt("Id");
    	  String name = rs.getString("Name");
    	  String team = rs.getString("Team");
    	  String status = rs.getString("Status");
    	 
    	  Players p = new Players();
    	  p.setId(id);
    	  p.setName(name);
    	  p.setTeam(team);
    	  p.setStatus(status); 	 
    	  
    	  players.add(p);
      }
      
      System.out.println(players);
      
	}

public static void main(String[] args) throws ClassNotFoundException, SQLException {
	PlayersDAOImpl pl = new PlayersDAOImpl();
	pl.retrieveAll();
}

}

