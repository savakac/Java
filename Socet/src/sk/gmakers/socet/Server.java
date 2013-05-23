package sk.gmakers.socet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	private ServerSocket serverSocket;
	private ArrayList<BufferedReader> clientReaders;
	
	public static void main(String[] args) {
		Server server = new Server();
	}
	
	public Server() {
		try {
			this.serverSocket = new ServerSocket(25565);
			this.clientReaders = new ArrayList<BufferedReader>();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void listen() {
		// Accept thred
		Thread acceptThred = new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Socket client = serverSocket.accept();
						clientReaders.add(new BufferedReader(new InputStreamReader(client.getInputStream())));
						System.out.println("Klient sa pripojil.");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		acceptThred.start();
		
		// Main thred for text print
		while (true) {
			ArrayList<BufferedReader> tempClients = new ArrayList<BufferedReader>(this.clientReaders);
			for (BufferedReader in : tempClients) {
				try {
					System.out.println(in.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
		}
	}

}
