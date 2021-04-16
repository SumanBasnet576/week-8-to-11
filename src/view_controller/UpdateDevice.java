package view_controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateDevice {
	
public JFrame frame;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDevice window = new UpdateDevice(args);
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
	public UpdateDevice(String[] values) {
		initialize(values);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] values) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(238, 71, 159, 19);
		
		frame.getContentPane().add(textField);
		textField.setText(values[1]);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(238, 101, 159, 19);
		textField_1.setText(values[2]);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(238, 139, 159, 19);
		textField_2.setText(values[3]);
		frame.getContentPane().add(textField_2);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int res=DeviceDAO.update(textField.getText(), textField_1.getText(), textField_2.getText(),Integer.parseInt(values[0]));
				if(res==1) {
					ViewNetworkDevices window = new ViewNetworkDevices();
					window.frame.setVisible(true);
				}
				
				
				
				
				
				
			}
		});
		btnUpdate.setBounds(282, 201, 85, 21);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Product Type");
		lblNewLabel_1_1_1.setBounds(75, 142, 100, 13);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Product Name");
		lblNewLabel_1_1.setBounds(75, 107, 100, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Ports");
		lblNewLabel_1.setBounds(75, 74, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblUpdateNetworkDevice = new JLabel("Update Network Device");
		lblUpdateNetworkDevice.setBounds(45, 21, 146, 13);
		frame.getContentPane().add(lblUpdateNetworkDevice);
	}
}
