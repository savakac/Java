package sk.gmakers.socet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private Socket clientSocket;
	
	public static void main(String[] args) {
		Client client = new Client();
	}
	
	public Client() {
		try {
			this.clientSocket = new Socket("localhost", 25565);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(this.clientSocket.getOutputStream()));
			int counter = 1;
			
			while (true) {
				String temp = "Toto je " + counter + " sprava.";
				System.out.println(temp);
				out.write(temp + "\n");
				out.flush();
				counter++;
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
