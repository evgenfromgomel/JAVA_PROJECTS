package com.chatapp.server.main;

import java.io.*;

import java.net.*;

public class RunnerServer {
	// �������� ���� ��� �������� 1-1024:
	public static final int PORT = 4444;

	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(PORT);
		System.out.println("Started: " + s);
		try {
			while (true) {
				// ��������� �� ��� ���, ���� �� ��������� ����������:
				Socket socket = s.accept();
				try {
					System.out.println("Connection accepted: " + socket);
					BufferedReader in = new BufferedReader(
							new InputStreamReader(socket.getInputStream()));
					// ����� ������������� ������������� �� ������
					// PrintWriter'��
					PrintWriter out = new PrintWriter(new BufferedWriter(
							new OutputStreamWriter(socket.getOutputStream())),
							true);
					while (true) {
						String str = in.readLine();
						if (str.equals("END"))
							break;
						System.out.println("Echoing: " + str);
						out.println(str + " by server");
					}
					// ������ ��������� ��� ������...
				} finally {
					System.out.println("closing...");
					socket.close();
				}
			}
		} finally {
			s.close();
		}
	}
}