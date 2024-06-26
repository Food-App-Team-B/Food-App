import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial") // weird error idk
public class GUI extends JFrame {
	private JPanel signUpPanel, welcomePanel, dashboardPanel;
    private JTextField usernameField, emailField;
    private JTextArea textBox;

    public GUI() {
        setTitle("PanTRY");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        // Create login panel
        signUpPanel = new JPanel(new BorderLayout());
        signUpPanel.setBackground(new Color(41, 128, 185));
        signUpPanel.add(new JLabel("Login Panel"), BorderLayout.CENTER);
        
        usernameField = new JTextField(20);
        emailField = new JTextField(20); // Create text fields for username and email
        
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
		        System.out.println("Username: "+usernameField.getText());
		        System.out.println("Email: "+emailField.getText());
			}});

        signUpPanel.add(loginComponents, BorderLayout.CENTER);
        signUpPanel.add(loginButton, BorderLayout.SOUTH);
        
        // Create welcome back panel
        welcomePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        welcomePanel.setBackground(new Color(196, 223, 155)); // Green
        JLabel welcomeLabel = new JLabel("<html><br><br><br><br><br>Welcome Back!</html>");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 50)); // Set the font size to 50
        welcomePanel.add(welcomeLabel); // Add the label to the welcome panel

        // Create dashboard panel
        dashboardPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        dashboardPanel.setBackground(new Color(52, 152, 219)); // Blue color
        JButton suggestButton = new JButton("Suggest Meal (AI)");
        suggestButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		System.out.println("Suggest Recipe!");
            }
        });
        JButton addIngredientButton = new JButton("Add Ingredient");
        addIngredientButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		System.out.println("Add Ingredient!");
            }
        });
        JButton editIngredientButton = new JButton("Edit Ingredient");
        editIngredientButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		System.out.println("Edit Ingredient!");
            }
        });
        JButton deleteIngredientButton = new JButton("Delete Ingredient");
        deleteIngredientButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		System.out.println("Delete Ingredient!");
            }
        });
        JButton viewIngredientButton = new JButton("View Ingredients");
        viewIngredientButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		System.out.println("View Ingredients!");
            }
        });        
        JButton addRecipeButton = new JButton("Add Recipe");
        addRecipeButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		System.out.println("Add Recipe!");
            }
        });        
        JButton editRecipeButton = new JButton("Edit Recipe");
        editRecipeButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		System.out.println("Edit Recipe!");
            }
        });        
        JButton deleteRecipeButton = new JButton("Delete Recipe");
        deleteRecipeButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		System.out.println("Delete Recipe!");
            }
        });
        JButton viewRecipeButton = new JButton("View Recipes");
        viewRecipeButton.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
        		System.out.println("View Recipe!");
            }
        });
        dashboardPanel.setBackground(new Color(189, 195, 199)); // Silver
        dashboardPanel.add(suggestButton);
        dashboardPanel.add(addIngredientButton);
        dashboardPanel.add(editIngredientButton);
        dashboardPanel.add(deleteIngredientButton);
        dashboardPanel.add(viewIngredientButton);
        dashboardPanel.add(addRecipeButton);
        dashboardPanel.add(editRecipeButton);
        dashboardPanel.add(deleteRecipeButton);
        dashboardPanel.add(viewRecipeButton);

        textBox = new JTextArea(10, 30); // Create text box and button to print its content
        JButton printButton = new JButton("Print Text");
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Text in the text box: " + textBox.getText());
            }
        });
        
        JPanel textPanel = new JPanel();
        textPanel.add(textBox);
        textPanel.add(printButton);
        dashboardPanel.add(textPanel);

        // Add panels to frame
        add(signUpPanel);
        add(welcomePanel);
        add(dashboardPanel);

        // ==============================================================================
        showPanel(dashboardPanel); // ============== CHANGE PANEL HERE ==================
        // ==============================================================================

        setVisible(true);
    }

    // Method to switch between panels
    private void showPanel(JPanel panel) {
        getContentPane().removeAll(); // Remove all components from the frame
        getContentPane().add(panel); // Add the specified panel
        if (panel == welcomePanel || panel == dashboardPanel) {
        	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
        	int preferredWidth = (int) (screenSize.getWidth() * 0.8); // 80% of screen width
        	int preferredHeight = (int) (screenSize.getHeight() * 0.8); // 80% of screen height
        	setSize(new Dimension(preferredWidth, preferredHeight));

        } else {
            setSize(500, 300); // Reset the frame size when showing other panels
        }
        setLocationRelativeTo(null); // Center the frame on the screen
        revalidate(); // Revalidate the frame to reflect the changes
        repaint(); // Repaint the frame
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