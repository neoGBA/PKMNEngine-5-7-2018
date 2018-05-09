
public class Move {
	
	String name;
	String type;
	String moveType;
	int baseDamage;
	int accuracy;
	int MaxPP;
	int PP;
	
	public Move() {
		
	}
	
	public Move(String newName, String newType, String moveType2, int newBaseDamage, int newAccuracy, int newPP) {
		name = newName;
		type = newType;
		moveType = moveType2;
		baseDamage = newBaseDamage;
		accuracy = newAccuracy;
		PP = newPP;
		MaxPP = PP;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAccuracy() {
		return accuracy;
	}
	
	public int getPP() {
		return PP;
	}
	
	public int getMaxPP() {
		return MaxPP;
	}
	
	public void setPP(int newPP) {
		PP = newPP;
	}
	
}
