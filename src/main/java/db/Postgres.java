package db;
import java.io.IOException;

public class Postgres extends DbHandler {
    public Postgres() throws IOException {
        super("DbConfig/postgres.properties");
    }
}

