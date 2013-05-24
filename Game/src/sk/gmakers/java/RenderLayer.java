package sk.gmakers.java;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import sk.gmakers.java.entities.Enemy;
import sk.gmakers.java.entities.Entity;
import sk.gmakers.java.entities.Player;

public class RenderLayer extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	
	private boolean isRunning;
	
	private ArrayList<Entity> entities;
	private Player p1;
	private boolean isGameOver;
	private float score;
	
	public RenderLayer() {
		super();
		
		this.isRunning = false;
		this.isGameOver = false;
		this.score = 0;
		this.setSize(new Dimension(800, 600));
		
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
				e.printStackTrace();
			}
			
			FPS++;
			render();
			
			if (System.currentTimeMillis() - lastTimeOutput > 1000) {
				lastTimeOutput += 1000;
				score += 0.5;
				System.out.println("Ticks: " + ticks + ", FPS: " + FPS);
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
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		for (Entity e : this.entities) {
			e.render(g);
		}
		
		this.p1.render(g);
		
		if (this.isGameOver) {
			g.drawString("Game over", 300, 200);
		}
		
		g.dispose();
		buffer.show();
	}

	private void update() {
		if (!this.isGameOver) {
			for (Entity e : this.entities) {
				e.update();
			}
			p1.update();
		}
		
		int enemyCount = this.entities.size();
		int additionalEnemies = (int) (this.score * 10 / 75);
		if (additionalEnemies + 5 - enemyCount == 1) {
			this.entities.add(new Enemy(this));
		}
	}
	
	public void start() {
		isRunning = true;
		Thread t = new Thread(this);
		t.start();
	}
	
	public void stop() {
		isRunning = false;
	}
	
	public ArrayList<Entity> getEntities() {
		return this.entities;
	}
	
	public void gameOver() {
		this.isGameOver = true;
		this.removeMouseMotionListener(this.p1);
	}

}
