package ar.edu.untref.aydoo;

import org.junit.Test;

public class FibonacciInputTest
{
    @Test(expected = IllegalArgumentException.class)
    public void testValidInputWithOneDigit() throws IllegalArgumentException {
        String input[] = new String[]{"0"};
        Fibonacci.validateInput(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInputWithOneDigit() throws IllegalArgumentException {
        String input[] = new String[]{"A"};
        Fibonacci.validateInput(input);
    }

    @Test
    public void testValidInputWithTwoArgumentsVerticalAndDirect() throws IllegalArgumentException {
        String input[] = new String[]{"-o=vd", "5"};
        Fibonacci.validateInput(input);
    }

    @Test
    public void testValidInputWithTwoArgumentsHorizontalEInverse() throws IllegalArgumentException {
        String input[] = new String[]{"-o=hi", "8"};
        Fibonacci.validateInput(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInValidInputWithTwoArguments() throws IllegalArgumentException {
        String input[] = new String[]{"-o=xy", "8"};
        Fibonacci.validateInput(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInValidInputWithTheArgumentsVerticalHorizontal() throws IllegalArgumentException {
        String input[] = new String[]{"-o=vh", "8"};
        Fibonacci.validateInput(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInValidInputWithTheArgumentsHorizontalVertical() throws IllegalArgumentException {
        String input[] = new String[]{"-o=vh", "8"};
        Fibonacci.validateInput(input);
    }

    @Test
    public void testValidInputWithTwoArgumentsProgressiveAndDirect() throws IllegalArgumentException {
        String input[] = new String[]{"-o=pd", "5"};
        Fibonacci.validateInput(input);
    }

    @Test
    public void testValidInputWithTwoArgumentsProgressiveAndInverse() throws IllegalArgumentException {
        String input[] = new String[]{"-o=pi", "5"};
        Fibonacci.validateInput(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidInputWithTwoArgumentsProgressiveAndHorizontal() throws IllegalArgumentException {
        String input[] = new String[]{"-o=ph", "5"};
        Fibonacci.validateInput(input);
    }

    @Test
    public void testValidInputWithTwoArgumentsToPrintPairs() throws IllegalArgumentException {
        String input[] = new String[]{"-n=p", "5"};
        Fibonacci.validateInput(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateInputWithIlegalArgumentForPrintPairs() throws IllegalArgumentException {
        String input[] = new String[]{"-n=o", "5"};
        Fibonacci.validateInput(input);
    }
}
