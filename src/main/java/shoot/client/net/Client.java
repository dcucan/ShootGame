package shoot.client.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client extends Thread {


    Socket socket;

    private BufferedReader bufferedReader;

    private PrintStream printStream;

    private ConsoleReader consoleReader;

    public Client(String address, int port) throws IOException {
        socket = new Socket(address, port);

        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printStream = new PrintStream(socket.getOutputStream(), true);
        consoleReader = new ConsoleReader(socket);
        consoleReader.start();
    }

    @Override
    public void run(){
        while (true){
            try {
                String line = bufferedReader.readLine();
                System.out.println(line);
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }




}
