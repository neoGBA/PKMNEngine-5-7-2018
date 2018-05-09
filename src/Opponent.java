import java.util.ArrayList;

public class Opponent {

	String opponentName;
	
	ArrayList<Pokemon> EnemyParty = new ArrayList<Pokemon>();
	
	public void setOpponentName(String newName) {
		opponentName = newName;
	}
	
	public void addPokemonToParty(Pokemon poke) {
		EnemyParty.add(poke);
	}
	
	public Pokemon getPokemonFromParty(int num) {
		return EnemyParty.get(num);
	}
}
