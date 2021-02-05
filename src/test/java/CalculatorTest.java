
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class CalculatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForWrongNumber() {
        // given
        List<String> list = new ArrayList<>();
        list.add("apply 3");
        list.add("add g");
        list.add("subtract 6");
        list.add("add 12");
        list.add("divide 7");

        // when & then exception is thrown
        Calculator.execute(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForEmptyList() {
        // given
        List<String> list = new ArrayList<>();

        // when & then exception is thrown
        Calculator.execute(list);
    }

    @Test
    public void shouldCalculateCorrectInput() {

        // given
        List<String> list = new ArrayList<>();
        list.add("apply 3");
        list.add("add 3");
        list.add("multiply 3");

        // when
        double result = Calculator.execute(list);

        // then
        assertEquals(18.0, result,0.001);
    }

    @Test
    public void shouldCalculateCorrectInputWithAllOperators() {

        // given
        List<String> list = new ArrayList<>();
        list.add("apply 3");
        list.add("add 3");
        list.add("multiply 3");
        list.add("divide 2");

        // when
        double result = Calculator.execute(list);

        // then
        assertEquals(9.0,result,0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForIllegalOperator() {
        // given
        List<String> list = new ArrayList<>();
        list.add("apply 3");
        list.add("ad 3");
        list.add("multiply 3");
        list.add("divide 2");

        // when & then exception is thrown
        Calculator.execute(list);
    }
}