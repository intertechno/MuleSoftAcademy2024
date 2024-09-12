package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void shouldCalculateSumCorrectly()
    {
        int a = 10;
        int b = 20;
        App app = new App();
        int result = app.CalculateSum(a, b);
        int expected = a + b;

        assertTrue(result == expected);
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
