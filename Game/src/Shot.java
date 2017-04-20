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
		
	}
	
	void update()
	{
		
	}
	
}