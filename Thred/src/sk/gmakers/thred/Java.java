package sk.gmakers.thred;

import java.io.IOException;

public class Java {
	
	public static void main(String[] args) {
		Java java = new Java();
 }

	// Construct class
	public Java() {
		this.listen();
	}
	
	public void listen() {
		// A thread
		Thread aThread = new Thread(new Runnable() {
			public void run() {
				int i = 0;
				while (i < 10) {
					System.out.println("Toto je vystup z A vlakna.");
					i++;
				}
			}
		});
		
		aThread.start();
		
		// Main thread print text
		while (true) {
			System.out.println("Toto je vystup z hlavneho vlakna.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
