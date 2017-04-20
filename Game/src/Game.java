import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PFont;

public class Game extends PApplet 
{
	public static Game applet;
	
	static int mode = 0;
	//static int score;
	PFont myFont;
	PFont myFont2;
	int lvlCnt = 1;
	
	static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

	public static void main(String[] args) 
	{
		PApplet.main("Game");
	}
	
	public void settings()
	{
		fullScreen();
		//size(1000, 800);
	}
	
	public void setup()
	{
		Spaceship player0 = new Spaceship(this, 250, 250, 0, 30, 'w', 's', 'a', 'd', ' ', 0);
		Spaceship player1 = new Spaceship(this, 250, 248, 0, 32, 'w', 's', 'a', 'd', ' ', 1);
		gameObjects.add(player0);
		gameObjects.add(player1);
	}
	
	static boolean[] keys = new boolean[1000];

	static float timeDelta = 1.0f / 60.0f;

	public void keyPressed()
	{
		keys[keyCode] = true;
	}
	 
	public void keyReleased()
	{
		keys[keyCode] = false; 
	}

	static boolean checkKey(int k)
	{
		if (keys.length >= k) 
		{
			return keys[k] || keys[Character.toUpperCase(k)];  
		}
		return false;
	}
	
	public void draw()
	{	
		background(0);
		stroke(0, 255, 0);
		noFill();
		
		if(mode == 0)
		{
			pushStyle();
			fill(255, 0, 0);
		    String fontName = "Calibri Light Italic";
		    String fontName2 = "Liberation Sans Narrow";
		    myFont = createFont(fontName, 60);
		    textFont(myFont);
		    pushStyle();
		    textAlign(CENTER);
			text("SPACE SHOOTER", width/2, height/2);
			popStyle();
			myFont2 = createFont(fontName2, 17);
			textFont(myFont2);
			pushStyle();
			fill(0, 255, 0);
			textAlign(CENTER);
			text("Shoot green blocks to increase score, "
					+ "hit them to increase ammo!", width/2, height/2 + 30);
			popStyle();
			pushStyle();
			fill(255, 0, 0);
			textAlign(CENTER);
			text("Avoid red blocks!", width/2, height/2 + 60);
			popStyle();
			pushStyle();
			textAlign(CENTER);
			noFill();
			stroke(255, 0, 0);
			rect(width/2-75, height/2+100, 150, 60, 20);
			text("P L A Y", width/2, height/2 + 135);
			rect(width/2-75, height/2+170, 150, 60, 20);
			text("S E T T I N G S", width/2, height/2 + 205);
			rect(width/2-75, height/2+240, 150, 60, 20);
			text("S C O R E B O A R D", width/2, height/2 + 275);
			popStyle();
			
			stroke(255, 0, 0);
			noFill();
			strokeWeight(1);
			ellipse(250, 265, 130, 130);
			line(315, 265, 380, 210);
			text("WASD to move, space to shoot", 380, 210);
			popStyle();
			
			for (int i = gameObjects.size() -1 ; i >= 0  ; i --)
			{
				GameObject go = gameObjects.get(i);
				if(go instanceof Spaceship)
				{ 
					go.update();
					go.render();  
				}
			}
			
		} //end mode 0
		
		if(mode == 1 && Spaceship.score >= 0)
		{	
			noCursor();
			pushStyle();
			fill(0);
			stroke(255, 0, 0);
			rect((width/2)-75, height-80, 150, 60, 25);
			rect((width/2) + 80, height-80, 85, 60, 25);
			fill(255, 0, 0);
			text("S C O R E :", (width/2) - 55, height-55);
			text(Spaceship.score, (width/2) + 40, height-55);
			text("A M M O :", (width/2) - 55, height-30);
			text(Spaceship.ammo, (width/2) + 25, height-30);
			text("L E V E L :", (width/2) + 90, height-55);
			text(lvlCnt, (width/2) + 120, height-30);
			popStyle();
			
			for (int i = gameObjects.size() -1 ; i >= 0  ; i --)
			{
				GameObject go = gameObjects.get(i); 
				go.update();
				go.render();
				if(Spaceship.score > 20 && mode == 1)
				{
					Enemy.spsEnemy = 1;
				}
				
				if(Spaceship.score > 40 && mode == 1)
				{
					Enemy.spsEnemy = 1.5f;
					lvlCnt = 2;
				}
				
				if(Spaceship.score > 60 && mode == 1)
				{
					Enemy.spsEnemy = 2;
					lvlCnt = 3;
				}
				
				if(Spaceship.score > 80 && mode == 1)
				{
					Enemy.spsEnemy = 3;
					lvlCnt = 4;
				}
				
				if(Spaceship.score > 99 && mode == 1)
				{
					mode = 5;
				}
			}
		
		} // end mode 1
	}//end draw
	

}//end class
