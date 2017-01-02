import java.awt.Dimension;

import javax.swing.JFrame;

public class Stickman_Platformer {
	JFrame f1;
	
	//Final ints for game, not menu. Don't use for menu.
	final int Height = 500;
	final int Width = 800;
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
		
		f1.setSize(500, 500);
		f1.setVisible(true);
		f1.add(panel);
		panel.startGame();
		f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
	}
}
