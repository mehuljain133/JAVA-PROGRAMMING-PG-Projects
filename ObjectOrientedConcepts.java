// Unit-II Object Oriented Concepts: Abstraction, encapsulation, objects, classes, methods, constructors, inheritance, polymorphism, static and dynamic binding, overloading, Abstract classes, Interfaces and Packages.

// Package declaration
package oopConcepts;

// Abstract class demonstrating abstraction
abstract class Animal {
    // Abstract method (no body)
    public abstract void sound();

    // Regular method
    public void sleep() {
        System.out.println("This animal sleeps at night.");
    }
}

// Interface demonstrating abstraction through interfaces
interface Shape {
    double area(); // Method to calculate area
    double perimeter(); // Method to calculate perimeter
}

// Class Dog inheriting Animal class (demonstrating Inheritance)
class Dog extends Animal {
    // Implementing the abstract method
    public void sound() {
        System.out.println("The dog barks.");
    }
}

// Class Circle implementing Shape interface (demonstrating Interface)
class Circle implements Shape {
    private double radius;

    // Constructor for Circle class
    public Circle(double radius) {
        this.radius = radius;
    }

    // Implementing area method from Shape interface
    public double area() {
        return Math.PI * radius * radius;
    }

    // Implementing perimeter method from Shape interface
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

// Class Rectangle implementing Shape interface
class Rectangle implements Shape {
    private double length, width;

    // Constructor for Rectangle class
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Implementing area method from Shape interface
    public double area() {
        return length * width;
    }

    // Implementing perimeter method from Shape interface
    public double perimeter() {
        return 2 * (length + width);
    }
}

// Main class demonstrating object-oriented concepts
public class OOPDemo {
    public static void main(String[] args) {
        // 1. Object Creation & Constructor Usage
        Dog myDog = new Dog();  // Creating an object of Dog class
        myDog.sound();  // Calling method sound()
        myDog.sleep();  // Calling method sleep()

        // 2. Static and Dynamic Binding
        Animal myAnimal = new Dog(); // Dynamic Binding (Runtime Polymorphism)
        myAnimal.sound(); // Will call Dog's sound method at runtime

        // 3. Overloading: Method overloading example
        System.out.println("Sum of 5 and 10: " + add(5, 10)); // Calling overloaded method
        System.out.println("Sum of 5, 10 and 15: " + add(5, 10, 15)); // Calling overloaded method

        // 4. Abstraction: Shape Interface and Implementing Classes
        Shape circle = new Circle(5);  // Creating object of Circle
        System.out.println("Circle Area: " + circle.area());
        System.out.println("Circle Perimeter: " + circle.perimeter());

        Shape rectangle = new Rectangle(4, 6);  // Creating object of Rectangle
        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Rectangle Perimeter: " + rectangle.perimeter());
    }

    // Overloading: Method with 2 parameters
    public static int add(int a, int b) {
        return a + b;
    }

    // Overloading: Method with 3 parameters
    public static int add(int a, int b, int c) {
        return a + b + c;
    }
}
