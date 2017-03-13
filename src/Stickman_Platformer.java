import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Stickman_Platformer  {
	JFrame f1;
	JButton b1;
	JButton b2;
	
	//Final ints for game, not menu. Don't use for menu.
	final int Height = 1000;
	final int Width = 2000;
	GamePanel panel; 
	public static void main(String[] args) {
	Stickman_Platformer	m = new Stickman_Platformer();
	
	}
	Stickman_Platformer(){
		f1 = new JFrame();
		panel = new GamePanel();
		setup();
		//panel.setPreferredSize(new Dimension(500, 500));
	}
	void setup(){
		
		
		f1.setVisible(true);
		f1.add(panel);
		f1.addKeyListener(panel);
		panel.startGame();
		f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
		f1.setSize(Width, Height);
	}
	
	
}
