package sk.gmakers.java;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class JavaGame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public static String GAME_TITLE = "Java Games";

	public static void main(String[] args) {
		JavaGame  game = new JavaGame();
		
		game.init();
	}
	
	public void init() {
		RenderLayer layer = new RenderLayer();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(layer, BorderLayout.CENTER);
		this.pack();
		this.setTitle(JavaGame.GAME_TITLE);
		this.setResizable(false);
		this.setVisible(true);
		
		layer.start();
	}
}
