package shoot.server;

import jeda00.db.Migrations;
import shoot.server.net.Server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Migrations migrations = new Migrations(Database.getConnection());
        migrations.runMigrations();

        Server server = null;
        try {
            server = new Server(8080);
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.start();
    }
}
