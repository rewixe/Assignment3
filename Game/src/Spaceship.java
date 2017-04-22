import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PShape;
import processing.core.PVector;

public class Spaceship extends GameObject 
{
	PApplet parent;
	
	//Variables
	float theta; 
	char n, s, w, e; //Controls
	float radius; 	 //Collision radius
    float wgt = 1;   //Weight of spaceship, used for momentum
	PShape shape, flame;	//PShapes for spaceship and it's flame
	
	PVector v;		//d/t
	PVector acc;	//change in v
	PVector f;		//f=wgt*acc
	
	static float sps = 2;				//shots speed
	static float limit = 1.0f / sps;	//limits consecutive shots
	static float limitPass = limit; 	//allows shots after limit is passed
	
	static char fire;    //Control
	private int K = 2;
	int type; 			//Changes type of spaceship shape
	public static int ammo; 
	static float speed = 300;
	public static int score;
	
	Spaceship(Game p, char n, char s, char w, char e,  float x, float y, float theta, float size, char fire, int type)
	{
		parent = p;
	    pos = new PVector(x, y);  		//position
	    forward = new PVector(0, -1);	//vectors
	    acc = new PVector(0,0);
	    v = new PVector(0,0);
	    f = new PVector(0, 0);
	    this.theta = theta;
	    this.size = size;
	    radius = size / 2;
	    this.type = type;
	    
	    this.w = w;	//controls
	    this.e = e;
	    this.n = n;
	    this.s = s;
	    this.fire = fire;
	    Spaceship.ammo = 10;
	    Spaceship.score = 0;
	    start();		//calls to start()
		
	}
	
	//Creates shape. Different shape created depending on type passed
	void start()
	{
		if(type == 0)
		{
			parent.pushStyle();
		    shape = parent.createShape();
		    shape.beginShape();
		    shape.stroke(255);
		    shape.fill(0);
		    shape.strokeWeight(2);
		    shape.vertex(0*K, -10*K);
		    shape.vertex(10*K, 0*K);
		    shape.vertex(13*K, 0*K);
		    shape.vertex(15*K, 18*K);
		    shape.vertex(10*K, 10*K);
		    shape.vertex(5*K, 10*K);
		    shape.vertex(5*K, 15*K);
		    shape.vertex(-5*K, 15*K); 
		    shape.vertex(-5*K, 10*K); 
		    shape.vertex(-10*K, 10*K);
		    shape.vertex(-15*K, 18*K); 
		    shape.vertex(-13*K, 0*K); 
		    shape.vertex(-10*K, 0*K);
		    shape.vertex(0*K, -10*K);
		    shape.endShape(PConstants.CLOSE);
		    parent.popStyle();
		}
		
		if(type == 1)
		{
			parent.pushStyle();
			shape = parent.createShape();
		    shape.beginShape();
		    shape.stroke(255, 0, 0);
		    shape.noFill();
		    shape.strokeWeight(6);
		    shape.vertex(0*K, -10*K);
		    shape.vertex(10*K, 0*K);
		    shape.vertex(13*K, 0*K);
		    shape.vertex(15*K, 18*K);
		    shape.vertex(10*K, 10*K);
		    shape.vertex(5*K, 10*K);
		    shape.vertex(5*K, 15*K);
		    shape.vertex(-5*K, 15*K); 
		    shape.vertex(-5*K, 10*K); 
		    shape.vertex(-10*K, 10*K);
		    shape.vertex(-15*K, 18*K); 
		    shape.vertex(-13*K, 0*K); 
		    shape.vertex(-10*K, 0*K);
		    shape.vertex(0*K, -10*K);
		    shape.endShape(PConstants.CLOSE);
		    parent.popStyle();
		}
		
	}
	
	//Renders spaceship
	void render()
	{
		parent.pushMatrix();
	    parent.translate(pos.x, pos.y);
	    parent.rotate(theta);    
	    parent.shape(shape, 0, 0);
	    parent.popMatrix(); 
	}
	
