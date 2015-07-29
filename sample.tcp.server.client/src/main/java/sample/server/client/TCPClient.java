package sample.server.client;

import java.io.*;
import java.net.*;

/**
 * TCP client program
 * 
 * @author malalanayake
 *
 */
public class TCPClient {

	public static void main(String[] args) throws IOException {
		// Input data from user
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		// Open socket
		Socket clientSocket = new Socket("localhost", 5000);
		// Data writer
		DataOutputStream writer = new DataOutputStream(clientSocket.getOutputStream());
		// Data reader from server
		BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String sent = input.readLine();
		writer.writeBytes(sent + '\n');
		String received = reader.readLine();
		System.out.println(received);
		clientSocket.close();
	}

}
