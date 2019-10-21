import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUI extends JPanel{
	
	boolean runningUpdate;
	GameLogic logic;
	
	Color backgroundColor = new Color(21,122,110);
	Color cellColor = new Color (119,178,140);
	Color gridColor = new Color (73,159,104);
	
	int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	int height = Toolkit.getDefaultToolkit().getScreenSize().height;

	
	public GUI() {
		setBackground(backgroundColor);
		setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		logic = new GameLogic(width, height);
		runningUpdate = false;
		
		addMouseListener(new inputListener());
	}
	
	private class inputListener implements MouseListener{
		
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		
		public void mouseClicked(MouseEvent e) {
			if(e.getButton() == 1) {
				logic.click(e.getX(), e.getY());
				repaint();
			}
			else if(e.getButton() == 3) {
				if(runningUpdate == true) {
					runningUpdate = false;
				}
				else {
					runningUpdate = true;
				}
			}
		}
	  }
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		
	    for(int x=0;x<width;x++){
	    	for(int y=0;y<height;y++) {
	    		if(logic.board[x][y].state == 1) {
	    			page.setColor(cellColor);
	    		}else if(logic.board[x][y].state == 0){
	    			page.setColor(backgroundColor);
	    		}
	    		page.drawLine(x, y, x, y);
	    	}
	    }
	}
	
	public static void main(String[]args){
	    JFrame frame = new JFrame("Conway's Game of Life");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setMaximumSize(DimMax);

	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    frame.getContentPane().add(new GUI());
	    frame.setUndecorated(true);
	    frame.setVisible(true);  
	  }
}
