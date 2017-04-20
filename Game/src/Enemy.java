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
	
	static float spsEnemy = 0.05f;
	float limit = 5.0f / spsEnemy;
	float limitPass = limit;
	
	void update()
	{
		theta += 0.2; //rotation of enemy
		pos.add(forward);
		
	    if ((parent.millis()/100) % 30 == 0 && limitPass > limit && Game.mode == 1)
	    {
	    	parent.line(246, 250, 400, 400);
	    	parent.background(255, 0, 0);
	    	PVector bp = PVector.add(pos, PVector.mult(forward, 40));
	    	Shot b = new Shot((Game) parent, bp.x, bp.y, theta, 20, 5, 1);
	    	Game.gameObjects.add(b);
	    	limitPass = 0; //hmm
	    	if(limitPass > limit)
	    	{
	    		Game.gameObjects.remove(b);
	    	}
	    }
	    
	    limitPass = limitPass + (Game.timeDelta);
		
		
	}
}