import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class Loginpage implements ActionListener{
	JFrame frame;
	BackGroundClass panel;
	JLabel usernamelabel,passwordlabel;
	JTextField usernamefield;
	JPasswordField passwordfield;
	JButton submitbutton,cancelbutton;
	Connection con=null;
	PreparedStatement ps=null;
	String user1;
	int count=0;
	
	
	GridBagLayout gbl;
	GridBagConstraints gbc;

	public Loginpage() {
		// TODO Auto-generated constructor stub
		frame=new JFrame("LoginPage");
		
		panel=new BackGroundClass();
		
		usernamelabel=new JLabel("Username");
		passwordlabel=new JLabel("Password");
		
		usernamefield=new JTextField(15);
		passwordfield=new JPasswordField(15);
		
		submitbutton=new JButton("Submit");
		cancelbutton=new JButton("Cancel");
		
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		
		panel.setLayout(gbl);
		
		gbc.insets=new Insets(8,8,8,0);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.anchor=GridBagConstraints.EAST;
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(usernamelabel, gbc);
		panel.add(usernamelabel);
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbl.setConstraints(usernamefield, gbc);
		panel.add(usernamefield);
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbl.setConstraints(passwordlabel, gbc);
		panel.add(passwordlabel);
		
		gbc.gridx=1;
		gbc.gridy=1;
		gbl.setConstraints(passwordfield, gbc);
		panel.add(passwordfield);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbl.setConstraints(submitbutton, gbc);
		panel.add(submitbutton);

		gbc.gridx=1;
		gbc.gridy=2;
		gbl.setConstraints(cancelbutton, gbc);
		panel.add(cancelbutton);
		
		submitbutton.addActionListener(this);
		cancelbutton.addActionListener(this);
		
		usernamelabel.setForeground(Color.BLACK);
		passwordlabel.setForeground(Color.BLACK);
		
		
		frame.add(panel);
		frame.setSize(1320,650);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Loginpage();

	}

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
						count=1;
						 
						// System.out.println("1");
						 
					}
					
				}
				
				if (count==1)
				{
					user1=usernamefield.getText();
					JOptionPane.showMessageDialog(frame,"Login success");
					new BookingEvent(user1);
				
				}
				else
				{
					JOptionPane.showMessageDialog(frame,"Wrong Credentials");
					
				}
				
				results.close();
				
			
			}
			catch (Exception ee)
			{
				
			}
		}
		else if(evt.getSource()==cancelbutton)
		{
			frame.dispose();
		}
		
	}

}
