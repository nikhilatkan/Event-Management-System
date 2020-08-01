import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class Register implements ActionListener 
{
	JFrame frame;
	BackGroundClass panel, headingpanel,buttonpanel;
	
	JPanel formpanel;
	JLabel headinglabel,namelabel,usernamelabel,passwordlabel, confirmpasswordlabel, addresslabel,citylabel, statelabel, contactlabel;
	
	JTextField namefield, usernamefield, addressfield, contactfield;
	JPasswordField passwordfield, confirmpasswordfield;
	JComboBox city, state;
	JButton submitbutton,cancelbutton;
	Font labelfont,headingfont;
	

	BorderLayout mainLayout;
	FlowLayout headingLayout;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	Connection con=null;
	PreparedStatement ps=null;

	public Register() {
		// TODO Auto-generated constructor stub
		frame=new JFrame("Registration Form !");
		
		panel=new BackGroundClass();
		
		headingpanel=new BackGroundClass();
		formpanel=new JPanel();
		buttonpanel=new BackGroundClass();
		
		headinglabel=new JLabel("Registration");
		namelabel=new JLabel("Name");
		usernamelabel=new JLabel("Username");
		passwordlabel=new JLabel("Password");
		confirmpasswordlabel=new JLabel("Confirm Password");
		addresslabel=new JLabel("Address");
		citylabel=new JLabel("City");
		statelabel=new JLabel("State");
		contactlabel=new JLabel("Contact");
		
		namefield=new JTextField(15);
		usernamefield=new JTextField(15);
		addressfield=new JTextField(15);
		contactfield=new JTextField(15);
		
		String cities[]= {"Select City", "Karnal","Panipat"};
		city=new JComboBox(cities);
		String States[]= {"Select State","Haryana","Punjab"};
		state=new JComboBox(States);
		
		passwordfield=new JPasswordField();
		confirmpasswordfield=new JPasswordField();
		
		submitbutton=new JButton("Submit");
		cancelbutton=new JButton("Cancel");
		
		submitbutton.addActionListener(this);
		cancelbutton.addActionListener(this);
		
		labelfont=new Font("AR BLANCA",Font.BOLD,20);
		headingfont=new Font("Times New Roman",Font.BOLD,80);
		
		mainLayout=new BorderLayout();
		headingLayout=new FlowLayout(FlowLayout.CENTER);
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		
		panel.setLayout(mainLayout);
		
		panel.add(headingpanel,BorderLayout.NORTH);
		panel.add(formpanel,BorderLayout.EAST);
		panel.add(buttonpanel,BorderLayout.SOUTH);
		
		headingpanel.setLayout(headingLayout);
		headingpanel.add(headinglabel);
		
		formpanel.setLayout(gbl);
		 
		gbc.insets=new Insets(0,15,15,0);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.anchor=GridBagConstraints.WEST;
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(namelabel, gbc);
		formpanel.add(namelabel);
		
		gbc.gridx=1;
		gbc.gridy=0;
		gbl.setConstraints(namefield, gbc);
		formpanel.add(namefield);
		
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbl.setConstraints(usernamelabel, gbc);
		formpanel.add(usernamelabel);
		
		gbc.gridx=1;
		gbc.gridy=1;
		gbl.setConstraints(usernamefield, gbc);
		formpanel.add(usernamefield);
		
		gbc.gridx=0;
		gbc.gridy=2;
		gbl.setConstraints(passwordlabel, gbc);
		formpanel.add(passwordlabel);
		
		gbc.gridx=1;
		gbc.gridy=2;
		gbl.setConstraints(passwordfield, gbc);
		formpanel.add(passwordfield);
		
		gbc.gridx=0;
		gbc.gridy=3;
		gbl.setConstraints(confirmpasswordlabel, gbc);
		formpanel.add(confirmpasswordlabel);
		
		gbc.gridx=1;
		gbc.gridy=3;
		gbl.setConstraints(confirmpasswordfield, gbc);
		formpanel.add(confirmpasswordfield);
		
		gbc.gridx=0;
		gbc.gridy=4;
		gbl.setConstraints(addresslabel, gbc);
		formpanel.add(addresslabel);
		
		gbc.gridx=1;
		gbc.gridy=4;
		gbl.setConstraints(addressfield, gbc);
		formpanel.add(addressfield);
		
		gbc.gridx=0;
		gbc.gridy=5;
		gbl.setConstraints(statelabel, gbc);
		formpanel.add(statelabel);
		
		gbc.gridx=1;
		gbc.gridy=5;
		gbl.setConstraints(state, gbc);
		formpanel.add(state);
		
		gbc.gridx=0;
		gbc.gridy=6;
		gbl.setConstraints(citylabel, gbc);
		formpanel.add(citylabel);
		
		gbc.gridx=1;
		gbc.gridy=6;
		gbl.setConstraints(city, gbc);
		formpanel.add(city);
		
		gbc.gridx=0;
		gbc.gridy=7;
		gbl.setConstraints(contactlabel, gbc);
		formpanel.add(contactlabel);
		
		gbc.gridx=1;
		gbc.gridy=7;
		gbl.setConstraints(contactfield, gbc);
		formpanel.add(contactfield);
		
		gbc.gridx=0;
		gbc.gridy=8;
		gbl.setConstraints(submitbutton, gbc);
		formpanel.add(submitbutton);
		
		gbc.gridx=1;
		gbc.gridy=8;
		gbl.setConstraints(cancelbutton, gbc);
		formpanel.add(cancelbutton);
		
		//buttonpanel.add(submitbutton);
		//buttonpanel.add(cancelbutton);
		
		headinglabel.setFont(headingfont);
		namelabel.setFont(labelfont);
		usernamelabel.setFont(labelfont);
		namelabel.setFont(labelfont);
		passwordlabel.setFont(labelfont);
		confirmpasswordlabel.setFont(labelfont);
		addresslabel.setFont(labelfont);
		statelabel.setFont(labelfont);
		citylabel.setFont(labelfont);
		contactlabel.setFont(labelfont);

		
		
		
		frame.add(panel);
		frame.setSize(1300,750);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Register();
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		if(evt.getSource()==submitbutton)
		{
			try 
			{
				if (namefield.getText().equals("")||usernamefield.getText().equals("")||passwordfield.getText().equals("")||confirmpasswordfield.getText().equals("")||contactfield.getText().equals("")||addressfield.getText().equals(""))	
				{
					JOptionPane.showMessageDialog(frame, "cannot be empty");
				}
				else
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","nikhil1234");
					Statement stmt=con.createStatement();
					ps=con.prepareStatement("insert into register values(?,?,?,?,?,?,?,?)");
					ps.setString(1, namefield.getText());
					ps.setString(2, usernamefield.getText());
					ps.setString(3, passwordfield.getText());
					ps.setString(4, confirmpasswordfield.getText());
					ps.setString(5, addressfield.getText());
					ps.setString(6, state.getSelectedItem().toString());
					ps.setString(7, city.getSelectedItem().toString());
					ps.setString(8,contactfield.getText());
					
					
					namefield.setText("");
					usernamefield.setText("");
					passwordfield.setText("");
					confirmpasswordfield.setText("");
					addressfield.setText("");
					city.setSelectedIndex(0);;
					state.setSelectedIndex(0);
					contactfield.setText("");
					int i=ps.executeUpdate();
					
//					namefield.setText("");
//					usernamefield.setText("");
//					passwordfield.setText("");
//					confirmpasswordfield.setText("");
//					addressfield.setText("");
//					city.setSelectedIndex(0);;
//					state.setSelectedIndex(0);
//					contactfield.setText("");
					
					//ps.executeQery();
					if(i>0)
					{
						JOptionPane.showMessageDialog(frame,"Registration Successful");
					}
					else
					{
						JOptionPane.showMessageDialog(frame,"problem in server");
					}
					ps.close();
				}
				
				con.close();
			}
			catch(Exception ee) 
			{
				
			}
//			try
//			{
//				Class.forName("com.mysql.cj.jdbc.Driver");
//				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","vinay123");
//				Statement stmt=con.createStatement();
//				ps=con.prepareStatement("insert into booking values(?,'','')");
//				//ps.setString(1, namefield.getText());
//				ps.setString(1, usernamefield.getText());
//				//System.out.println("chla");
//	
//								
//
//				ps.executeUpdate();
//				System.out.println("chla");
//				ps.close();
//				con.close();
//			}
//			catch(Exception ee)
//			{
//				
//			}
//			
//			
	}
		else if(evt.getSource()==cancelbutton)
		{
			frame.dispose();
			new StartClass();
		}
		
	}

}
