package shoot.server;

import jeda00.db.Migrations;
import shoot.common.EventBus;
import shoot.server.handlers.RegisterUser;
import shoot.server.events.UserRegistration;
import shoot.server.net.Server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Migrations migrations = new Migrations(Database.getConnection());
        migrations.runMigrations();

        EventBus.get().subscribe(UserRegistration.class, RegisterUser::new);

        Server server = new Server(8080);


        server.start();
    }
}
