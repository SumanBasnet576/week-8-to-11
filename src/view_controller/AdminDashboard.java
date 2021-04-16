package view_controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminDashboard {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard window = new AdminDashboard();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminDashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add Network Device");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddNetworkDevices window = new AddNetworkDevices();
				window.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 22, 194, 27);
		frame.getContentPane().add(btnNewButton, BorderLayout.NORTH);
		
		JButton btnViewNetworkDevice = new JButton("View Network Device");
		btnViewNetworkDevice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewNetworkDevices window = new ViewNetworkDevices();
				window.frame.setVisible(true);
			}
		});
		btnViewNetworkDevice.setBounds(214, 22, 194, 27);
		frame.getContentPane().add(btnViewNetworkDevice);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
