package com.chatapp.client.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSystem {

	String hostName = "localhost";
	private boolean connected;
	Socket clientSocket = null;
	PrintWriter out = null;
	BufferedReader in = null;
	String name = System.getProperty("nick");

	public void connect() throws IOException {
		try {
			clientSocket = new Socket(hostName, 4444);
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: " + hostName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for " + "the connection to: "
					+ hostName);
			System.exit(1);
		}
		connected = true;
	}

	public void disconnect() {
		try {
			out.println("END");
			out.close();
			in.close();
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendMessage(String message) {
		out.println(message);
	}

	public String printMessage() throws IOException {
		return name + ": " + in.readLine();
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

}
