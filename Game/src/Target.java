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

	@Override
	public void applyTo(Spaceship p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyTo(Shot p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void render() {
		// TODO Auto-generated method stub
		
	}
}
