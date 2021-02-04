import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static String path = "input.txt";

    public static void main(String[] args) {

        FileReader fileReader = new FileReader();

        List<String> queries = fileReader.readLines(path);
        Calculator calculator = new Calculator();
        int result = calculator.execute(queries);
        System.out.println(result);

    }

}
