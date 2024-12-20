/*
 * Summary:
 * This program demonstrates how to handle various exceptions in Java through practical examples. 
 * Each exception is triggered in a realistic scenario and handled using try-catch blocks. 
 * Both checked and unchecked exceptions are covered, with detailed comments for clarity.
 */

import java.io.*;
import java.sql.*;

public class ExceptionHandlingExamples {
    public static void main(String[] args) {
        demonstrateIOException();
        demonstrateFileNotFoundException();
        demonstrateEOFException();
        demonstrateSQLException();
        demonstrateClassNotFoundException();
        demonstrateArithmeticException();
        demonstrateNullPointerException();
        demonstrateArrayIndexOutOfBoundsException();
        demonstrateClassCastException();
        demonstrateIllegalArgumentException();
        demonstrateNumberFormatException();
    }

    // Example of IOException
    private static void demonstrateIOException() {
        try {
            FileWriter writer = new FileWriter("readonlyfile.txt");
            writer.write("Testing IOException");
            writer.close();
        } catch (IOException e) {
            System.out.println("IOException caught: Unable to write to file.");
        }
    }

    // Example of FileNotFoundException
    private static void demonstrateFileNotFoundException() {
        try {
            FileReader reader = new FileReader("nonexistentfile.txt");
            reader.read();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: File not found.");
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

    // Example of EOFException
    private static void demonstrateEOFException() {
        try {
            DataInputStream inputStream = new DataInputStream(new FileInputStream("datafile.txt"));
            while (true) {
                inputStream.readUTF();
            }
        } catch (EOFException e) {
            System.out.println("EOFException caught: Reached end of file.");
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

    // Example of SQLException
    private static void demonstrateSQLException() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fakeDB", "root", "password");
            Statement statement = connection.createStatement();
            statement.executeQuery("INVALID SQL");
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e.getMessage());
        }
    }

    // Example of ClassNotFoundException
    private static void demonstrateClassNotFoundException() {
        try {
            Class.forName("com.example.NonExistentClass");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught: " + e.getMessage());
        }
    }

    // Example of ArithmeticException
    private static void demonstrateArithmeticException() {
        try {
            int result = 50 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: Cannot divide by zero.");
        }
    }

    // Example of NullPointerException
    private static void demonstrateNullPointerException() {
        try {
            String text = null;
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: Null reference accessed.");
        }
    }

    // Example of ArrayIndexOutOfBoundsException
    private static void demonstrateArrayIndexOutOfBoundsException() {
        try {
            int[] numbers = {10, 20, 30};
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: Invalid array index.");
        }
    }

    // Example of ClassCastException
    private static void demonstrateClassCastException() {
        try {
            Object obj = new Double(3.14);
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught: Invalid type casting.");
        }
    }

    // Example of IllegalArgumentException
    private static void demonstrateIllegalArgumentException() {
        try {
            Thread thread = new Thread();
            thread.setPriority(11); // Invalid priority
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: Invalid argument passed.");
        }
    }

    // Example of NumberFormatException
    private static void demonstrateNumberFormatException() {
        try {
            int num = Integer.parseInt("InvalidNumber");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: Invalid number format.");
        }
    }
}
