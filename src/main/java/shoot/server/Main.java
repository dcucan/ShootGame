package shoot.server;

import jeda00.db.Migrations;

public class Main {

    public static void main(String[] args) {
        Migrations migrations = new Migrations(Database.getConnection());
        migrations.runMigrations();

        System.out.println("Hello, Server!");
    }
}
