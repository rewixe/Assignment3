import processing.core.PApplet;
import processing.core.PConstants;
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
	    start();
		
	}
	
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
	
	void render()
	{
		parent.pushMatrix();
	    parent.translate(pos.x, pos.y);
	    parent.rotate(theta);    
	    parent.shape(shape, 0, 0);
	    parent.popMatrix(); 
	}
	
	void update()
	{
		
	}
	
}