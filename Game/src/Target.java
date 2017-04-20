import processing.core.PApplet;
import processing.core.PShape;
import processing.core.PVector;

public class Target extends GameObject implements SpecialObj
{
	public static Target applet;
	
	PApplet parent;
	
	float theta;
	PShape test;
	
	Target(Game p)
	{
		parent = p;
		theta = 0;
		forward = new PVector(parent.random(-1,1), parent.random(-1,1));
		start();
	}
	
	public void applyTo(Spaceship p) 
	{
		Spaceship.ammo ++;	
	}

	public void applyTo(Shot p) 
	{
		if (Shot.type == 0)
		{
			Spaceship.score ++;
		}
	}
	
	void start()
	{
		
	}

	void update() 
	{
		// TODO Auto-generated method stub
		
	}

	void render() 
	{
		// TODO Auto-generated method stub
		
	}
}
