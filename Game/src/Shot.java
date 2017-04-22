import processing.core.PApplet;
import processing.core.PVector;

class Shot extends GameObject implements Hit
{
	//Declaration of variables
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
		pos = new PVector(x, y);  //position of shot
		forward = new PVector(0, 1);	//forward vector of shot
		this.theta = theta;		//rotation of shot
		this.len = len;			//size of shot
		this.lambda = lambda;   //half-life  
		this.on = 0;
		this.type = type;
    }
	
	//Collision handling. If a shot hits a ship, the ship's score decreases
	public void applyTo(Spaceship p) 
	{
		Spaceship.score --;	
	}
	
	//Renders shots
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
	
	//Updates shot position etc.
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
		  
		  //Collision handling for when shot hits green block
		  for(int i = 0 ; i < Game.gameObjects.size() ; i ++)
		    {
		        GameObject go = Game.gameObjects.get(i);
		        
		        if (go instanceof SpecialObj)
		        {
		          SpecialObj p = (SpecialObj) go; // p is of type power up so the only method we can call on p is applyTo
		          if (Game.dist(go.pos.x, go.pos.y, this.pos.x, this.pos.y) < 30)
		          {
		            p.applyTo(this);
		            Game.gameObjects.remove(go);
		          }
		        }
		    }
		
	}
	
}