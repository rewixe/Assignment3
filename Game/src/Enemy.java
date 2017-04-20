import processing.core.PApplet;
import processing.core.PVector;

public class Enemy extends GameObject implements NegativeObj 
{
	
	public static Target applet;
	
	PApplet parent;
	
	float theta;
	
	Enemy(Game p)
	{
		parent = p;
		theta = 0;
		forward = new PVector(parent.random(-1,1), parent.random(-1,1));
	}
	
	public void applyTo(Spaceship p)
	{
		if (Spaceship.ammo > 0)
		{
			Spaceship.ammo --;
		}
	  
	  	Spaceship.score --;
	    
	}
	
}