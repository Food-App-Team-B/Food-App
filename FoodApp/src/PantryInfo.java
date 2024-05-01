import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class PantryInfo extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextArea txtQuant;
	private JTextField txtUnit;
	private JTextField txtName;
	private JTextField txtExDate;
	private JScrollPane scrollPane;
	private JButton btnDone;
	private User user;
	private JButton btnSubmit;

	/**
	 * Create the panel.
	 */
	public PantryInfo(User user) {
		this.user = user;
		
		initComponents();
		
		makeEvents();
		
		
		setBackground(new Color(125, 211, 115));
		
		

	}

	private void makeEvents() {
		btnDone.addActionListener(this);
		btnSubmit.addActionListener(this);
	}

	private void initComponents() {
		txtQuant = new JTextArea();
		txtQuant.setText("quant");
		
		txtUnit = new JTextField();
		txtUnit.setText("unit");
		txtUnit.setColumns(10);
		
		txtName = new JTextField();
		txtName.setText("Name");
		txtName.setColumns(10);
		
		txtExDate = new JTextField();
		txtExDate.setColumns(10);
		
		scrollPane = new JScrollPane();
		
		JCheckBox chckbxExpDate = new JCheckBox("New check box");
		
		btnDone = new JButton("Done");
		
		btnSubmit = new JButton("Submit");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(txtQuant, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSubmit)
							.addGap(34)
							.addComponent(btnDone))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtExDate, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtUnit, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(chckbxExpDate)))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUnit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtQuant, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addComponent(txtExDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSubmit)
						.addComponent(btnDone))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxExpDate)
					.addContainerGap(22, Short.MAX_VALUE))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
		);
		
		@SuppressWarnings("rawtypes")
		JList list = new JList();
		scrollPane.setViewportView(list);
		setLayout(groupLayout);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	if(e.getSource() == btnSubmit) {
		String name = txtName.getText();
		double quantity = Double.parseDouble(txtQuant.getText());
		String unit = txtUnit.getText();
		Ingredient ingredient = new Ingredient(name, quantity, unit);
		user.pantry.AddIngredient(ingredient);
		
		txtName.setText(" ");
		txtQuant.setText(" ");
		txtUnit.setText(" ");
		
	}
		
	else if(e.getSource() == btnDone) {
		getParent().add(new MainApp(user), "mainApp");
		
		CardLayout cardLayout = (CardLayout) getParent().getLayout();
		cardLayout.show(getParent(), "mainApp");
		}
	}
}
