package sample.server.client;

import java.io.*;
import java.net.*;

/**
 * UDP Client program
 * 
 * @author malalanayake
 *
 */
public class UDPClient {

	public static void main(String[] args) throws Exception {
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress ipAddress = InetAddress.getByName("localhost");
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];

		// Read data from user
		String sentence = userInput.readLine();
		sendData = sentence.getBytes();
		// Send read data
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, 6000);
		clientSocket.send(sendPacket);

		// Receive data
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);
		
		String receivedString = new String(receivePacket.getData());
		System.out.println(receivedString);
		clientSocket.close();
	}

}