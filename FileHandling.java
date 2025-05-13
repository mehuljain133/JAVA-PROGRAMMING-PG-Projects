// Unit-III File Handling: Byte Stream, Character Stream, File I/O Basics, File Operations, Serialization.

import java.io.*;

// Class to demonstrate File Handling (Byte Stream, Character Stream, and Serialization)
public class FileHandlingDemo {

    public static void main(String[] args) {
        // Demonstrating Byte Stream: Writing and Reading binary data (byte-oriented)
        String byteStreamFile = "byteStreamFile.dat";
        writeByteStream(byteStreamFile, "This is a sample text using byte stream.");
        String byteStreamContent = readByteStream(byteStreamFile);
        System.out.println("Byte Stream Content: " + byteStreamContent);

        // Demonstrating Character Stream: Writing and Reading character data (char-oriented)
        String charStreamFile = "charStreamFile.txt";
        writeCharacterStream(charStreamFile, "This is a sample text using character stream.");
        String charStreamContent = readCharacterStream(charStreamFile);
        System.out.println("Character Stream Content: " + charStreamContent);

        // Demonstrating Serialization: Write and Read an object to/from file
        String objectStreamFile = "objectStreamFile.ser";
        Employee employee = new Employee("John", 30, "Developer");
        serializeObject(objectStreamFile, employee);
        Employee deserializedEmployee = deserializeObject(objectStreamFile);
        System.out.println("Deserialized Employee: " + deserializedEmployee);
    }

    // Method to write to file using Byte Stream
    public static void writeByteStream(String filename, String content) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            byte[] byteArray = content.getBytes();
            bos.write(byteArray);
            System.out.println("Byte stream written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to byte stream file: " + e.getMessage());
        }
    }

    // Method to read from file using Byte Stream
    public static String readByteStream(String filename) {
        StringBuilder content = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(filename);
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            int data;
            while ((data = bis.read()) != -1) {
                content.append((char) data);
            }
        } catch (IOException e) {
            System.out.println("Error reading from byte stream file: " + e.getMessage());
        }
        return content.toString();
    }

    // Method to write to file using Character Stream
    public static void writeCharacterStream(String filename, String content) {
        try (FileWriter fw = new FileWriter(filename);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(content);
            System.out.println("Character stream written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to character stream file: " + e.getMessage());
        }
    }

    // Method to read from file using Character Stream
    public static String readCharacterStream(String filename) {
        StringBuilder content = new StringBuilder();
        try (FileReader fr = new FileReader(filename);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error reading from character stream file: " + e.getMessage());
        }
        return content.toString();
    }

    // Method to serialize an object to a file
    public static void serializeObject(String filename, Employee employee) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(employee);
            System.out.println("Object serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error serializing object: " + e.getMessage());
        }
    }

    // Method to deserialize an object from a file
    public static Employee deserializeObject(String filename) {
        Employee employee = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            employee = (Employee) ois.readObject();
            System.out.println("Object deserialized successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error deserializing object: " + e.getMessage());
        }
        return employee;
    }
}

// Serializable Employee class for demonstrating serialization
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;
    String designation;

    public Employee(String name, int age, String designation) {
        this.name = name;
        this.age = age;
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", designation=" + designation + "]";
    }
}
