package sk.gmakers.java.entities;

import java.awt.Color;
import java.awt.Graphics;

import sk.gmakers.java.RenderLayer;

public abstract class Entity {

	protected int xPosition;
	protected int yPositoin;
	protected int width;
	protected int height;
	protected Color color;
	protected RenderLayer map;
	
	public Entity(RenderLayer l) {
		this.map = l;
	}
	
	abstract public void render(Graphics g);
	abstract public void update();
	
	public int getPositionX() {
		return this.xPosition;
	}
	
	public int getPositionY() {
		return this.yPositoin;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
}
