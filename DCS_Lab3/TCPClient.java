import java.net.*;
import java.io.*;

public class TCPClient {
	public static void main(String[] args) throws IOException {
		BufferedReader configReader = new BufferedReader(new FileReader("config.txt"));
		String line = configReader.readLine();
		configReader.close();

		String[] parts = line.split(" ");
		String serverIP = parts[0];
		int serverPort = Integer.parseInt(parts[1]);

		InetAddress addr = InetAddress.getByName(serverIP);
		System.out.println("Connecting to server at: " + addr + " on port " + serverPort);

		Socket mysocket = new Socket(addr, serverPort);
		try {
			System.out.println("Socket : " + mysocket);
			BufferedReader in = new BufferedReader(new InputStreamReader(mysocket.getInputStream()));
			PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(mysocket.getOutputStream())), true);

			for (int i = 0; i < 10; i++) {
				out.println("Hi: " + i);
				String str = in.readLine();
				System.out.println("Server response: " + str);
			}
			out.println("END");
		} finally {
			System.out.println("Closing...");
			mysocket.close();
		}
	}
}