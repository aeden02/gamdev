package entities;

public abstract class Entity {
	protected float x,y; 
	protected int width, heigth; 
	public Entity(float x, float y, int width, int heigth) {
		this.x = x; 
		this.y = y; 
		this.width=width;
		this.heigth= heigth; 
	}
}
