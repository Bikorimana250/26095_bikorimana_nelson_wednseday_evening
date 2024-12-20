
import java.io.*;
import java.sql.*;

public class ExceptionHandling {
    public static void main(String[] args) {
        iOException();
        fileNotFoundException();
        eOFException();
        sQLException();
        classNotFoundException();

        arithmeticException();
        nullPointerException();
        arrayIndexOutOfBoundsException();
        classCastException();
        illegalArgumentException();
        numberFormatException();
    }

    private static void iOException() {
        try {
            FileReader reader = new FileReader("nonexistent_file.txt");
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }
    private static void fileNotFoundException() {
        try {
            FileInputStream file = new FileInputStream("missing_file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: " + e.getMessage());
        }
    }

    private static void eOFException() {
        try (DataInputStream dis = new DataInputStream(new ByteArrayInputStream(new byte[]{}))) {
            dis.readInt();
        } catch (EOFException e) {
            System.out.println("EOFException caught: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sQLException() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:invalid_url", "user", "password");
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e.getMessage());
        }
    }

    private static void classNotFoundException() {
        try {
            Class.forName("com.nonexistent.Class");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught: " + e.getMessage());
        }
    }

    private static void arithmeticException() {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        }
    }

    private static void nullPointerException() {
        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }
    }

    private static void arrayIndexOutOfBoundsException() {
        try {
            int[] array = {1, 2, 3};
            int value = array[5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        }
    }

    private static void classCastException() {
        try {
            Object obj = Integer.valueOf(10);
            String str = (String) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught: " + e.getMessage());
        }
    }


    private static void illegalArgumentException() {
        try {
            Thread thread = new Thread();
            thread.setPriority(20);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        }
    }

    private static void numberFormatException() {
        try {
            int num = Integer.parseInt("invalid_number");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        }
    }
}
