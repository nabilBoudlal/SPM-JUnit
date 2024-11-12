package org.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void testMainOutputsHelloWorld() {
        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream)); // Redirect System.out to outputStream

        // Act
        App.main(new String[]{});

        // Assert
        String expectedOutput = "Hello World!" + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());

        // Cleanup
        System.setOut(System.out); // Reset System.out to original
    }
}