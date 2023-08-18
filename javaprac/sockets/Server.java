import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);
    }

    public void start() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Start a new thread to handle client communication
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ClientHandler extends Thread {
        private Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {
            try (
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())
            ) {
                String className = (String) in.readObject();
                System.out.println("Received class name: " + className);

                // Retrieve table data based on class name from database
                List<String> tableData = retrieveTableDataFromDatabase(className);

                // Send table data as ArrayList to the client
                out.writeObject(new ArrayList<>(tableData));

                System.out.println("Data sent to client");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private List<String> retrieveTableDataFromDatabase(String className) {
        // Database logic to retrieve table data based on class name
        // This is just a sample implementation, replace it with your own database access code
        List<String> tableData = new ArrayList<>();

        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

            // Create and execute SQL query
            String query = "SELECT * FROM " + className;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Process result set
            while (rs.next()) {
                String rowData = rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3);
                tableData.add(rowData);
            }

            // Close database resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tableData;
    }

    public static void main(String[] args) {
        int port = 12345; // Specify the port number you want to use
        try {
            Server server = new Server(port);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
