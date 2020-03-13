package com.goit.practice.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FibonacciTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{0, 0},
                {1, 1}, {2, 1}, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }});
    }

    private int inputValue;

    private int expectedValue;

    public FibonacciTest(int input, int expected) {
        this.inputValue = input;
        this.expectedValue = expected;
    }

    @Test
    public void testFibonacciComputeShouldPassWithAllDataSet() {
        //given
        //when
        int compute = Fibonacci.compute(inputValue);
        //then
        assertEquals(expectedValue, compute);
    }
}
