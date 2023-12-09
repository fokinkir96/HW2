import db.H2;
import org.tree.TreeList;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<ArrayList<Integer>> data = new H2().getAll();
        TreeList allTrees = new TreeList(data);

        saveResult(allTrees.getLeafsSum());
    }

    static public void saveResult(int value) throws IOException {
        FileWriter writer = new FileWriter("output.csv");
        writer.append(String.valueOf(value));

        writer.flush();
        writer.close();
    }
}
