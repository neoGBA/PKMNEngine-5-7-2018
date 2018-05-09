import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Main extends BasicGame{
	
	Battle battleObj = new Battle();
	
	int listNum = 0, partySize = 0;
	
	int screenIndex = 0;
	
	int choice = 0, pointerX = 395, pointerY = 267;
	
	Image Title, pointer, TeamBuilder, icon, icon2, icon3, icon4, icon5, icon6, icon7, icon8, icon9;
	
	Image slotOne;
	
	public Main() {
		super("Battle Tower");
	}

	public static void main(String args[]) {
		
		makeWindow();
		Battle battle = new Battle();
		battle.startBattle();	
	}
	
	public static void makeWindow() {
		try {
			AppGameContainer app = new AppGameContainer(new Main());
			app.setDisplayMode(1280, 720, false);
			app.setShowFPS(false);
			app.setTargetFrameRate(60);
			app.setVSync(true);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException {
		drawTitle(g);
		drawTeamBuilder(g);
	}

	public void init(GameContainer container) throws SlickException {
		Title = new Image("res/BattleTowerTitle.png");
		pointer = new Image("res/pointer.png");
		
		TeamBuilder = new Image("res/TeamBuilder.png");
		
		icon = battleObj.PokemonList.get(listNum).getIcon();
		icon2 = battleObj.PokemonList.get(listNum+1).getIcon();
		icon3 = battleObj.PokemonList.get(listNum+2).getIcon();
		icon4 = battleObj.PokemonList.get(listNum+3).getIcon();
		icon5 = battleObj.PokemonList.get(listNum+4).getIcon();
		icon6 = battleObj.PokemonList.get(listNum+5).getIcon();
		icon7 = battleObj.PokemonList.get(listNum+6).getIcon();
		icon8 = battleObj.PokemonList.get(listNum+7).getIcon();
		icon9 = battleObj.PokemonList.get(listNum+8).getIcon();
		
		slotOne = new Image("res/pokeball.png");
	}
	
	public void update(GameContainer container, int delta) throws SlickException {
		titleInstructions(container);
		teamBuilderInstructions(container);
	}
	
	public void drawTitle(Graphics g) {
		if(screenIndex == 0) {
			Title.draw(0,0);
			pointer.draw(pointerX, pointerY);
		}
	}
	
	public void titleInstructions(GameContainer container) {
		if(screenIndex == 0) {
			Input input = container.getInput();
			if(input.isKeyPressed(Input.KEY_DOWN)) {
				choice++;
				if(choice > 3) {
					choice = 0;
				}
			}
			if(input.isKeyPressed(Input.KEY_UP)) {
				choice--;
				if(choice < 0) {
					choice = 3;
				}
			}
			
			if(choice == 0) {
				pointerX = 395;
				pointerY = 267;
			}
			if(choice == 1) {
				pointerX = 395;
				pointerY = 355;
			}
			if(choice == 2) {
				pointerX = 435;
				pointerY = 445;
			}
			if(choice == 3) {
				pointerX = 520;
				pointerY = 530;
			}
			
			if(choice==0 && input.isKeyPressed(Input.KEY_ENTER)) {
				screenIndex++;
			}
			
			if(choice==3 && input.isKeyPressed(Input.KEY_ENTER)) {
				System.exit(0);
			}
		}
	}
	
	public void drawTeamBuilder(Graphics g) throws SlickException {
		if(screenIndex == 1) {
			TeamBuilder.draw(0,0);
			//names
			g.drawString(battleObj.PokemonList.get(listNum).getName(), 970, 120);
			g.drawString(battleObj.PokemonList.get(listNum + 1).getName(), 970, 190);
			g.drawString(battleObj.PokemonList.get(listNum + 2).getName(), 970, 260);
			g.drawString(battleObj.PokemonList.get(listNum + 3).getName(), 970, 330);
			g.drawString(battleObj.PokemonList.get(listNum + 4).getName(), 970, 400);
			g.drawString(battleObj.PokemonList.get(listNum + 5).getName(), 970, 470);
			g.drawString(battleObj.PokemonList.get(listNum + 6).getName(), 970, 540);
			g.drawString(battleObj.PokemonList.get(listNum + 7).getName(), 970, 610);
			g.drawString(battleObj.PokemonList.get(listNum + 8).getName(), 970, 680);
			
			//icons
			icon.draw(900,90,2);
			icon2.draw(900,160,2);
			icon3.draw(900,230,2);
			icon4.draw(900,300,2);
			icon5.draw(900,370,2);
			icon6.draw(900,440,2);
			icon7.draw(900,510,2);
			icon8.draw(900,580,2);
			icon9.draw(900,650,2);
			
			//sets icons as it scrolls
			icon = battleObj.PokemonList.get(listNum).getIcon();
			icon2 = battleObj.PokemonList.get(listNum+1).getIcon();
			icon3 = battleObj.PokemonList.get(listNum+2).getIcon();
			icon4 = battleObj.PokemonList.get(listNum+3).getIcon();
			icon5 = battleObj.PokemonList.get(listNum+4).getIcon();
			icon6 = battleObj.PokemonList.get(listNum+5).getIcon();
			icon7 = battleObj.PokemonList.get(listNum+6).getIcon();
			icon8 = battleObj.PokemonList.get(listNum+7).getIcon();
			icon9 = battleObj.PokemonList.get(listNum+8).getIcon();
			
			if(battleObj.partyInitiated()) {
				slotOne = battleObj.getFromPlayerParty(0).getIcon();
				slotOne.draw(30,100,2);
				g.drawString(battleObj.getFromPlayerParty(0).getName(), 120, 130);
				g.drawString("Lv " + battleObj.getFromPlayerParty(0).getLevel(), 220, 130);
				
				g.drawRect(30, 180, 200, 30);
				g.setColor(Color.green);
				g.fillRect(35, 185, 190, 20);
				g.setColor(Color.white);
				
				g.drawString("HP: "+ battleObj.getFromPlayerParty(0).getHP() + "/" + battleObj.getFromPlayerParty(0).getMaxHP(), 240, 185);
			
				g.drawString(battleObj.getFromPlayerParty(0).getName(), 10, 10);
				if(battleObj.Player.PlayerParty.size()>1) {
					g.drawString(battleObj.getFromPlayerParty(1).getName(), 10, 30);
				}
				
			}else {
				slotOne.draw(30,100);
			}
		}
	}
	
	public void teamBuilderInstructions(GameContainer container) throws SlickException {
		if(screenIndex == 1) {
			Input input = container.getInput();
			
			int MouseX = input.getMouseX();
			int MouseY = input.getMouseY();
			
			
			if(input.isKeyDown(Input.KEY_DOWN)) {
				if(listNum!=battleObj.PokemonList.size()-9) {
					listNum++;
					try {
						Thread.sleep(90);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if(input.isKeyDown(Input.KEY_UP)) {
				listNum--;
				try {
					Thread.sleep(90);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(listNum<0) {
					listNum = 0;
				}
			}
			
				if(MouseX>891 && MouseY>86 && MouseY<166) {
					if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
					battleObj.addToPlayerParty(battleObj.PokemonList.get(listNum), partySize);
					partySize++;
					}
				}
				if(MouseX>892 && MouseY>170 && MouseY<234) {
					if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
					battleObj.addToPlayerParty(battleObj.PokemonList.get(listNum+1), partySize);
					partySize++;
					}
				}
				if(MouseX>892 && MouseY>240 && MouseY<304) {
					if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
					battleObj.addToPlayerParty(battleObj.PokemonList.get(listNum+2), partySize);
					partySize++;
					}
				}
				
				if(MouseX>892 && MouseY>310 && MouseY<374) {
					if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
					battleObj.addToPlayerParty(battleObj.PokemonList.get(listNum+3), partySize);
					partySize++;
					}
				}
				if(MouseX>892 && MouseY>380 && MouseY<444) {
					if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
					battleObj.addToPlayerParty(battleObj.PokemonList.get(listNum+4), partySize);
					partySize++;
					}
				}
				if(MouseX>892 && MouseY>450 && MouseY<514) {
					if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
					battleObj.addToPlayerParty(battleObj.PokemonList.get(listNum+5), partySize);
					partySize++;
					}
				}
				if(MouseX>892 && MouseY>520 && MouseY<584) {
					if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
					battleObj.addToPlayerParty(battleObj.PokemonList.get(listNum+6), partySize);
					partySize++;
					}
				}
			
		}
	}
}
