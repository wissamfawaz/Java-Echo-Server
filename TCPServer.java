import java.io.*;
import java.net.*;

public class TCPServer {

	public static void main(String[] args) throws IOException {
		ServerSocket welcomeSocket = new ServerSocket(6789);
		while(true) {
			// Wait for connection request
			System.out.println("Waiting for request...");
			Socket connectionSocket=welcomeSocket.accept();
			System.out.println("Connection received from: " +
				connectionSocket.getInetAddress());

			ClientHandler ch = 
			new ClientHandler(connectionSocket);

			(new Thread(ch)).start();

		}

	}
}