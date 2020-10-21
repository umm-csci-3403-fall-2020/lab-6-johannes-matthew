package echoserver;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class InputReader implements Runnable {

    OutputStream toSocket;
    public Socket socket;

    public InputReader(Socket socket) {
        try {
           this.socket = socket;
           toSocket  = socket.getOutputStream();
        } catch (IOException e) {
            System.out.println("Problems creating a stream to read input");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
    /* Create variable to store data from the System.in stream
    An int is used because we need additional space to represent the end of the stream
    The convention to use an int rather than a short is established by System.in */
    int dataFromInput;

    // Read until the end of file or stream
    try {
        while ((dataFromInput = System.in.read()) != -1) {
            try {
                toSocket.write(dataFromInput);
                //System.out.println("Sent this: " + dataFromInput);
            } catch (IOException e) {
                System.out.println("Cannot write to socket");
                e.printStackTrace();
            }  
            try {
                toSocket.flush(); // Flush stream
            } catch (IOException e) {
                System.out.println("Cannot flush stream");
                e.printStackTrace();
            }
        
        }
    } catch (IOException e1) {
        System.out.println("Cannot read System In");
        e1.printStackTrace();
    }
    

    }
    
}
