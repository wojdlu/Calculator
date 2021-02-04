import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public FileReader() {
    }

    public List<String> readLines(String path){
        BufferedReader reader;
        List<String> queries = new ArrayList<>();
        try {
            reader = new BufferedReader(new java.io.FileReader(path));
            String line = reader.readLine();

            while (line != null) {
                if (line.startsWith("apply"))
                    queries.add(0, line);
                else
                    queries.add(line);
                line = reader.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return queries;

    }
}
