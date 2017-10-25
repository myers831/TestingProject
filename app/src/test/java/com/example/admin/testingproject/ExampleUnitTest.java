package com.example.admin.testingproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


public class ExampleUnitTest {

    Calculation calculation;

    Addition addition;
    int val1, val2;

    public static final String ADDITION_STRING = "addition";
    public static final String CALCULATION_STRING = "calculation";

    @Before
    public void setup(){
        addition = mock(Addition.class);
        calculation = new Calculation(addition);
        val1 = 5;
        val2 = 10;
        calculation.setVal1(val1);
        calculation.setVal2(val2);
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(10, calculation.addition());
    }

    @Test
    public void addTen_isCorrect() throws Exception {

        when(addition.add(val1, val2)).thenReturn(5);

        assertEquals(10, calculation.addTen());
    }

    @Test
    public void someString_test(){
        when(addition.additionString(ADDITION_STRING))
                .thenAnswer(new Answer<String>() {
                    @Override
                    public String answer(InvocationOnMock invocation) throws Throwable {
                        return "some";
                    }
                });

        assertEquals("some"+CALCULATION_STRING, calculation.calculationString(ADDITION_STRING, CALCULATION_STRING));
    }

    @After
    public void tearDown(){
        calculation.clear();
    }
}