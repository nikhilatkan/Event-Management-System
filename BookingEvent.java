import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;


public class BookingEvent implements ActionListener
{
	JFrame frame;
	BackGroundClass panel, headingpanel,bookingpanel;
	
	JLabel headinglabel, eventnamelabel, venuelabel, datelabel, startlabel, endlabel, decorationlabel,descriptionlabel, pricelabel ; 
	JTextField datefield, startfield, endfield;
	JTextArea description;
	JComboBox eventnamebox , venuebox, decorationbox,pricebox;
	JScrollPane scroll;
	
	JButton submitbutton,cancelbutton;
	 
	Font labelFont, textFont,headingfont;
	 
	BorderLayout mainLayout;
	FlowLayout headingLayout;
	GridBagLayout gbl;
	GridBagConstraints gbc;
	
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	int flag=0;
	String s2;
	
	public BookingEvent(String s1) 
	{

		s2=s1;
		frame=new JFrame();
		
		panel=new BackGroundClass();
		headingpanel=new BackGroundClass();
		bookingpanel=new BackGroundClass();
		
		headinglabel=new JLabel("Event Booking");
		eventnamelabel=new JLabel("Event Name");
		venuelabel=new JLabel("Venue");
		datelabel=new JLabel("Event Date");
		startlabel=new JLabel("Start Time");
		endlabel=new JLabel("End Time");
		decorationlabel=new JLabel("Decoration Type");
		descriptionlabel=new JLabel("Description");
		pricelabel=new JLabel("Price");
		
		datefield=new JTextField(10);
		startfield=new JTextField(10);
		endfield=new JTextField(10);
		
		description=new JTextArea(3,6);
		scroll=new JScrollPane(description);
		
		
		
		eventnamebox=new JComboBox();
		venuebox=new JComboBox();
		pricebox=new JComboBox();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","nikhil1234");
			ResultSet results=con.createStatement().executeQuery("Select distinct event from event");
			
			while(results.next())
			{
				eventnamebox.addItem(results.getString("event"));
			}
			
		}
		catch(SQLException | ClassNotFoundException ee)
		{
			
		}
		
		
		String dec[]={"3-Star", "4-star", "5-Star", "VIP"};
		decorationbox=new JComboBox(dec);
		
		submitbutton=new JButton("Submit");
		cancelbutton=new JButton("cancel");
		
		submitbutton.addActionListener(this);
		
		labelFont=new Font("TIMES NEW ROMAN",Font.BOLD,30);
		textFont=new Font("Tahoma", Font.PLAIN,15);
		headingfont=new Font("Algerian", Font.BOLD , 50);
		
		mainLayout=new BorderLayout();
		headingLayout=new FlowLayout(FlowLayout.CENTER);
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		
		panel.setLayout(mainLayout);
		
		panel.add(headingpanel ,BorderLayout.NORTH);
		panel.add(bookingpanel,BorderLayout.CENTER);
		
		headingpanel.setLayout(headingLayout);
		headingpanel.add(headinglabel);
		
		bookingpanel.setLayout(gbl);
		 
		gbc.insets=new Insets(0,40,15,0);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.anchor=GridBagConstraints.WEST;
		gbc.gridx=4;
		gbc.gridy=0;
		gbl.setConstraints(eventnamelabel, gbc);
		bookingpanel.add(eventnamelabel);
		
		gbc.gridx=5;
		gbc.gridy=0;
		gbl.setConstraints(eventnamebox, gbc);
		bookingpanel.add(eventnamebox);
		
		
		gbc.gridx=4;
		gbc.gridy=1;
		gbl.setConstraints(venuelabel, gbc);
		bookingpanel.add(venuelabel);
		
		gbc.gridx=5;
		gbc.gridy=1;
		gbl.setConstraints(venuebox, gbc);
		bookingpanel.add(venuebox);
		
		gbc.gridx=4;
		gbc.gridy=2;
		gbl.setConstraints(datelabel, gbc);
		bookingpanel.add(datelabel);
		
		gbc.gridx=5;
		gbc.gridy=2;
		gbl.setConstraints(datefield, gbc);
		bookingpanel.add(datefield);
		
		gbc.gridx=4;
		gbc.gridy=3;
		gbl.setConstraints(startlabel, gbc);
		bookingpanel.add(startlabel);
		
		gbc.gridx=5;
		gbc.gridy=3;
		gbl.setConstraints(startfield, gbc);
		bookingpanel.add(startfield);
		
		
		gbc.gridx=4;
		gbc.gridy=4;
		gbl.setConstraints(endlabel, gbc);
		bookingpanel.add(endlabel);
		
		gbc.gridx=5;
		gbc.gridy=4;
		gbl.setConstraints(endfield, gbc);
		bookingpanel.add(endfield);
		
		gbc.gridx=4;
		gbc.gridy=5;
		gbl.setConstraints(decorationlabel, gbc);
		bookingpanel.add(decorationlabel);
		
		gbc.gridx=5;
		gbc.gridy=5;
		gbl.setConstraints(decorationbox, gbc);
		bookingpanel.add(decorationbox);
		
