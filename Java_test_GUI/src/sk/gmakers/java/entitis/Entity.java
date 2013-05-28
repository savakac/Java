package sk.gmakers.java.entitis;

import java.awt.Color;
import java.awt.Graphics;

import sk.gmakers.java.RenderLayer;

// Abstraktna trieda pre dedenie hraca
abstract public class Entity {

	protected int xPosition;
	protected int yPosition;
	protected Color color;
	protected int width;
	protected int height;
	protected RenderLayer map;
	
// Konstruktor triedy
	public Entity(RenderLayer l) {
		this.map = l;
	}
	
	abstract public void update();
	
	abstract public void render(Graphics g);

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int zPosition) {
		this.yPosition = zPosition;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
