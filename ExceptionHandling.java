// Unit-IV Exception handling: Throw and Exception, Throw, try and catch Blocks, Multiple Catch Blocks, Finally Clause, Throwable Class, Types of Exceptions, java.lang Exceptions, Built-In Exceptions.

// Class to demonstrate exception handling in Java
public class ExceptionHandlingDemo {

    public static void main(String[] args) {
        // 1. Demonstrating Throw and Exception
        try {
            checkAge(15); // This will throw an exception
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        // 2. Demonstrating Try and Catch Block
        try {
            int result = divide(10, 0); // This will throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed!");
        }

        // 3. Multiple Catch Blocks
        try {
            String str = null;
            System.out.println(str.length()); // NullPointerException
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught!");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: String is null.");
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // 4. Finally Clause
        try {
            int result = divide(10, 2); // This will not throw an exception
            System.out.println("Result of division: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero.");
        } finally {
            System.out.println("Finally block executed, cleanup can be done here.");
        }

        // 5. Throwable Class Demonstration
        try {
            throw new Throwable("This is a throwable object.");
        } catch (Throwable t) {
            System.out.println("Caught Throwable: " + t.getMessage());
        }

        // 6. Built-In Exception Demonstration (ArrayIndexOutOfBoundsException)
        try {
            int[] arr = new int[5];
            arr[10] = 100; // This will throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        // 7. Custom Exception Handling (Demonstrating Throw)
        try {
            validateAge(17); // This will throw a custom exception
        } catch (AgeNotValidException e) {
            System.out.println("Caught Custom Exception: " + e.getMessage());
        }
    }

    // Method to demonstrate throw statement and exception
    public static void checkAge(int age) throws Exception {
        if (age < 18) {
            throw new Exception("Age is less than 18, access denied.");
        } else {
            System.out.println("Access granted.");
        }
    }

    // Method to demonstrate arithmetic exception (divide by zero)
    public static int divide(int a, int b) throws ArithmeticException {
        return a / b;
    }

    // Custom Exception class for age validation
    static class AgeNotValidException extends Exception {
        public AgeNotValidException(String message) {
            super(message);
        }
    }

    // Method to demonstrate custom exception handling with throw
    public static void validateAge(int age) throws AgeNotValidException {
        if (age < 18) {
            throw new AgeNotValidException("Age must be 18 or older.");
        } else {
            System.out.println("Age is valid.");
        }
    }
}
