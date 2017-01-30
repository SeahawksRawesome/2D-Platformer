import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer time;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = GAME_STATE;
	stickman player = new stickman(250, 100, 50, 50);
	Platform platform = new Platform(300, 500, 100, 20);
	

	GamePanel() {
		time = new Timer(1000 / 60, this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		repaint();
		// Change to Menu state later.
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

	}

	void startGame() {
		time.start();
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	void updateMenuState() {

	}

	void updateGameState() {
		player.update();
		platform.update();
		if(player.CollisionBox.intersects(platform.CollisionBox)){
			
		}
	
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		// Do pt. 6 later, not now.
	}

	void drawGameState(Graphics g) {
		player.draw(g);
		platform.draw(g);
		
	}

	void drawEndState(Graphics g) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("Hi");

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Hi");
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			player.Leftkey = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			player.Rightkey = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			player.jump();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Hi");
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			player.Rightkey = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			player.Leftkey = false;
		}
		
	}

}
