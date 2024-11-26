package org.example;

import org.json.JSONObject;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonFileWriterTest {

    @ParameterizedTest
    @CsvSource({
            "John Doe, 30, New York",
            "Jane Smith, 25, Los Angeles",
            "Alice Brown, 40, Chicago"
    })
    public void testAddPersonToJsonParameterized(String name, int age, String city) throws IOException {
        // Create a temporary file for each parameterized test case
        File tempFile = File.createTempFile("test_person", ".json");
        tempFile.deleteOnExit(); // Ensure the file is deleted after the test

        // Call the method under test with the provided parameters
        JsonFileWriter.addPersonToJson(tempFile.getAbsolutePath(), name, age, city);

        // Verify the file exists
        assertTrue(tempFile.exists(), "The JSON file should be created");

        // Read the file content using Files.readAllBytes
        String content = new String(Files.readAllBytes(tempFile.toPath()));

        // Create the expected JSON
        JSONObject expectedJson = new JSONObject();
        expectedJson.put("name", name);
        expectedJson.put("age", age);
        expectedJson.put("city", city);

        // Verify the content of the file matches the expected JSON
        assertEquals(expectedJson.toString(4), content, "The JSON content in the file should match the expected content");
    }
}
