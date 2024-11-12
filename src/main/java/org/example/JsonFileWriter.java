package org.example;

import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;


public class JsonFileWriter {
    public static void main( String[] args )
    {
        addPersonToJson("person.json", "John Doe", 30, "New York");
    }


    public static void addPersonToJson(String filePath, String name, int age, String city) {

        JSONObject jo = new JSONObject();
        jo.put("name", name);
        jo.put("age",age);
        jo.put("city", city);

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jo.toString(4)); // 4 is for pretty-printing with indentation
            System.out.println("Successfully added person to JSON file: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        System.out.println("Successfully Wrote JSON Object to File...");
        System.out.println("\nJSON Object: " + jo);
    }
}