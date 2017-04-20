import processing.core.PApplet;
import processing.core.PConstants;
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
	
	void render()
	{
		parent.pushStyle();
		parent.strokeWeight(3);
		parent.pushMatrix();
	    parent.translate(pos.x, pos.y);
	    parent.noFill();
	    parent.rotate(theta);
	    parent.stroke(255, 0, 0);
	    parent.rectMode(PConstants.CENTER);
	    parent.rect(0, 0, 30, 30);
	    parent.popMatrix();
	    parent.popStyle();
		
	}
	
	void update()
	{
		
	}
}