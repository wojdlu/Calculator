public class Main {

    private static final String PATH = "C:\\Users\\admin\\Desktop\\JavaProjects\\Calculator\\input.txt";

    public static void main(String[] args) {

        FileReader fileReader = new FileReader();
        double result = Calculator.execute(fileReader.readLines(PATH));
        System.out.println(result);

    }

}
