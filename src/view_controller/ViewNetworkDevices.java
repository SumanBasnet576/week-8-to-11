package view_controller;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import view_controller.DeviceDAO;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;

public class ViewNetworkDevices {

	public JFrame frame;
	public ResultSet listofdevices;
	  ResultSet res;
	  private JPanel contentPane;
	  ResultSet rs;
		
	 
	  //static ViewNetworkDevicesDAO dao;
	  private JTable table;
	  private JScrollPane scrollPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewNetworkDevices window = new ViewNetworkDevices();
					window.frame.setVisible(true);
					//dao=new ViewNetworkDevicesDAO();
					
			
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
		
	public ViewNetworkDevices() {
		try {
			initialize();
		}
catch(Exception ex) {
	ex.printStackTrace();
}
	
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		String data[][]=null;
		String column[]=null;
		try{
			Connection con=Driver.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from device",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=ps.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int cols=rsmd.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++){
				column[i-1]=rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();

			data=new String[rows][cols];
			int count=0;
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		
		table = new JTable(data,column);
		table.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount() == 1) {
			      JTable target = (JTable)e.getSource();
			      int row = target.getSelectedRow();
			      int column = target.getSelectedColumn();
			     String[] names;
			 try {
			
			String[] values=getRowAt(row);
		
			UpdateDevice window = new UpdateDevice(values);
			
			window.frame.setVisible(true);
			
			
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			    }
			  }
			});
		JScrollPane sp=new JScrollPane(table);
		
		contentPane.add(sp, BorderLayout.CENTER);
	
	
		
	
		
	}
	
	public String[] getRowAt(int row) {
	     String[] result = new String[5];

	     for (int i = 0; i <table.getRowCount() ; i++) {
	        if(row==i) {
	        	
	        	 result[0] = (String) table.getModel().getValueAt(row, 0);
	        	 result[1] = (String) table.getModel().getValueAt(row, 1);
	        	 result[2] = (String) table.getModel().getValueAt(row, 2);
	        	 result[3] = (String) table.getModel().getValueAt(row, 3);
	        	 
	        }
	     }

	     return result;
	}

}
