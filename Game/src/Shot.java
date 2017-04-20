import processing.core.PApplet;
import processing.core.PVector;

class Shot extends GameObject
{
	PApplet parent;
	float theta;
	float len;
	float speed = 300;
	float lambda;
	float on;
	static int type;
	
	Shot(Game p, float x, float y, float theta, float len, float lambda, int type)
	{
	    parent = p;
		pos = new PVector(x, y);
		forward = new PVector(0, 1);
		this.theta = theta;
		this.len = len;
		this.lambda = lambda;    
		this.on = 0;
		this.type = type;
    }
	
	void render()
	{
		parent.pushMatrix();
		parent.pushStyle();
		parent.translate(pos.x, pos.y);
		parent.rotate(theta);
		parent.stroke(255);
		parent.line(0, - len / 2, 0, len / 2);
		parent.popStyle();
		parent.popMatrix();
	}
	
	void update()
	{
		forward.x = PApplet.sin(theta);
		  forward.y = - PApplet.cos(theta);
	    
		  pos.add(PVector.mult(PVector.mult(forward, speed), Game.timeDelta));
		  
		  if (pos.x > parent.width)
		  {
			  pos.x = 0;
		  }
		  
		  if (pos.x < 0)
		  {
			  pos.x = parent.width;
		  }
		  
		  if (pos.y > parent.height)
		  {
			  pos.y = 0;
		  }
		  
		  if (pos.y < 0)
		  {
			  pos.y = parent.height;
		  }
		  
		  on += Game.timeDelta;
	    
		  if (on > lambda)
		  {
			  Game.gameObjects.remove(this);
		  }
		  
		  for(int i = 0 ; i < Game.gameObjects.size() ; i ++)
		    {
		        GameObject go = Game.gameObjects.get(i);
		        	       //powerup... 
		    }
		
	}
	
}