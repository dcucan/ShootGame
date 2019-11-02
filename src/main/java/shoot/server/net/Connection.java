package shoot.server.net;

import shoot.server.models.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Map;
import java.util.UUID;

public class Connection extends Thread {

    private Socket socket;

    private BufferedReader bufferedReader;

    private PrintStream printStream;

    private String id;

    private Map<String, Connection> connections;

    Connection(Socket socket, Map<String, Connection> connections) throws IOException {
        this.socket = socket;
        this.connections = connections;
        id = UUID.randomUUID().toString();

        connections.put(id, this);


        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printStream = new PrintStream(socket.getOutputStream(), true);
    }


    @Override
    public void run() {
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {

                    connections.remove(id);
                    return;
                }

                for (Connection connection : connections.values()) {
                    if (!connection.id.equals(id)) {
                        connection.printStream.println(line);
                    }
                }



                System.out.println(line);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