		gbc.gridx=4;
		gbc.gridy=6;
		gbl.setConstraints(descriptionlabel, gbc);
		bookingpanel.add(descriptionlabel);
		
		gbc.gridx=5;
		gbc.gridy=6;
		gbl.setConstraints(description, gbc);
		bookingpanel.add(description);
		
		gbc.gridx=4;
		gbc.gridy=7;
		gbl.setConstraints(pricelabel, gbc);
		bookingpanel.add(pricelabel);
		
		gbc.gridx=5;
		gbc.gridy=7;
		gbl.setConstraints(pricebox, gbc);
		bookingpanel.add(pricebox);
		
		gbc.gridx=4;
		gbc.gridy=8;
		gbl.setConstraints(submitbutton, gbc);
		bookingpanel.add(submitbutton);
		
		gbc.gridx=5;
		gbc.gridy=8;
		gbl.setConstraints(cancelbutton, gbc);
		bookingpanel.add(cancelbutton);
		
		eventnamebox.addActionListener(this);
		venuebox.addActionListener(this);

		headinglabel.setFont(headingfont);
		headinglabel.setForeground(Color.WHITE);
		
		eventnamelabel.setFont(labelFont);
		venuelabel.setFont(labelFont);
		datelabel.setFont(labelFont);
		startlabel.setFont(labelFont);
		endlabel.setFont(labelFont);
		decorationlabel.setFont(labelFont);
		descriptionlabel.setFont(labelFont);
		pricelabel.setFont(labelFont);
		
		frame.add(panel);
		frame.setSize(1300,750);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) 
	{
		//new BookingEvent();

	}

	@Override
	public void actionPerformed(ActionEvent evt) 
	{
		if(evt.getSource()==eventnamebox)
		{
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","nikhil1234");
				String temp=(String) eventnamebox.getSelectedItem();
				//String sql=();
				ps=con.prepareStatement("select venue from event where event=?");
				ps.setString(1,temp);
				rs=ps.executeQuery();
				
				while(rs.next())
				{
					venuebox.addItem(rs.getString("venue"));
				}
				
			}
			catch(Exception e)
			{
				
			}
		}
		else	if(evt.getSource()==venuebox)
		{
			if(flag!=0) {
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","nikhil1234");
				String temp=(String) venuebox.getSelectedItem();
				
				//String sql=();
				ps=con.prepareStatement("select price from event where venue=?");
				ps.setString(1,temp);
				//ps.setString(2,temp);
				rs=ps.executeQuery();
				
				while(rs.next())
				{
					pricebox.addItem(rs.getString("price"));
					//description.setText(rs.getString("Description"));
					
				}
			}
			catch (Exception ee)
			{
				
			}
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","nikhil1234");
				String temp=(String) venuebox.getSelectedItem();
				ps=con.prepareStatement("select description from event where venue=?");
				ps.setString(1,temp);
				//ps.setString(2,temp);
				rs=ps.executeQuery();
				
				while(rs.next())
				{
					//pricebox.addItem(rs.getString("price"));
					description.setText(rs.getString("Description"));
					
				}
			}
			catch(Exception e)
			{
				
			}
			}
			flag++;
		}
		else if(evt.getSource()==submitbutton)
		{
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event_management","root","nikhil1234");
				Statement stmt=con.createStatement();
				ps=con.prepareStatement("insert into booking values(?,?,?,?,?,?,?,?,?)");
				ps.setString(1, s2);
				ps.setString(2, eventnamebox.getSelectedItem().toString());
				ps.setString(3, venuebox.getSelectedItem().toString());
				ps.setString(4, datefield.getText());
				ps.setString(5, startfield.getText());
				ps.setString(6, endfield.getText());
				ps.setString(7, decorationbox.getSelectedItem().toString());
				ps.setString(8, description.getText());
				ps.setString(9, pricebox.getSelectedItem().toString());
				
				int i=0;
				 i=ps.executeUpdate();
				
				eventnamebox.setSelectedIndex(0);
				venuebox.setSelectedIndex(0);
				datefield.setText("");
				startfield.setText("");
				endfield.setText("");
				decorationbox.setSelectedIndex(0);
				description.setText("");
				pricebox.setSelectedIndex(0);
				
				
						
				if(i!=0)
				{
					JOptionPane.showMessageDialog(frame, "Booking is submitted to admin !! "
							+ "Soon you will be have a conformation mail.");
					
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Booking is not Submitted");
					
				}
				//ps.close();
//				eventnamebox.setSelectedIndex(0);
//				venuebox.setSelectedIndex(0);
//				datefield.setText("");
//				startfield.setText("");
//				endfield.setText("");
//				decorationbox.setSelectedIndex(0);
//				description.setText("");
//				pricebox.setSelectedIndex(0);
				con.close();
			}
			
			
			catch(Exception ee)
			{
				
			}
		}
		else if(evt.getSource()==cancelbutton)
		{
			frame.dispose();
		
			
		}
		
	}

}
