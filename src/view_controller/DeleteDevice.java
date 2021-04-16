package view_controller;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteDevice {

	private JFrame frame;
	ResultSet rs;
	JComboBox comboBox ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteDevice window = new DeleteDevice();
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
	public DeleteDevice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Connection con=Driver.getConnection();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Device");
		lblNewLabel.setBounds(10, 10, 94, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter id of device");
		lblNewLabel_1.setBounds(59, 101, 99, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		String data[][]=null;
		String column[]=null;
		try{
			
			PreparedStatement ps=con.prepareStatement("select * from device",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=ps.executeQuery();
			List<String> dataTaskIDAdmin = new ArrayList<>(100);

			try{

			    while(rs.next()){

			        dataTaskIDAdmin.add(rs.getString("product_name"));

			    }

			}catch(Exception e){

			    e.printStackTrace();

			}

			comboBox= new JComboBox(dataTaskIDAdmin.toArray(new String[dataTaskIDAdmin.size()]));
			comboBox.setBounds(192, 108, 99, 21);
			frame.getContentPane().add(comboBox);
		
			
		}catch(Exception e){System.out.println(e);}
		
		
		
		
	
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rs2=0;
				  int id = 0;
				  PreparedStatement ps;
				int i=comboBox.getSelectedIndex()	;
				try{

				    while(rs.next()){


				    }

				}catch(Exception e1){

				    e1.printStackTrace();

				}
			
				
				
			}
		});
		btnNewButton.setBounds(264, 182, 85, 21);
		frame.getContentPane().add(btnNewButton);
		

	}
}
