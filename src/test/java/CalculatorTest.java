import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void execute_WrongInput_WrongInputReturned(){
        List<String> list = new ArrayList<>();
        list.add("apply 3");
        list.add("add g");
        list.add("subtract 6");
        list.add("add 12");
        list.add("divide 7");

        Calculator calculator = new Calculator(list);
        String result = calculator.execute();
        assertSame("wrong inputs", result);

    }

    @Test
    void execute_EmptyList_WrongInputReturned(){
        List<String> list = new ArrayList<>();

        Calculator calculator = new Calculator(list);
        String result = calculator.execute();
        assertSame("wrong inputs", result);

    }

    @Test
    void execute_DividedByZero_InfinityReturned(){
        List<String> list = new ArrayList<>();
        list.add("apply 2");
        list.add("divide 0");
        Calculator calculator = new Calculator(list);
        String result = calculator.execute();
        assertSame("Infinity", result);

    }



}