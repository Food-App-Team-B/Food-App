import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginScreen extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JLabel lblUsername;
	private JPanel pnllogin;
	private JTextField txtUsername;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JTextField txtPassword;
	private JLabel lblNewLabel;
	private JButton btnSubmit;
	private User user;

	/**
	 * Create the panel.
	 */
	public loginScreen() {
		initComponents();
		createEvents();
		
		
	}

	private void createEvents() {
		
		btnSubmit.addActionListener(this);
		
	}

	private void initComponents() {
		
		setBackground(new Color(120, 189, 105));
		
		pnllogin = new JPanel();
		pnllogin.setBackground(new Color(168, 213, 168));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(124, Short.MAX_VALUE)
					.addComponent(pnllogin, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addGap(132))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(pnllogin, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		
		lblUsername = new JLabel("Username");
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		
		lblEmail = new JLabel("Email");
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		lblNewLabel = new JLabel("Password");
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		GroupLayout gl_pnllogin = new GroupLayout(pnllogin);
		gl_pnllogin.setHorizontalGroup(
			gl_pnllogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnllogin.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_pnllogin.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(txtPassword, Alignment.LEADING)
						.addComponent(lblNewLabel, Alignment.LEADING)
						.addComponent(lblEmail, Alignment.LEADING)
						.addComponent(lblUsername, Alignment.LEADING)
						.addComponent(txtUsername, Alignment.LEADING)
						.addComponent(txtEmail, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
					.addContainerGap(33, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_pnllogin.createSequentialGroup()
					.addContainerGap(142, Short.MAX_VALUE)
					.addComponent(btnSubmit)
					.addContainerGap())
		);
		gl_pnllogin.setVerticalGroup(
			gl_pnllogin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnllogin.createSequentialGroup()
					.addGap(72)
					.addComponent(lblUsername)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEmail)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSubmit)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		pnllogin.setLayout(gl_pnllogin);
		setLayout(groupLayout);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String email = txtEmail.getText();
		String username = txtUsername.getText();
		String password = txtPassword.getText();
		
		user = new User(email, username, password);
		
		getParent().add(new PantryInfo(user), "pantryScreen");
		
		CardLayout cardLayout = (CardLayout) getParent().getLayout();
		cardLayout.show(getParent(), "pantryScreen");
		
	}
}
