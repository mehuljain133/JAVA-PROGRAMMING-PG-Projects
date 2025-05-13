// Unit-V GUI Design: GUI based I/O, Input and Message Dialog boxes, Swing components, Displaying text and images in window. 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUIDemo {

    public static void main(String[] args) {
        // Create the main frame for the GUI
        JFrame frame = new JFrame("GUI Design Demo");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set up the layout manager
        frame.setLayout(new FlowLayout());
        
        // 1. Label and Text Field for user input
        JLabel label = new JLabel("Enter your name: ");
        JTextField textField = new JTextField(20);  // Text field with a column width of 20
        
        // 2. Button to trigger actions
        JButton greetButton = new JButton("Greet");
        
        // 3. Button to display message dialog
        JButton showMessageButton = new JButton("Show Message");
        
        // 4. Button to open an image file
        JButton loadImageButton = new JButton("Load Image");

        // 5. Label to display the image
        JLabel imageLabel = new JLabel();

        // Action listener for Greet button
        greetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter your name!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Hello, " + name + "!", "Greeting", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Action listener for Show Message button
        showMessageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "This is a message dialog!", "Message", JOptionPane.PLAIN_MESSAGE);
            }
        });

        // Action listener for Load Image button
        loadImageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "png", "gif");
                fileChooser.setFileFilter(filter);
                int result = fileChooser.showOpenDialog(frame);
                
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                    imageLabel.setIcon(imageIcon);
                    frame.repaint();  // Refresh frame to show the image
                }
            }
        });

        // Add components to the frame
        frame.add(label);
        frame.add(textField);
        frame.add(greetButton);
        frame.add(showMessageButton);
        frame.add(loadImageButton);
        frame.add(imageLabel);
        
        // Set the frame visible
        frame.setVisible(true);
    }
}
