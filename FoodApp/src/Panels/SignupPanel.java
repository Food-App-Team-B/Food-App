package Panels;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupPanel {

    public MainFrame frame; // Reference to Panels.GUI2 instance

    public SignupPanel(MainFrame frame){
        this.frame = frame;
    }
    public JPanel CreateSignUpPanel() {
        var signUpPanel = new JPanel(new BorderLayout());
        signUpPanel.setBackground(new Color(41, 128, 185));
        signUpPanel.add(new JLabel("Login Panel"), BorderLayout.CENTER);

        var usernameField = new JTextField(20);
        var emailField = new JTextField(20); // Create text fields for username and email

        JPanel loginComponents = new JPanel(new GridLayout(3, 1, 5, 5));
        loginComponents.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        loginComponents.add(new JLabel("Username:"));
        loginComponents.add(usernameField); // Assuming usernameField is a JTextField
        loginComponents.add(new JLabel("Email:"));
        loginComponents.add(emailField); // Assuming emailField is a JTextField

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBackground(new Color(41, 128, 185));
        loginButton.setForeground(Color.BLACK); // Black text color
        loginButton.setFocusPainted(false); // Remove focus border
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // When login button is pressed
                System.out.println("Button clicked!"); // Just an example print statement
                System.out.println("Username: " + usernameField.getText());
                System.out.println("Email: " + emailField.getText());
                PantryPanel pantryPanel = new PantryPanel();
                JPanel ppanel = pantryPanel.PantryPanel();
                frame.showPanel(ppanel);

            }});

        signUpPanel.add(loginComponents, BorderLayout.CENTER);
        signUpPanel.add(loginButton, BorderLayout.SOUTH);

        return signUpPanel;
    }
}
