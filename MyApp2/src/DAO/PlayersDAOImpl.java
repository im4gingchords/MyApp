package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dto.Players;

public class PlayersDAOImpl implements PlayersDAO {

	public ArrayList<Players> retrieveAll() throws ClassNotFoundException, SQLException {
		ArrayList<Players> players = new ArrayList<Players>();
		System.out.println("Hey");
		String username = "05XyRxBcfa";
		String password = "C7MMoHmL97";
		String dbURL = "jdbc:mysql://remotemysql.com:3306/05XyRxBcfa";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(dbURL, username, password);
		PreparedStatement pt = con.prepareStatement("Select * from Players");
		ResultSet rs = pt.executeQuery();
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String name = rs.getString(2);
			System.out.println(name);
			String team = rs.getString(3);
			String status = rs.getString(4);

			Players p = new Players();
			p.setId(id);
			p.setName(name);
			p.setTeam(team);
			p.setStatus(status);

			players.add(p);
			
		}
		return players;

		

	}

	public void addPlayers(int id, String name, String team, String status) throws ClassNotFoundException, SQLException {

		Connection con = ConnectionClass.intializeConn();
		PreparedStatement pt = con.prepareStatement("Insert into Players Values(?,?,?,?)");
		pt.setInt(1,id);
		pt.setString(2,name);
		pt.setString(3,team);
		pt.setString(4,status);
		
		int i = pt.executeUpdate();
		System.out.println(i + "wohooo");
		
	}
	
	public void updateTeam(int id) throws ClassNotFoundException, SQLException {
		String username = "05XyRxBcfa";
		String password = "C7MMoHmL97";
		String dbURL = "jdbc:mysql://remotemysql.com:3306/05XyRxBcfa";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(dbURL, username, password);
		PreparedStatement pt = con.prepareStatement("Update Players set Team = 'Manchester' where Id = ?");
		pt.setInt(1,id);
		int i = pt.executeUpdate();
		System.out.println(i);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		PlayersDAOImpl p = new PlayersDAOImpl();
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		int id2 = sc.nextInt(); 
		String name = sc.next();
		String team = sc.next();
		String status = sc.next();
		
		p.addPlayers(id, name, team, status);
		p.updateTeam(id2);
	}


}
//private int id;
//private String name;
//private String team;
//private String status;