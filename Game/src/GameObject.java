import processing.core.PVector;

//Game object abstract class 
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
