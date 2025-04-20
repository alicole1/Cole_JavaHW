import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiServer {
    public static ArrayList<ClientHandler> handlers = new ArrayList<ClientHandler>();

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

        try (ServerSocket serverSocket = new ServerSocket(port);) {
            System.out.println("Multi echo server listening on port " + port);
            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept(); // Accept incoming client connection
                    System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
                    // Create a new thread to handle the client
                    ClientHandler clientHandler = new ClientHandler(clientSocket);
                    new Thread(clientHandler).start();
                    handlers.add(clientHandler);
                } catch (IOException e) {
                    System.err.println("Error accepting client connection: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + port + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }

    public static void broadcast(String message) {
        for (int i = 0; i < handlers.size(); i++) {
            handlers.get(i).sendMessage(handlers.get(i).getUsername(), message);
        }
    }

}

class ClientHandler implements Runnable {
    private Socket clientSocket;
    private String username;
    private PrintWriter out;

    public String getUsername() {
        return username;
    }

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void sendMessage(String username, String message) {
        System.out.println(username + ": " + message);
    }

    @Override
    public void run() {
        // use try with catch statement to create output and input streams.
        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
            System.out.println("Connected to client " + clientSocket.getInetAddress().getHostAddress()
                    + " on port " + clientSocket.getPort());
            out.println("Enter your username: ");
            username = in.readLine();
            System.out.println("Client username: " + username);
            MultiServer.broadcast("Welcome " + username + "!");

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                // display info about what was received.
                System.out.printf("Received from client (%s): %s%n",
                        clientSocket.getInetAddress().getHostAddress(), inputLine);
                // echo line back to client.
                MultiServer.broadcast(inputLine);
            }
            System.out.println("Client disconnected: " + clientSocket.getInetAddress());
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        }

        MultiServer.handlers.remove(this);
        System.out.println("Client disconnected: " + username);
        MultiServer.broadcast(username + " has left the chat.");
    }
}
