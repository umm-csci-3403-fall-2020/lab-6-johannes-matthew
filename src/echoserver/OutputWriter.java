package echoserver;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class OutputWriter implements Runnable {
    InputStream fromSocket;
    Socket socket;

    public OutputWriter(Socket socket) {
        try {
           this.socket = socket;
           fromSocket  = socket.getInputStream();
        } catch (IOException e) {
            System.out.println("Problems creating a stream to read input");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

    // Read until the end of file or stream
   
    try {
        int dataFromOutput;
        while ((dataFromOutput = fromSocket.read()) != -1) {
            System.out.write(dataFromOutput); // Write data from the input stream to system out 
            }
        } catch (IOException e1) {
        System.out.println("Cannot read from socket");
        e1.printStackTrace();
        }

        System.out.flush(); // Flush system out   

        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("Unable to close socket");
            e.printStackTrace();
        }
    }
    
}

