package sk.gmakers.java;

import java.util.Random;

public class Vector {

	private int x;
	private int y;
	
	public static int X_DIRECTION = 1;
	public static int Y_DIRECTION = 2;
	
	public Vector(int x, int y) {
		this.x = x == 0 ? ++x : x;
		this.y = y == 0 ? ++y : y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getLength() {
		return (int) Math.sqrt(this.x * this.x + this.y * this.y);
	}
	
	public void chageDirection(int direction) {
		if (direction == Vector.X_DIRECTION) {
			this.x = -this.x;
		}
		else if (direction == Vector.Y_DIRECTION) {
			this.y = -this.y;
		}
	}
	
	public void newDirection(int direction) {
		Random rnd = new Random();
		if (direction == Vector.X_DIRECTION) {
			int newX = rnd.nextInt(5);
			this.x = this.x < 0 ? -newX : newX;
		}
		else if (direction == Vector.Y_DIRECTION) {
			int newY = rnd.nextInt(5);
			this.y = this.y < 0 ? -newY : newY;
		}
	}
}
