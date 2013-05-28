package sk.gmakers.java;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Java extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private static String TITLE = "Java GUI";
	
	public static void main(String[] args) {
		Java java = new Java();
		
		java.init();
	}

	private void init() {
		RenderLayer layer = new RenderLayer();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(layer, BorderLayout.CENTER);
		this.pack();
		this.setTitle(Java.TITLE);
		this.setResizable(false);
		this.setVisible(true);
		
		layer.start();
		
	}

}
