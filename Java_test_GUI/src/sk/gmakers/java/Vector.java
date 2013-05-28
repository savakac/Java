package sk.gmakers.java;

import java.util.Random;

public class Vector {
	private int x;
	private int y;
	
	public static final int X_DIRECTION = 1;
	public static final int Y_DIRECTION = 2;
	
	public Vector(int x, int y) {
		this.x = (x == 0 ? ++x : x); // Ak sa x rovna 0 tak zvec x o jedna inak x
		this.y = (y == 0 ? ++y : y); // Ak sa y rovna 0 tak zvec y o jedna inak y
	}
	
	public void changeDirection(int direction) {
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
		else if (direction == Vector.Y_DIRECTION){
			int newY = rnd.nextInt(5);
			this.y = this.y < 0 ? -newY : newY;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
