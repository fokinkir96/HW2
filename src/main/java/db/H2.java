package db;
import java.io.IOException;

public class H2 extends DbHandler {
    public H2() throws IOException {
        super("src/main/resources/DbConfig/h2.properties");
    }
}
