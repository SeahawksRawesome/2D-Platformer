import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Stickman_Platformer {
	JFrame f1;
	JButton b1;
	JButton b2;
	JLabel l1;

	// Final ints for game, not menu. Don't use for menu.
	static final int Height = 1000;
	static final int Width = 2000;
	GamePanel panel;

	public static void main(String[] args) {
		Stickman_Platformer m = new Stickman_Platformer();

	}

	Stickman_Platformer() {
		f1 = new JFrame();
		panel = new GamePanel();
		l1 = new JLabel();
		panel.add(l1);
		
		setup();
		// panel.setPreferredSize(new Dimension(500, 500));
	}

	void setup() {

		f1.setVisible(true);
		f1.add(panel);
		f1.addKeyListener(panel);
		panel.startGame();
		f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
		f1.setSize(Width, Height);
		l1.setVisible(true);
	
		//l1.setText("visible");
	}

}
