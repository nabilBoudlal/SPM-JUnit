package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyClassTest {


    @Test
    @Disabled
    public void testMultiply() {
        MyClass tester = new MyClass();
        assertEquals(50, tester.multiply(10, 5));
    }
}
