package echoserver;

import java.io.IOException;
import java.net.Socket;

public class EchoClient {
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) throws IOException {
		EchoClient client = new EchoClient();
		client.start();
	}

	private void start() throws IOException {
		Socket socket = new Socket("localhost", PORT_NUMBER);

		Runnable input = new InputReader(socket);
		new Thread(input).start();

		Runnable output = new OutputWriter(socket);
		new Thread(output).start();
	}
}