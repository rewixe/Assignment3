import processing.core.PApplet;
import processing.core.PShape;
import processing.core.PVector;

public class Spaceship extends GameObject 
{
	
	PApplet parent;
	
	PVector v;
	PVector acc;
	float theta; 
	float radius;
    float wgt = 1;
	PShape shape, flame;
	char n, s, w, e;
	
	static char fire;
	int health;
	private int K = 2;
	int type;
	public static int ammo;
	public static int score;
	
	Spaceship(Game p, float x, float y, float theta, float size, char n, char s, char w, char e, char fire, int type)
	{
		
	}
	
	void render()
	{
		
	}
	
	void update()
	{
		
	}
	
}