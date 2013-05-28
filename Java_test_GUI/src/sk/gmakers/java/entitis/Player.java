package sk.gmakers.java.entitis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import sk.gmakers.java.RenderLayer;

public class Player extends Entity implements MouseMotionListener {

	public Player(RenderLayer l) {
		super(l);
		this.color = Color.GREEN;
		this.width = this.height = 25;
		this.xPosition = 800 / 2 - this.width / 2;
		this.yPosition = 600 / 2 - this.height / 2;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.xPosition = e.getX() - this.width / 2;
		this.yPosition = e.getY() - this.height / 2;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(this.color);
		g.fillRect(this.xPosition, this.yPosition, this.width, this.height);
	}

}
