package com.chatapp.client.system;

import java.io.IOException;

public class ClientLogic {

	private static ClientSystem client = new ClientSystem();

	public static boolean runClient() throws IOException {
		client.connect();
		if (client.isConnected()) {
			return true;
		} else
			return false;
	}

	public static void shutdownClient() {
		client.disconnect();
	}

	public static void sendMessage(String message) {
		client.sendMessage(message);
	}

	public static String printMessage() throws IOException {
		return client.printMessage();
	}
}
