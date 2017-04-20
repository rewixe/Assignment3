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
	
	void start()
	{
		
	}
}
