import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainApp extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JButton btnViewPantry;
	private JButton btnNewButton_1;
	private User user;
	private JButton btnNewButton;
	private JButton load;
	private JTextArea textArea;
	private JScrollPane scrollPane;

	/**
	 * Create the panel.
	 */
	public MainApp(User user) {
		this.user = user;
		
		initComponents();
		addEvents();
	}

	private void initComponents() {
		
		btnViewPantry = new JButton("View Pantry");
		
		btnNewButton_1 = new JButton("GetRecipe");
		
		load = new JButton("load");
		
		btnNewButton = new JButton("Edit Pantry");
		
		textArea = new JTextArea();
		
		scrollPane = new JScrollPane();
		
		JList<String> list = new JList<String>();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnViewPantry)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(load)
									.addComponent(btnNewButton_1)))))
					.addGap(23)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(15)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnViewPantry)
									.addGap(7)
									.addComponent(btnNewButton)
									.addGap(9)
									.addComponent(btnNewButton_1)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(load)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}

	private void addEvents() {
		load.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == load) {
			DataPersistence dataSaver = new DataPersistence();
			dataSaver.saveData(user);
		}
		
	}
}
