/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goit.practice.tests;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runners.model.TestTimedOutException;

import java.util.ArrayList;

/**
 *
 * @author Producer
 */
public class ExceptionHandlingTest {
    
    public ExceptionHandlingTest() {
    }

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Rule
    public final Timeout timeout = Timeout.millis(500);

    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of main method, of class ExceptionHandling.
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testMainShouldReturnIndexOutOfBoundsException() {
     new ArrayList<Object>().get(0); 
    }

    @Ignore ("Ignore cause redundant")
    @Test (expected = ArithmeticException.class)
    public void testDivideByZeroShouldReturnArithmeticException()
    {
        int x = 10/0;
    }

    @Test
    public void testExpectedExceptionShouldReturnArithmeticException() {
        expectedException.expect(ArithmeticException.class);
        int x = 10/0;
    }

    @Test
    public void testTimeoutExceptionShouldFailWithTimeout() throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
        }
    }
}

