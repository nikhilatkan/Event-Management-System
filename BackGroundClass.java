import java.awt.*;
import javax.swing.*;

public class BackGroundClass extends JPanel
{
	ImageIcon image;
	
	public BackGroundClass() {
		// TODO Auto-generated constructor stub
		super();
		image=new ImageIcon("Event-Management.jpg");
	}

	protected void paintComponent(Graphics g) 
	{
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(image.getImage(),0,0,1300,750,null);
		
		

	}

}
