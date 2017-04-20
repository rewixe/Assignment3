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

}
