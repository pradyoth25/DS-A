package algorithms.dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    Fibonacci dp = new Fibonacci();

    @Test
    public void testFib(){
        assertEquals(dp.fibonacci(2), 1);
        assertEquals(dp.fibonacci(3), 2);
        assertEquals(dp.fibonacci(4), 3);
        assertEquals(dp.fibonacci(5), 5);
        assertEquals(dp.fibonacci(6), 8);
        assertEquals(dp.fibonacciMemo(45), 1134903170);
        assertEquals(dp.fibonacciDP(50), -811192543);
    }

}