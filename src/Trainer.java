import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trainer {
	
	boolean partyExists;
	
	String playerName;
	
	ArrayList<Pokemon> PlayerParty;
	
	public void setPlayerName(String newName) {
		playerName = newName;
	}
	
	public void addPokemonToParty(Pokemon poke, int num) {
		PlayerParty =  new ArrayList<Pokemon>(6);
		partyExists = true;
		PlayerParty.add(num, poke);
	}
	
	public Pokemon getPokemonFromParty(int num) {
		return PlayerParty.get(num);
	}
	
	public boolean partyExists() {
		return partyExists;
	}
}
