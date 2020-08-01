import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StartClass implements ActionListener
{
	JFrame frame;
	
	BackGroundClass panel;
	
	JButton registerbutton, loginbutton;
	
	GridBagLayout gbl;
	GridBagConstraints gbc;

	public StartClass() {
		// TODO Auto-generated constructor stub
		frame=new JFrame();
		
		panel=new BackGroundClass();
		
		registerbutton=new JButton("Register");
		loginbutton=new JButton("Login");
		
		registerbutton.addActionListener(this);
		loginbutton.addActionListener(this);
		
		gbl=new GridBagLayout();
		gbc=new GridBagConstraints();
		
		panel.setLayout(gbl);
		
		gbc.insets=new Insets(0,0,40,0);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		//gbc.anchor=GridBagConstraints.WEST;
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(registerbutton,gbc);
		panel.add(registerbutton);
		
		gbc.gridx=0;
		gbc.gridy=10;
		gbl.setConstraints(loginbutton,gbc);
		panel.add(loginbutton);
		
		frame.add(panel);
		
		frame.setTitle("Starting page");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//frame.setBounds(0,0,screenSize.width, screenSize.height);
		frame.setSize(1320,650);
		//frame.setSize(300,300);
		frame.setVisible(true);
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StartClass ob= new StartClass();

	}

	@Override
	public void actionPerformed(ActionEvent evt) 
	{
		// TODO Auto-generated method stub
		if(evt.getSource()==registerbutton)
		{ 
			new Register();
		}
		
		else if(evt.getSource()==loginbutton)
		{
			frame.dispose();
			new admin();
		}
	}

}
