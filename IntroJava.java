// Unit-I Introductory Concepts: program, identifiers, variables, constants, primitive data types, expressions, control statements, structured data types, arrays, functions.

public class IntroJava {

    // Constants
    final static double PI = 3.14159;

    public static void main(String[] args) {
        
        // 1. Variables (Primitive Data Types)
        int number = 10;
        double price = 19.99;
        char grade = 'A';
        boolean isActive = true;

        // 2. Printing values
        System.out.println("Initial values:");
        System.out.println("Integer: " + number);
        System.out.println("Double: " + price);
        System.out.println("Char: " + grade);
        System.out.println("Boolean: " + isActive);
        System.out.println("Constant PI: " + PI);
        
        // 3. Expressions (Arithmetic)
        int sum = number + 5;
        double area = PI * 4 * 4; // Using PI constant
        
        System.out.println("Sum of number and 5: " + sum);
        System.out.println("Area of circle with radius 4: " + area);
        
        // 4. Control Statements: if-else and switch
        if (number > 5) {
            System.out.println("Number is greater than 5");
        } else {
            System.out.println("Number is less than or equal to 5");
        }

        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Invalid day");
        }

        // 5. Arrays (Structured Data Type)
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Array elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Element " + i + ": " + arr[i]);
        }
        
        // 6. Functions (Methods)
        int result = add(10, 20); // Calling add method
        System.out.println("Sum of 10 and 20 is: " + result);
        
        // Calling function with a parameter
        printGreeting("John");

        // Returning and printing the product of 5 and 4
        int product = multiply(5, 4);
        System.out.println("Product of 5 and 4 is: " + product);
    }

    // Function to add two numbers
    public static int add(int a, int b) {
        return a + b;
    }

    // Function to print a greeting message
    public static void printGreeting(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // Function to multiply two numbers
    public static int multiply(int x, int y) {
        return x * y;
    }
}
