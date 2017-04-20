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
	static int mode = 0;

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

}
