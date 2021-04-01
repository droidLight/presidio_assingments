package day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMultiThread {
	ServerSocket serverSocket;
	Socket socket;
	ExecutorService es;
	List<Socket> clientList;

	public ServerMultiThread() throws Exception {
		es = Executors.newFixedThreadPool(2);
		clientList = new ArrayList<>();
		serverSocket = new ServerSocket(2000);
		System.out.println("Server ready.....");

		while (true) {
			socket = serverSocket.accept();
			this.addNewClient(socket);
			System.out.println("accepted new client");
		}
	}

	private void addNewClient(Socket socket) {
		ExecutorService es = Executors.newFixedThreadPool(1);
		//this.clientList.add(socket);

		// thread for sending data
		es.execute(() -> {
			PrintWriter out;
			BufferedReader keyboardInput, in;
			
			try {
				out = new PrintWriter(socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));				
				keyboardInput = new BufferedReader(new InputStreamReader(System.in));	
				
				while (true) {					
					System.out.println("Enter message for clients: ");
					String str = keyboardInput.readLine();
					out.write(str);
					
					String msg;
					while((msg = in.readLine()) != null) {
						System.out.println("From client ("+socket+": "+msg);
					}
				}
			} catch (Exception e) {
			}
		});

		
	}

	public static void main(String[] args) throws Exception {
		new ServerMultiThread();
	}
}