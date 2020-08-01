import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class admin implements ActionListener 
{
	JFrame frame;
	
	BackGroundClass panel;
	
	JButton Adminbutton, Userbutton;
	
	GridBagLayout gbl;
	GridBagConstraints gbc;

	public admin() 
	{
		frame=new JFrame();
		
		panel=new BackGroundClass();
		
		Adminbutton=new JButton("Admin");
		Userbutton=new JButton("User");
		
		Adminbutton.addActionListener(this);
		Userbutton.addActionListener(this);
		
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		
		panel.setLayout(gbl);
		
		gbc.insets=new Insets(0,0,40,0);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		//gbc.anchor=GridBagConstraints.WEST;
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(Adminbutton,gbc);
		panel.add(Adminbutton);
		
		gbc.gridx=0;
		gbc.gridy=10;
		gbl.setConstraints(Userbutton,gbc);
		panel.add(Userbutton);
		
		frame.add(panel);
		
		frame.setTitle("Admin page");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(0,0,screenSize.width, screenSize.height);
		//frame.setSize(300,300);
		frame.setVisible(true);
		
		
	}

	public static void main(String[] args) 
	{
		new admin();

	}

	public void actionPerformed(ActionEvent evt)
	{
		if(evt.getSource()==Adminbutton)
		{ 
			new AdminLogin();
		}
		
		else if(evt.getSource()==Userbutton)
		{
			frame.dispose();
			new Loginpage();
		}
		
	}

}
