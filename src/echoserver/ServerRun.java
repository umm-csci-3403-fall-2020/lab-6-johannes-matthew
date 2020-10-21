package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class ServerRun implements Runnable {

	public Socket socket;

	public ServerRun(Socket socket) {
			this.socket = socket;
	}

	public void run() {
		try {

			InputStream input = socket.getInputStream();
			OutputStream output = socket.getOutputStream();

			while (true) {
				output.write(input.read());
			}

		} catch (IOException ioe) {
			System.out.println("We caught an unexpected exception");
			System.err.println(ioe);
		}
	}
}
