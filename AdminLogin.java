import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class AdminLogin implements ActionListener
	{
	JFrame frame;
	BackGroundClass panel;
	JPanel headingpanel, centerpanel;
	JLabel welcomelabel,adminlabel ,passwordlabel ;
	JTextField usernamefield;
	JPasswordField passwordfield;
	JButton submitbutton,cancelbutton;
	Connection con=null;
	PreparedStatement ps=null;
	
	Font labelfont,headingfont;
	
	BorderLayout mainLayout;
	FlowLayout headingLayout;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	int count=0;
	

	public AdminLogin() 
	{
		frame=new JFrame();
		panel=new BackGroundClass();
		headingpanel=new JPanel();
		centerpanel=new JPanel();
		
		welcomelabel=new JLabel("Welcome Admin");
		adminlabel=new JLabel("Admin Username");
		passwordlabel=new JLabel("Password");
		
		usernamefield=new JTextField(10);
		passwordfield=new JPasswordField(10);
		
		submitbutton=new JButton("Submit");
		cancelbutton=new JButton("cancel");
		
		labelfont=new Font("Tahoma", Font.BOLD, 50);
		headingfont=new Font("Times New Roman",Font.BOLD,60);
		
		mainLayout=new BorderLayout();
		headingLayout=new FlowLayout(FlowLayout.CENTER);
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		
		panel.setLayout(mainLayout);
		
		panel.add(headingpanel,BorderLayout.NORTH);
		panel.add(centerpanel,BorderLayout.CENTER);
		
		headingpanel.setLayout(headingLayout);
		headingpanel.add(welcomelabel);
		
		centerpanel.setLayout(gbl);
		
		gbc.insets=new Insets(8,8,8,0);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.anchor=GridBagConstraints.EAST;
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(adminlabel, gbc);
		centerpanel.add(adminlabel);
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbl.setConstraints(usernamefield, gbc);
		centerpanel.add(usernamefield);
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbl.setConstraints(passwordlabel, gbc);
		centerpanel.add(passwordlabel);
		
		gbc.gridx=1;
		gbc.gridy=1;
		gbl.setConstraints(passwordfield, gbc);
		centerpanel.add(passwordfield);

		
		gbc.gridx=0;
		gbc.gridy=2;
		gbl.setConstraints(submitbutton, gbc);
		centerpanel.add(submitbutton);

		gbc.gridx=1;
		gbc.gridy=2;
		gbl.setConstraints(cancelbutton, gbc);
		centerpanel.add(cancelbutton);
		
		submitbutton.addActionListener(this);
		cancelbutton.addActionListener(this);
		
		
		//adminlabel.setFont(labelfont);
		adminlabel.setForeground(Color.BLACK);
		welcomelabel.setFont(headingfont);
		
		
		frame.add(panel);
		frame.setSize(1320,650);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) 
	{
		new AdminLogin();

	}

	@Override
	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==submitbutton)
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","nikhil1234");
				ResultSet results=con.createStatement().executeQuery("Select username,password from register");
				
				
				while(results.next())
				{
//					System.out.println("results="+results.getString("username"));
//					System.out.println("results="+results.getString("password"));
					
					if((usernamefield.getText().equals(results.getString("username")))&& (passwordfield.getText().equals(results.getString("password"))))
					{
						count++;	
						
						 System.out.println(""+count);
						 break;
					}
					
				}
				
				if (count!=0)
				{
					JOptionPane.showMessageDialog(frame,"Admin Access are granted");
				}
				else
				{
					JOptionPane.showMessageDialog(frame,"Admin Details are wrong");
					
				}
				
				
				
			usernamefield.setText("");
			passwordfield.setText("");
			results.close();
			}
			catch (Exception ee)
			{
				
			}
		
			
			
			
			
		}
		
		if(evt.getSource()==cancelbutton)
		{
			frame.dispose();
			new admin();
		}
	}

}
