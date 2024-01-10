package db;
import java.io.IOException;

public class H2 extends DbHandler {
    public H2() throws IOException {
        super("DbConfig/h2.properties");
    }
}
