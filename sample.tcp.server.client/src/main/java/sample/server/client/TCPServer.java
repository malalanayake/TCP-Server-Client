package sample.server.client;

import java.io.*;
import java.net.*;

/**
 * TCP server simulation
 * 
 * @author malalanayake
 *
 */
public class TCPServer {
	public static void main(String[] args) throws IOException {
		// Open socket localhost:5000
		ServerSocket serverSocket = new ServerSocket(5000, 0, InetAddress.getByName("localhost"));

		// Hanging on
		while (true) {
			Socket socket = serverSocket.accept();
			// Reader for input stream
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// Out stream for client
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			String received = reader.readLine();

			// Log in server side
			System.out.println("TCP Server, " + received);

			// Send message back to client
			out.writeBytes("Hello, " + received + "\n");
		}
	}

}