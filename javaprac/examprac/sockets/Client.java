import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private String serverAddress;
    private int serverPort;

    public Client(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public void start() {
        try (
            Socket socket = new Socket(serverAddress, serverPort);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream())
        ) {
            String className = "YourClassName"; // Specify the class name you want to retrieve data for
            out.writeObject(className);

            // Receive the ArrayList of table data from the server
            List<String> tableData = (ArrayList<String>) in.readObject();

            // Process and display the received table data
            for (String rowData : tableData) {
                System.out.println(rowData);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String serverAddress = "localhost"; // Specify the server IP address
        int serverPort = 12345; // Specify the server port number

        Client client = new Client(serverAddress, serverPort);
        client.start();
    }
}
