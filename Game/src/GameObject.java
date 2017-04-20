import processing.core.PVector;

abstract class GameObject 
{
	PVector pos;
	PVector forward;
	float size;
	  
	GameObject()
	{
	    
	}
	  
	abstract void update();  
	abstract void render();
}
