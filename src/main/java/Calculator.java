import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    static ScriptEngineManager mgr = new ScriptEngineManager();
    static ScriptEngine engine = mgr.getEngineByName("JavaScript");

    private List<String> queries;
    private List<String[]> splitedQueries;

    public Calculator(List<String> queries) {
        this.queries = queries;
        this.splitedQueries = sortQueries(queries);
    }

    public String execute() {
        try {
            while(splitedQueries.size() >= 2){
                StringBuilder s = new StringBuilder();

                String[] str0 = splitedQueries.get(0);
                s.append(str0[0]);
                s.append(str0[1]);

                String[] str1 = splitedQueries.get(1);
                s.append(str1[0]);
                s.append(str1[1]);

                String[] str = {"", engine.eval(s.toString()).toString()};
                splitedQueries.set(0,str);
                splitedQueries.remove(1);
            }
            return splitedQueries.get(0)[1];
        } catch (Exception e) {
//            e.printStackTrace();
            return "wrong inputs";
        }
    }

    private  String createOperation(List<String[]> splitedQueries) {
        StringBuilder s = new StringBuilder();
        for (String[] str : splitedQueries) {
            s.append(str[0]);
            s.append(str[1]);
        }
        return s.toString();
    }

    private  List<String[]> sortQueries(List<String> queries) {
        List<String[]> splitedQueries = new ArrayList<>();

        for (String s : queries) {
            String[] splited = s.split("\\s+");
            splitedQueries.add(splited);
        }


        for (String[] s : splitedQueries) {
            if (s[0].equals("add"))
                s[0] = "+";
            if (s[0].equals("subtract"))
                s[0] = "-";
            if (s[0].equals("multiply"))
                s[0] = "*";
            if (s[0].equals("divide"))
                s[0] = "/";
            if (s[0].equals("apply")) {
                s[0] = "";

            }
        }
        return splitedQueries;
    }

}
