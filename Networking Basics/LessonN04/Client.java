import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println(
                    "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = 0;
        try {
            portNumber = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Unable to parse the port number!");
            System.err.println("Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }
        try (
                Socket echoSocket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(echoSocket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(
                        new InputStreamReader(System.in))) {
            // --- WELCOME ---
            // Send server connection message, collect username.
            System.out.println("Connected to server " + hostName + " on port " + portNumber);
            System.out.print(in.readLine()); // What is your username?
            out.println(stdIn.readLine());
            System.out.println(in.readLine()); // __ has joined the chat.

            Thread serverListener = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {

                }
            });
            // serverListener.setDaemon(true);
            serverListener.start();

            // MAIN LOOP
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                // System.out.println(in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        }

    }
}
