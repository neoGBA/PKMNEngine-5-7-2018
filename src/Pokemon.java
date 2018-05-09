import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Pokemon {
	int level;
	
	Image icon;
	
	String gen = "Gen4";
	
	String name = "";
	String type = "";
	String type2 = null;
	
	int HP;
	int MaxHP;
	int Attack;
	int Defense;
	int SpecialAttack;
	int SpecialDefense;
	int Speed;
	
	String status = " ";
	
	
	ArrayList<Move> PokemonMoves = new ArrayList<Move>();
	
	public Pokemon() {		

	}
	
	public Pokemon(String name2, int newlevel, int baseHP, int baseAttack, int baseDefense, int baseSpecialAttack, int baseSpecialDefense, int baseSpeed, String newtype) {
		name = name2;
		type = newtype;
		level = newlevel;
		
		HP = calculateHP(baseHP, newlevel);
		MaxHP = HP;
		Attack = calculateOtherStat(baseAttack, newlevel);
		Defense = calculateOtherStat(baseDefense, newlevel);
		SpecialAttack = calculateOtherStat(baseSpecialAttack, newlevel);
		SpecialDefense = calculateOtherStat(baseSpecialDefense, newlevel);
		Speed = calculateOtherStat(baseSpeed, newlevel);
	}
	
	public Pokemon(String name2, int newlevel, int baseHP, int baseAttack, int baseDefense, int baseSpecialAttack, int baseSpecialDefense, int baseSpeed, String newtype, String newtype2) {
		//if type 2 is used, this constructor is used
		name = name2;
		type = newtype;
		type2 = newtype2;
		level = newlevel;
		
		HP = calculateHP(baseHP, newlevel);
		MaxHP = HP;
		Attack = calculateOtherStat(baseAttack, newlevel);
		Defense = calculateOtherStat(baseDefense, newlevel);
		SpecialAttack = calculateOtherStat(baseSpecialAttack, newlevel);
		SpecialDefense = calculateOtherStat(baseSpecialDefense, newlevel);
		Speed = calculateOtherStat(baseSpeed, newlevel);
	}
	
	public String getImagePath() {
		String filePath = "/res/"+ gen + "/" + name + ".png";
		return filePath;
	}
	
	public int calculateHP(int baseHP, int level) {
		Random rand = new Random(); 
		int newHP = (((baseHP + rand.nextInt(31)*2)*level)/100)+level+10;
		return newHP;
	}
	
	public int calculateOtherStat(int baseStat, int level) {
		Random rand = new Random();
		int newStat = (((2 * baseStat + rand.nextInt(31))* level)/100) + 5;
		return newStat;
	}
	
	public void setHP(int newHP) {
		HP = newHP;
		if(HP<0) {
			HP = 0;
		}
	}
	
	public void setStatus(String newStatus) {
		status = newStatus;
	}
	
	public String getName() {
		return name;
	}
	
	public String getStatus() {
		return status;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getHP() {
		return HP;
	}
	
	public int getMaxHP() {
		return MaxHP;
	}
	
	public String getTypeOne() {
		return type;
	}
	
	public String getTypeTwo() {
		if(type2==null) {
			type2 = "";
		}
		return type2;
	}
	
	public void printStats() {
		System.out.println("Name: " + name);
		System.out.println("HP: " + HP);
		System.out.println("Attack: " + Attack);
		System.out.println("Defense: " + Defense);
		System.out.println("Special Attack: " + SpecialAttack);
		System.out.println("Special Defense: " + SpecialDefense);
		System.out.println("Speed: " + Speed);
		
		System.out.println("\nMove 1:" + PokemonMoves.get(0).getName());
		if(PokemonMoves.size()>1) {
			System.out.println("Move 2:" + PokemonMoves.get(1).getName());
		}
		
		if(PokemonMoves.size()>2) {
			System.out.println("Move 3:" + PokemonMoves.get(2).getName());
		}
		
		if(PokemonMoves.size()>3) {
			System.out.println("Move 4:" + PokemonMoves.get(3).getName());
		}
	}
	
	public void addMove(Move move) {
		PokemonMoves.add(move);
	}
	
	public Image getIcon() throws SlickException{
		icon = new Image("res/icons/old/" +name+ ".png");
		return icon;
	}
	
}
