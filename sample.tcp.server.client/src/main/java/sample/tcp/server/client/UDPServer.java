package sample.tcp.server.client;

import java.io.*;
import java.net.*;

/**
 * UDP Server simulation
 * 
 * @author malalanayake
 *
 */
public class UDPServer {
	public static void main(String args[]) throws Exception {
		// Open socket loclahost:6000
		DatagramSocket serverSocket = new DatagramSocket(6000, InetAddress.getByName("localhost"));
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		
		//Hanging on 
		while (true) {
			DatagramPacket readPacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(readPacket);
			String readData = new String(readPacket.getData());
			System.out.println("UDP Server, " + readData);
			InetAddress ip = readPacket.getAddress();
			int port = readPacket.getPort();
			String output = "Hello, " + readData;
			sendData = output.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, port);
			serverSocket.send(sendPacket);
		}
	}

}
