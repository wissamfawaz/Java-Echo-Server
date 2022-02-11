import java.net.*;
import java.io.*;

public class ClientHandler implements Runnable {
	private static int taskNumber = 0;
	private int id = ++taskNumber;
	private Socket connectionSocket;

	public ClientHandler(Socket socket) {
		connectionSocket = socket;
	}
	

	public void run() {

		try {
			String line, capitilizedLine;
			// Get I/O streams
			BufferedReader inFromClient = 
				new BufferedReader(
				new InputStreamReader(
				connectionSocket.getInputStream()));
			DataOutputStream outToClient = 
				new DataOutputStream(
				connectionSocket.getOutputStream());

			System.out.println("Got I/O streams");

			// Process connection
			line = inFromClient.readLine();
			System.out.println(
				"Line received from user#" + id + ":" + 
				line);
			capitilizedLine = line.toUpperCase() + "\n";
			outToClient.writeBytes(capitilizedLine);
			System.out.println("Line sent back to client#"+id);
			

			// Close connection 
			inFromClient.close();
			outToClient.close();
			connectionSocket.close();
		} catch(Exception e) {


		}
	}

}