package Service;

import java.sql.SQLException;
import java.util.ArrayList;

import DAO.PlayersDAO;
import DAO.PlayersDAOImpl;
import dto.Players;

public class PlayersService {
public ArrayList<Players> retrieve() throws ClassNotFoundException, SQLException{
	PlayersDAO p = new PlayersDAOImpl();
	ArrayList<Players> players = new ArrayList<Players>();
	players = p.retrieveAll();
	return players;
}
}
