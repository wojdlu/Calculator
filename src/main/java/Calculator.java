import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private static final ScriptEngineManager MANAGER = new ScriptEngineManager();
    private static final ScriptEngine ENGINE = MANAGER.getEngineByName("JavaScript");

    /**
     * @param queries list of instructions for the calculator
     * @return the result of the operation
     */
    public static double execute(List<String> queries) {
        List<String[]> splitedQueries = splitQueries(queries);
        try {
            while (splitedQueries.size() >= 2) {
                StringBuilder s = new StringBuilder();

                String[] operator = splitedQueries.get(0);
                s.append(operator[0]);
                s.append(operator[1]);

                String[] number = splitedQueries.get(1);
                s.append(number[0]);
                s.append(number[1]);

                String[] str = {"", ENGINE.eval(s.toString()).toString()};
                splitedQueries.set(0, str);
                splitedQueries.remove(1);
            }
            return Double.parseDouble(splitedQueries.get(0)[1]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Wrong input");
        }
    }

    private static List<String[]> splitQueries(List<String> queries) {
        List<String[]> splitedQueries = new ArrayList<>();

        for (String s : queries) {
            String[] splited = s.split("\\s+");
            splited[0] = transformStringToOperator(splited[0]);
            splitedQueries.add(splited);
        }

        return splitedQueries;
    }

    private static String transformStringToOperator(String string) {
        String operator;
        switch (string) {
            case "add":
                operator = "+";
                break;
            case "subtract":
                operator = "-";
                break;
            case "multiply":
                operator = "*";
                break;
            case "divide":
                operator = "/";
                break;
            case "apply":
                operator = "";
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + string);
        }

        return operator;
    }

}
