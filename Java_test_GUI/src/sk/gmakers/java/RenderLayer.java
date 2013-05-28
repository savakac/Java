package sk.gmakers.java;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import sk.gmakers.java.entitis.Enemy;
import sk.gmakers.java.entitis.Entity;
import sk.gmakers.java.entitis.Player;

public class RenderLayer extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	private boolean isRunning;
	private boolean isGameOver;
	private float score;
	
	private Player pl;
	private ArrayList<Entity> entities; 
	
	public RenderLayer() {
		super();
		
		this.isRunning = false;
		this.isGameOver = false;
		this.score = 0;
		this.setSize(new Dimension(800, 600));
		this.pl = new Player(this);
		this.addMouseMotionListener(this.pl);
		this.entities = new ArrayList<Entity>();
		
		for (int a = 0; a < 5; a++) {
			this.entities.add(new Enemy(this));
		}
	}
	
	@Override
	public void run() {
		long lastTimeCycle = System.nanoTime();
		long lastTimeOutput = System.currentTimeMillis();
		double unprocessidTicks = 0;
		double nsPerTick = Math.pow(10, 9) / 60;
		int FPS = 0;
		int ticks = 0;
		
		while (this.isRunning) {
			long nowTimeCycle = System.nanoTime();
			unprocessidTicks += (nowTimeCycle - lastTimeCycle) / nsPerTick;
			lastTimeCycle = nowTimeCycle;
			
			while (unprocessidTicks >= 1) {
				ticks++;
				update();
				unprocessidTicks -= 1;
			}
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			FPS++;
			render();
			
			if (System.currentTimeMillis() - lastTimeOutput > 1000) {
				lastTimeOutput += 1000;
				System.out.println("Ticks: " + ticks + ", FPS: " + FPS);
				this.score += 0.5;
				FPS = 0;
				ticks = 0;
			}
			
		}
	}

	private void render() {
		BufferStrategy buffer = this.getBufferStrategy();
		if (buffer == null) {
			createBufferStrategy(3);
			this.requestFocus();
			return;
		}
		
		Graphics g = buffer.getDrawGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		for (Entity e : entities) {
			e.render(g);
		}
		
		pl.render(g);
		
		g.setColor(Color.BLUE);
		g.drawString("Your score: " + (int) this.score, 15, 15);
		
		g.dispose();
		buffer.show();
	}

	
	private void update() {
		for (Entity e : entities) {
			e.update();
		}
		pl.update();
	}
	
	public void start() {
		isRunning = true;
		Thread t = new Thread(this);
		t.start();
	}
	
	public void stop() {
		
	}
	
	public void gameOver() {
		
	}

}
