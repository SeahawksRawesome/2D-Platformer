import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer time;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = GAME_STATE;
	Stickman player = new Stickman(250, 100, 44, 80, this);
	Orb orbThing = new Orb(720,290,20,20);
	// Enemy knight = new Enemy(250, 100, 44, 80);
	int bottom = 670;
	ObjectManager manage = new ObjectManager();
	public static BufferedImage ninjaImg;
	public static BufferedImage ninjarunningImg;

	GamePanel() {
		time = new Timer(1000 / 60, this);
		player.bottom = bottom;
		manage.addObject(player);
		manage.addObject(new Platform(300, 500, 100, 20));
		manage.addObject(new Platform(400, 600, 100, 20));
		manage.addObject(new Platform(700, 300, 100, 20));
		manage.addObject(new Platform(550, 400, 100, 20));
		manage.addObject(new Enemy(400, 630, 66, 120));
		manage.addObject(orbThing);
		
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
		manage.update();
		if (manage.checkCollision()) {
			player.bottom = manage.platformOffset;
		} else {
			player.bottom = bottom;
		}
		if (player.feetBox.intersects (orbThing.orbBox)) {
			orbThing.isAlive = false;
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		// Do pt. 6 later, not now.
	}

	void drawGameState(Graphics g) {
		manage.draw(g);
		g.setColor(new Color(139, 69, 19));
		g.fillRect(0, 830, 2000, 900);
		g.setColor(Color.green);
		g.fillRect(0, 750, 2000, 80);

	}

	void drawEndState(Graphics g) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// System.out.println("Hi");

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// System.out.println("Hi");
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.Leftkey = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.Rightkey = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			player.jump();
		}
		if( e.getKeyCode() == KeyEvent.VK_SHIFT){
				player.speed = 10;
		}
		if( e.getKeyCode() == KeyEvent.VK_DOWN){
			player.Downkey = true;
	}
		if( e.getKeyCode() == KeyEvent.VK_UP){
			player.Upkey = true;
	}
		if( e.getKeyCode() == KeyEvent.VK_R){
			manage.addObject(new Enemy(400, 630, 66, 120));
	}
		if( e.getKeyCode() == KeyEvent.VK_E){
			manage.addObject(player);
	}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Hi");
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.Rightkey = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.Leftkey = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_SHIFT){
			player.speed = 5;
		}
		if( e.getKeyCode() == KeyEvent.VK_DOWN){
			player.Downkey = false;
	}
		if( e.getKeyCode() == KeyEvent.VK_UP){
			player.Upkey = false;
	}

	}

}
