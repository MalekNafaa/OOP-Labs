package Population;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PopulationServer {
    private static final int PORT = 12345; // Port number for the server

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Client connected: " + socket.getInetAddress());

                    // Send the contents of the populations.csv file
                    sendPopulationData(socket);
                }
            }
        } catch (IOException e) {
            System.err.println("Error in server: " + e.getMessage());
        }
    }

    private static void sendPopulationData(Socket socket) {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Malek\\IdeaProjects\\****"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                out.println(line); // Send each line to the client
            }
        } catch (IOException e) {
            System.err.println("Error sending data: " + e.getMessage());
        }
    }
}