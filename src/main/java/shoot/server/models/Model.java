package shoot.server.models;

import shoot.server.Database;

import java.sql.Connection;

public abstract class Model<K> extends jeda00.db.Model<K> {

    @Override
    public Connection getConnection() {
        return Database.getConnection();
    }
}
