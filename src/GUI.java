import java.util.*;
import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel{
	
	public GUI() {

	}
	
	public static void main(String[]args){
	    JFrame frame = new JFrame("Game of Life");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setMaximumSize(DimMax);
	    //frame.setPreferredSize(new Dimension(300,300));

	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    //frame.getContentPane().add(new TicTacPanel());
	    frame.pack();
	    frame.setVisible(true);  
	    
	  }
}
