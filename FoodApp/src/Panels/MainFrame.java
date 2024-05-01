package Panels;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel welcomePanel, dashboardPanel;
    private JTextField usernameField, emailField;
    private JTextArea textBox;

    public MainFrame() {
        setTitle("PanTRY");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLocationRelativeTo(null);

        // Create welcome back panel
        welcomePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        welcomePanel.setBackground(new Color(196, 223, 155)); // Green
        JLabel welcomeLabel = new JLabel("<html><br><br><br><br><br>Welcome Back!</html>");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 50)); // Set the font size to 50
        welcomePanel.add(welcomeLabel); // Add the label to the welcome panel

        SignupPanel signupPanel = new SignupPanel(this);
        JPanel spanel = signupPanel.CreateSignUpPanel();

        // Add panels to frame
        add(spanel);
       // add(welcomePanel);
        //add(ppanel);

        showPanel(spanel);

        setVisible(true);
    }

    // Method to switch between panels
    public void showPanel(JPanel panel) {
        getContentPane().removeAll(); // Remove all components from the frame
        getContentPane().add(panel); // Add the specified panel
        if (panel == welcomePanel || panel == dashboardPanel) {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int preferredWidth = (int) (screenSize.getWidth() * 0.8); // 80% of screen width
            int preferredHeight = (int) (screenSize.getHeight() * 0.8); // 80% of screen height
            setSize(new Dimension(preferredWidth, preferredHeight));

        } else {
            setSize(1000, 1000); // Reset the frame size when showing other panels
        }
        setLocationRelativeTo(null); // Center the frame on the screen
        revalidate(); // Revalidate the frame to reflect the changes
        repaint(); // Repaint the frame
    }
}

