import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private JPanel loginPanel, dataInputPanel, dashboardPanel;
    private JTextField usernameField, emailField;
    private JButton loginButton, nextButton, prevButton;
    private JLabel fillerLabel;
    private boolean isFirstTime = true;

    public GUI() {
        setTitle("PanTRY");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        // Creating components for login panel
        usernameField = new JTextField(20);
        emailField = new JTextField(20);
        loginButton = new JButton("Next");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement data input functionality here
                // For demo, switch to dashboard panel
                isFirstTime = false;
                initializeDashboardPanel(); // Initialize the dashboard panel
                cardLayout.show(cardPanel, "dashboard");
                setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window
            }
        });
        JPanel loginComponents = new JPanel(new GridLayout(3, 1));
        loginComponents.add(new JLabel("Username:"));
        loginComponents.add(usernameField);
        loginComponents.add(new JLabel("Email:"));
        loginComponents.add(emailField);
        loginComponents.add(loginButton);
        loginPanel = new JPanel(new BorderLayout());
        loginPanel.add(loginComponents, BorderLayout.CENTER);

        // Creating card panel with CardLayout
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.add(loginPanel, "login");

        // Adding card panel to frame
        add(cardPanel);

        // Show appropriate panel based on isFirstTime flag
        if (!isFirstTime) {
            initializeDashboardPanel(); // Initialize the dashboard panel if not first time
            cardLayout.show(cardPanel, "dashboard");
            setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window
        }

        setVisible(true);
    }

    private void initializeDashboardPanel() {
        // Creating components for dashboard panel
        JPanel bottomPanel = new JPanel();
        JButton suggestButton = new JButton("Suggest Meal (AI)");
        JButton addIngredientButton = new JButton("Add Ingredient");
        JButton editIngredientButton = new JButton("Edit Ingredient");
        JButton deleteIngredientButton = new JButton("Delete Ingredient");
        JButton viewIngredientButton = new JButton("View Ingredients");
        JButton addRecipeButton = new JButton("Add Recipe");
        JButton editRecipeButton = new JButton("Edit Recipe");
        JButton deleteRecipeButton = new JButton("Delete Recipe");
        JButton viewRecipeButton = new JButton("View Recipes");
        bottomPanel.add(suggestButton);
        bottomPanel.add(addIngredientButton);
        bottomPanel.add(editIngredientButton);
        bottomPanel.add(deleteIngredientButton);
        bottomPanel.add(viewIngredientButton);
        bottomPanel.add(addRecipeButton);
        bottomPanel.add(editRecipeButton);
        bottomPanel.add(deleteRecipeButton);
        bottomPanel.add(viewRecipeButton);

        JPanel centerPanel = new JPanel(new BorderLayout());
        JLabel fillerLabel = new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        centerPanel.add(fillerLabel, BorderLayout.CENTER);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Adding main panel to dashboard panel
        dashboardPanel = new JPanel(new BorderLayout());
        dashboardPanel.add(mainPanel, BorderLayout.CENTER);

        // Adding dashboard panel to card panel
        cardPanel.add(dashboardPanel, "dashboard");

        // Add action listeners for buttons in the dashboard
        suggestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement suggest functionality here (AI)
            }
        });

        // Add action listeners for other buttons as needed
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        });
    }
}
