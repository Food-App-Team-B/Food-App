import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeApp extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private JPanel welcomePanel, loginPanel, dataInputPanel;
    private JTextField usernameField, emailField, passwordField, ingredientField;
    private JButton loginButton, nextButton, prevButton, addIngredientButton;
    private JLabel welcomeLabel;
    private DefaultListModel<String> pantryModel;

    public RecipeApp() {
        setTitle("PanTRY");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true); // Remove window decoration
        setLocationRelativeTo(null);

        // Creating welcome panel
        welcomeLabel = new JLabel("Welcome back user");
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 36));
        welcomePanel = new JPanel(new BorderLayout());
        welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
        add(welcomePanel);

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

        // Creating components for login panel
        usernameField = new JTextField(20);
        emailField = new JTextField(20);
        passwordField = new JTextField(20);
        loginButton = new JButton("Next");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "dataInput");
            }
        });
        JPanel loginComponents = new JPanel(new GridLayout(4, 1));
        loginComponents.add(new JLabel("Username:"));
        loginComponents.add(usernameField);
        loginComponents.add(new JLabel("Email:"));
        loginComponents.add(emailField);
        loginComponents.add(new JLabel("Password:"));
        loginComponents.add(passwordField);
        loginComponents.add(loginButton);
        loginPanel = new JPanel(new BorderLayout());
        loginPanel.add(loginComponents, BorderLayout.CENTER);

        // Creating components for data input panel
        dataInputPanel = new JPanel(new BorderLayout());
        ingredientField = new JTextField(20);
        addIngredientButton = new JButton("Add Ingredient");
        addIngredientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ingredient = ingredientField.getText();
                // Placeholder method for adding ingredient to pantry
                addIngredientToPantry(ingredient);
                ingredientField.setText("");
            }
        });
        JPanel dataInputComponents = new JPanel(new GridLayout(2, 1));
        dataInputComponents.add(new JLabel("Ingredient:"));
        dataInputComponents.add(ingredientField);
        dataInputComponents.add(addIngredientButton);
        dataInputPanel.add(dataInputComponents, BorderLayout.CENTER);

        // Creating card panel with CardLayout
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.add(welcomePanel, "welcome");
        cardPanel.add(loginPanel, "login");
        cardPanel.add(dataInputPanel, "dataInput");

        // Adding card panel to frame
        add(cardPanel);

        // Show the welcome panel by default
        cardLayout.show(cardPanel, "welcome");

        setVisible(true);
    }

    private void addIngredientToPantry(String ingredient) {
        // Placeholder method for adding ingredient to pantry
        // Here you can implement functionality to add the ingredient to the pantry
        System.out.println("Adding ingredient to pantry: " + ingredient);
        pantryModel.addElement(ingredient); // Adding ingredient to the list model
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
