import processing.core.PApplet;
import processing.core.PShape;
import processing.core.PVector;

public class Spaceship extends GameObject 
{
	
	PApplet parent;
	
	PVector v;
	PVector acc;
	PVector f;
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
		parent = p;
	    pos = new PVector(x, y);
	    forward = new PVector(0, -1);
	    acc = new PVector(0,0);
	    v = new PVector(0,0);
	    f = new PVector(0, 0);
	    this.theta = theta;
	    this.size = size;
	    radius = size / 2;
	    this.type = type;
	    
	    this.w = w;
	    this.e = e;
	    this.n = n;
	    this.s = s;
	    this.fire = fire;
	    this.health = 10;
	    Spaceship.ammo = 10;
	    Spaceship.score = 80;
		
	}
	
	void render()
	{
		
	}
	
	void update()
	{
		
	}
	
}