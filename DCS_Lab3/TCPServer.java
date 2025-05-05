import java.io.*;
import java.net.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class TCPServer {
	public static void main(String[] args) throws IOException {
		if (args.length < 1) {
			System.out.println("Usage: java TCPServer <port>");
			return;
		}

		int port = Integer.parseInt(args[0]);
		ServerSocket s = new ServerSocket(port);
		System.out.println("Server started at IP: " + InetAddress.getLocalHost().getHostAddress() + " Port: " + port);

		try {
			Socket mysocket = s.accept();
			try {
				System.out.println("Connection accepted: " + mysocket);
				BufferedReader in = new BufferedReader(new InputStreamReader(mysocket.getInputStream()));
				PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(mysocket.getOutputStream())), true);

				while (true) {
					String str = in.readLine();
					if (str == null) break;
					System.out.println("Received: " + str);

					if (str.startsWith("STATS ")) {
						String text = str.substring(6); // after "STATS "
						String result = getStats(text);
						out.println(result);
					} else if (str.startsWith("ANAGRAM ")) {
						String text = str.substring(8); // after "ANAGRAM "
						String result = getAnagram(text);
						out.println(result);
					} else if (str.equals("DROP")) {
						out.println("Goodbye!");
						break; // close connection
					} else {
						out.println("ERROR: Unknown command");
					}
				}
			} finally {
				System.out.println("Closing client socket...");
				mysocket.close();
			}
		} finally {
			System.out.println("Closing server socket...");
			s.close();
		}
	}

	private static String getStats(String text) {
		int lower = 0, upper = 0, digits = 0, others = 0;
		for (char c : text.toCharArray()) {
			if (Character.isLowerCase(c)) lower++;
			else if (Character.isUpperCase(c)) upper++;
			else if (Character.isDigit(c)) digits++;
			else others++;
		}
		return "Lowercase: " + lower + ", Uppercase: " + upper + ", Digits: " + digits + ", Others: " + others;
	}

	private static String getAnagram(String text) {
		List<Character> chars = new ArrayList<>();
		for (char c : text.toCharArray()) {
			chars.add(c);
		}
		Collections.shuffle(chars);
		StringBuilder shuffled = new StringBuilder();
		for (char c : chars) {
			shuffled.append(c);
		}
		return shuffled.toString();
	}
}