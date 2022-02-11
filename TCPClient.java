import java.io.*;
import java.net.*;

public class TCPClient {

	public static void main(String[] args) throws IOException {
		String line, capitilizedLine;

		// Connect to server
		Socket clientSocket = new Socket("localhost", 6789);
		System.out.println("Connected to: " + 
			clientSocket.getInetAddress());		

		// Get I/O streams

		BufferedReader inFromUser = 
			new BufferedReader(
			(new InputStreamReader(System.in)));
		BufferedReader inFromServer = 
			new BufferedReader(
			new InputStreamReader(
			clientSocket.getInputStream()));
		DataOutputStream outToServer = 
			new DataOutputStream(clientSocket.getOutputStream());

		System.out.println("Got I/O streams");

		// Process the connection

		line = inFromUser.readLine();
		outToServer.writeBytes(line+"\n");
		capitilizedLine = inFromServer.readLine();

		System.out.println("Line received from server: " + 
					capitilizedLine);

		// Terminate the connection
		inFromUser.close();
		inFromServer.close();
		outToServer.close();
		clientSocket.close();

	}
}