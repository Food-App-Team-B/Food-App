


import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.io.File;

public class guiBeta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private loginScreen login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guiBeta frame = new guiBeta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public guiBeta() {
		
		
		CardLayout cardLayout = new CardLayout();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 401);

		contentPane = new JPanel(cardLayout);
		
		
		login = new loginScreen();
		contentPane.add(login, "login");
	
		
		add(contentPane);
		
	}


}
