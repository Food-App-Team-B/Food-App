package Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PantryPanel {

    public JPanel PantryPanel(){
        var dashboardPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
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
                // Create a popup window for adding ingredients
                JFrame popup = new JFrame("Add Ingredient");
                popup.setLayout(new GridLayout(4, 2, 5, 5));

                JTextField nameField = new JTextField();
                JTextField quantityField = new JTextField();
                JTextField expirationField = new JTextField("yyyy-MM-dd"); // Set placeholder text

                expirationField.setForeground(Color.GRAY); // Set text color to gray
                expirationField.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        // Clear placeholder text when the field gains focus
                        if (expirationField.getText().equals("yyyy-MM-dd")) {
                            expirationField.setText("");
                            expirationField.setForeground(Color.BLACK); // Change text color to black
                        }
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        // Restore placeholder text if the field is left empty
                        if (expirationField.getText().isEmpty()) {
                            expirationField.setText("yyyy-MM-dd");
                            expirationField.setForeground(Color.GRAY); // Change text color back to gray
                        }
                    }
                });

                popup.add(new JLabel("Name:"));
                popup.add(nameField);
                popup.add(new JLabel("Quantity:"));
                popup.add(quantityField);
                popup.add(new JLabel("Expiration Date:"));
                popup.add(expirationField);

                JButton addButton = new JButton("Add");
                addButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Retrieve input values and process them
                        String name = nameField.getText();
                        String quantity = quantityField.getText();
                        String expirationDate = expirationField.getText();

                        // Process the ingredient data (e.g., store it, display it)
                        System.out.println("Name: " + name);
                        System.out.println("Quantity: " + quantity);
                        System.out.println("Expiration Date: " + expirationDate);

                        // Close the popup window after processing
                        popup.dispose();
                    }
                });
                popup.add(addButton);

                popup.setSize(300, 150);
                popup.setLocationRelativeTo(null);
                popup.setVisible(true);
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

        var textBox = new JTextArea(10, 30); // Create text box and button to print its content
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

        return dashboardPanel;
    }
}