	//Update position, rotation etc. of spaceship
	void update()
	{
		forward.x = PApplet.sin(theta);
	    forward.y  = -PApplet.cos(theta);
	    
	    //Controls
	    if (Game.checkKey(n))
	    {
	      f.add(PVector.mult(forward, speed));      
	    }
	    
	    if (Game.checkKey(s))
	    {
	      f.add(PVector.mult(forward, -speed));      
	    }
	    
	    if (Game.checkKey(w))  
	    {
	      theta -= 0.1f;
	    }
	    
	    if (Game.checkKey(e))
	    {
	      theta += 0.1f;
	    }
	    
	    //Stops the spaceship disappearing from the screen, infinite window
	    if(this.pos.y < -30)
	    {
	    	this.pos.y = parent.height + 15;
	    }
	    
	    if(this.pos.y > parent.height + 30)
	    {
	    	this.pos.y = -30;
	    }
	    
	    if(this.pos.x < -30)
	    {
	    	this.pos.x = parent.width + 15;
	    }
	    
	    if(this.pos.x > parent.width + 30)
	    {
	    	this.pos.x = 0 - 30;
	    }
	    
	    //Creates a rocket flame effect when ship moves forward
	    if(Game.checkKey(n) && type == 1)
	    {
	    	parent.pushMatrix();
	    	parent.translate(this.pos.x, this.pos.y);
	    	parent.rotate(theta);
	    	parent.pushStyle();
	    	parent.stroke(255, 106, 0);
	    	parent.fill(255, 106, 0);
	    	flame = parent.createShape();
	    	flame.beginShape();
	    	flame.vertex(0, 0);
		    flame.vertex(6, 18);
		    flame.vertex(12, 0);
		    flame.endShape(PConstants.CLOSE);
		    parent.shape(flame, -6, 35);
	    	parent.popStyle();
	    	parent.popMatrix();
	    }
	    
	    //Firing shots, checks to see if all conditions are met
	    if (Game.mode == 1 && Game.checkKey(fire) && type == 0 && limitPass > limit && ammo > 0)
	    {
	    	PVector bp = PVector.add(pos, PVector.mult(forward, 40));
	    	Shot s = new Shot((Game) parent, bp.x, bp.y, theta, 20, 5, 0); 	//new shot created
	    	Game.gameObjects.add(s);
	    	limitPass = 0;
	    	ammo--;  	//decreases ammo stock
	    }
	    
	    //defining vectors 
	    acc = PVector.div(f, wgt);
	    v.add(PVector.mult(acc, Game.timeDelta));
	    pos.add(PVector.mult(v, Game.timeDelta));
	    f.x = f.y = 0;
	    v.mult(0.99f);
	    limitPass += Game.timeDelta;
		
	    //Controlling collisions between different objects
	    for(int i = 0 ; i < Game.gameObjects.size() ; i ++)
	    {
	        GameObject go = Game.gameObjects.get(i);
	        
	        //Green blocks
	        if (go instanceof SpecialObj)
	        {
	          SpecialObj p = (SpecialObj) go; // p is of type so the only method we can call on p is applyTo
	          if (Game.dist(go.pos.x, go.pos.y, this.pos.x, this.pos.y) < radius + 30)
	          {
	            p.applyTo(this);
	            Game.gameObjects.remove(go);
	          }
	        }
	        
	        //Red enemies
	        if (go instanceof NegativeObj)
	        {
	          NegativeObj p = (NegativeObj) go;
	          if (Game.dist(go.pos.x, go.pos.y, this.pos.x, this.pos.y) < radius + 30)
	          {
	            p.applyTo(this);
	            Game.gameObjects.remove(go);
	          }
	        }
	        
	        //Shot collision
	        if (go instanceof Hit)
	        {
	          Hit h = (Hit) go;
	          if (Game.dist(go.pos.x, go.pos.y, this.pos.x, this.pos.y) < radius)
	          {
	            h.applyTo(this);
	            Game.gameObjects.remove(go);
	          }
	        }
	    }
	}
	
}