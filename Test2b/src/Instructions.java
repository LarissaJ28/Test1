import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Instructions extends JFrame{

	private JLabel game, instructions, customize, lesson;
	private JFrame frame = new JFrame();
	private JFrame frame2 = new JFrame("GAME MODE");

	private JPanel p;

	public void userGuide_mode()
	{
       String pt1 = "<html><body width='";
       String pt2 =
           "'><h1>Instructions</h1>" +
           "<p>Features " +
           "<pre>            1. The top bar : " +
           "<pre>               allows you to drag and drop the selected objects over to your simulation" +
           "<pre>            2. Once an object is in your simulation, you will be allowed to click on it " +
           "<pre>               to change the dimensions" +
           "<pre>            3. To change the position drag the object over to the desired position" +
           "<pre>            4. "+
           "<pre>               The next too bar allows you to : play the simulation, watch it in slow " +
           "<pre>               motion, watch it in fast forward motion, or reset your simulation <br>" +
           "<pre>Game Mode " +
           "<pre>            Objective : using the objects try to get the ball to the target " +
           "<pre>Lesson Mode " +
           "<pre>            Click on the different lessons to learn about the basic laws of motion" +
           "<pre>Custimized System Mode " +
           "<pre>            Create your own simulations and save it for later " ;


       JPanel p = new JPanel( new BorderLayout() );

       int width = 700;

       String s = pt1 + width + pt2 ;

  
	
       
       frame2.getContentPane().add(p);
       JOptionPane.showMessageDialog(null, s);


	}
	
	
}

