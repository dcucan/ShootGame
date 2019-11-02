package shoot.client.net;

import shoot.common.EventBus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client extends Thread {

    private static Client client;

    Socket socket;


    private BufferedReader bufferedReader;

    private PrintStream printStream;

    private ConsoleReader consoleReader;


    private Client(String address, int port) throws IOException {
        socket = new Socket(address, port);

        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printStream = new PrintStream(socket.getOutputStream(), true);
        consoleReader = new ConsoleReader(socket);
        consoleReader.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                String line = bufferedReader.readLine();
                System.out.println(line);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public PrintStream getPrintStream() {
        return printStream;
    }

    public static Client get() {
        if (client == null) {
            try {
                client = new Client("localhost", 8080);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        } return client;
    }


}
