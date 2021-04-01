package day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
	Socket socket;
	BufferedReader in, keyboard;
	PrintWriter out;

	public Client() throws Exception {

		socket = new Socket("localhost", 2000);

		ExecutorService es = Executors.newFixedThreadPool(2);

		// receiving message from server
		es.execute(() -> {
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String msg;
				while ((msg = in.readLine()) != null) {										
					System.out.println("Message from server...:" + msg);
				}
			} catch (Exception e) {
			}

		});

		// sending message to server
		es.execute(() -> {
			try {
				out = new PrintWriter(socket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(System.in));
				while (true) {					
					System.out.println("Type a message to server..:");
					String msgToServer = in.readLine();
					out.println(msgToServer);
				}
			} catch (Exception e) {
			}
		});

	}

	public static void main(String[] args) throws Exception {
		new Client();
	}
}