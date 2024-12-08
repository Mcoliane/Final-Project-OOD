import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    public MyFrame() {
        // Set the title of the frame
        setTitle("Pc Builder");

        // Set the size of the frame
        setSize(800, 600);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(null); // Use null layout for absolute positioning

        // Welcoming label for intro screen
        JLabel label = new JLabel("Welcome to Pc Part picker!", SwingConstants.CENTER);
        label.setBounds(0, 0, 800, 50); // x, y, width, height
        label.setFont(new Font("Times New Roman", Font.PLAIN, 36)); // font and size
        panel.add(label);

        // Create a label for the name text field
        JLabel nameLabel = new JLabel("Enter your name:");
        nameLabel.setBounds(150, 200, 200, 30); // x, y, width, height
        nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // font and size
        panel.add(nameLabel);

        // Create a text field for entering the name
        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(150, 240, 200, 30); // x, y, width, height
        panel.add(nameTextField);

        // Add an ActionListener to the text field
        nameTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                JLabel welcomeLabel = new JLabel("Welcome " + name + "!");
                welcomeLabel.setBounds(150, 280, 500, 30); // x, y, width, height
                welcomeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // font and size
                panel.add(welcomeLabel);
                panel.revalidate();
                panel.repaint();
            }
        });

        // Create a button to the right of the text field
        JButton enterButton = new JButton("Enter");
        enterButton.setBounds(380, 240, 140, 50); // x, y, width, height
        panel.add(enterButton);

        // Add the panel to the frame
        add(panel);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}