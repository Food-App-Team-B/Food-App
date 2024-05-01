import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeApp extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private JPanel welcomePanel, loginPanel, pantryPanel;
    private JTextField usernameField, emailField, passwordField, ingredientField;
    private JButton loginButton, nextButton, prevButton, addIngredientButton, profileButton, exitButton;
    private JLabel welcomeLabel, profileLabel;
    private DefaultListModel<String> pantryModel;
    private JList<String> pantryList;

    public RecipeApp() {
        setTitle("PanTRY");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setLocationRelativeTo(null);

        // Welcome Panel
        welcomeLabel = new JLabel("Welcome back user");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 48));
        JPanel welcomeContent = new JPanel(new BorderLayout());
        welcomeContent.add(welcomeLabel, BorderLayout.CENTER);
        exitButton = new JButton("X");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        exitButton.setForeground(Color.RED);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JPanel welcomeHeader = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        welcomeHeader.add(exitButton);
        welcomePanel = new JPanel(new BorderLayout());
        welcomePanel.add(welcomeHeader, BorderLayout.NORTH);
        welcomePanel.add(welcomeContent, BorderLayout.CENTER);

        // Delayed switch to login panel
        Timer timer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((Timer) e.getSource()).stop();
                cardLayout.show(cardPanel, "login");
            }
        });
        timer.setRepeats(false);
        timer.start();

        // Login Panel
        usernameField = new JTextField(20);
        emailField = new JTextField(20);
        passwordField = new JTextField(20);
        loginButton = new JButton("Next");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "pantry");
            }
        });
        profileButton = new JButton("Profile");
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(RecipeApp.this,
                        "Username: " + usernameField.getText() + "\nEmail: " + emailField.getText(),
                        "Profile Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        JPanel loginComponents = new JPanel(new GridLayout(5, 1));
        loginComponents.add(new JLabel("Username:"));
        loginComponents.add(usernameField);
        loginComponents.add(new JLabel("Email:"));
        loginComponents.add(emailField);
        loginComponents.add(new JLabel("Password:"));
        loginComponents.add(passwordField);
        loginComponents.add(loginButton);
        loginComponents.add(profileButton);
        loginPanel = new JPanel(new BorderLayout());
        loginPanel.add(loginComponents, BorderLayout.CENTER);

        // Pantry Panel
        ingredientField = new JTextField(20);
        ingredientField.setFont(new Font("Arial", Font.PLAIN, 20));
        addIngredientButton = new JButton("Add");
        addIngredientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ingredient = ingredientField.getText();
                addIngredientToPantry(ingredient);
                ingredientField.setText("");
            }
        });
        JPanel pantryComponents = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputPanel.add(ingredientField);
        inputPanel.add(addIngredientButton);
        pantryComponents.add(inputPanel, BorderLayout.NORTH);
        pantryModel = new DefaultListModel<>();
        pantryList = new JList<>(pantryModel);
        pantryList.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane pantryScrollPane = new JScrollPane(pantryList);
        pantryComponents.add(pantryScrollPane, BorderLayout.CENTER);
        profileButton = new JButton("Profile");
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(RecipeApp.this,
                        "Username: " + usernameField.getText() + "\nEmail: " + emailField.getText(),
                        "Profile Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        JPanel pantryHeader = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pantryHeader.add(profileButton);
        pantryPanel = new JPanel(new BorderLayout());
        pantryPanel.add(pantryHeader, BorderLayout.NORTH);
        pantryPanel.add(pantryComponents, BorderLayout.CENTER);

        // Creating card panel with CardLayout
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.add(welcomePanel, "welcome");
        cardPanel.add(loginPanel, "login");
        cardPanel.add(pantryPanel, "pantry");

        // Adding card panel to frame
        add(cardPanel);

        // Show the welcome panel by default
        cardLayout.show(cardPanel, "welcome");

        setVisible(true);
    }

    private void addIngredientToPantry(String ingredient) {
        pantryModel.addElement(ingredient);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RecipeApp();
            }
        });
    }
}
