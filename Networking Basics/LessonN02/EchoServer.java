
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        // parse input arguments for port.
        int port = 8675;
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Couldn't understand port. Using default instead.");
            }
        }

        System.out.printf("port: %d%n", port);

        // let's use a try-with resources statement to create sockets.
        try (ServerSocket serverSocket = new ServerSocket(port);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
            String inputLine;

            // echo stuff from the client.
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Message received " + inputLine);
                out.println(inputLine);
            }

            // we're done.
            System.out.println("we're done!");

        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}
