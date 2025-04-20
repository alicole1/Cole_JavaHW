import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiServer {
    static ArrayList<ClientHandler> handlers = new ArrayList<>();

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
            System.out.println("Server is listening on port " + port);
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

    public static void broadcast(String message, boolean toServer) {
        for (int i = 0; i < handlers.size(); i++) {
            // send message to each client to print.
            handlers.get(i).sendMessage(message);
        }
        if (toServer == true) {
            System.out.println(message);
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    String username;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        // use try with catch statement to create output and input streams.
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Connected to client " + clientSocket.getInetAddress().getHostAddress()
                    + " on port " + clientSocket.getPort());
            out.println("What is your username? ");
            username = in.readLine();
            System.out.printf("Client %s is using the name \"%s\" %n", clientSocket.getInetAddress().getHostAddress(),
                    username);
            MultiServer.broadcast(username + " has joined the chat server!", false);
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                MultiServer.broadcast(username + ": " + inputLine, true);

            }
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        }

        MultiServer.handlers.remove(this);
        MultiServer.broadcast(username + " has left the chat.", false);
        System.out.printf("Client disconnected: %s (%s)%n", clientSocket.getInetAddress().getHostAddress(), username);
    }

    public void sendMessage(String message) {
        out.println(message);
    }

}
