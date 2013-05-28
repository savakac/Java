package sk.gmakers.java.entitis;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import sk.gmakers.java.RenderLayer;
import sk.gmakers.java.Vector;

public class Enemy extends Entity {
	
	private Vector directionVector;

	public Enemy(RenderLayer l) {
		super(l);
		
//		Generuje farbu nepriatela		
		Random rnd = new Random();
		switch (rnd.nextInt(5)) {
		case 0:
			this.color = Color.CYAN;
			break;
		case 1:
			this.color = Color.ORANGE;
			break;
		case 2:
			this.color = Color.RED;
			break;
		case 3:
			this.color = Color.PINK;
			break;
		case 4:
			this.color = Color.MAGENTA;
			break;
		}
		
// 		Nadstavuje smer a rychlost pohybu
		this.directionVector = new Vector(rnd.nextInt(5), rnd.nextInt(5));
		
// 		Pociatocna pozicia nepriatelov
		this.xPosition = rnd.nextInt(750);
		this.yPosition = rnd.nextInt(550);
		
//		Velkost nepriatelov
		this.width = 50;
		this.height = 50;
	}

	
//	Metoda update sluzi na pohyb nepriatela
	@Override
	public void update() {
// 		Generuje pohyb nepriatelov
		this.xPosition += this.directionVector.getX();
		this.yPosition += this.directionVector.getY();
		
//		Nadstavuje hranice v smere osy x lava hranica a prava hranica
		if (this.xPosition + this.width > 800) {
			this.xPosition = 800 - this.width;
			this.directionVector.changeDirection(Vector.X_DIRECTION);
		}
		else if (this.xPosition < 0) {
			this.xPosition = 0;
			this.directionVector.changeDirection(Vector.X_DIRECTION);
		}
		
// 		Nadstavuje hranice v smere osy y dolna hranica a horna hranica
		if (this.yPosition + this.height > 600) {
			this.yPosition = 600 - this.height;
			this.directionVector.changeDirection(Vector.Y_DIRECTION);
		}
		else if (this.yPosition < 0) {
			this.yPosition = 0;
			this.directionVector.changeDirection(Vector.Y_DIRECTION);
		}
	}

//	Vykresluje nepriatela
	@Override
	public void render(Graphics g) {
		g.setColor(this.color);
		g.fillRect(this.xPosition, this.yPosition, this.width, this.height);
	}

}
