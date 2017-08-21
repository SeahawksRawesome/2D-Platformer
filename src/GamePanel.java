import java.awt.Color;
import java.awt.Font;
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
	 static int Lvl_1 = 1;
	// static int Lvl_2 = 2;
	final int END_STATE = 3;
	final int WIN_STATE = 4;
	static int currentState = 1;
	Ninja player = new Ninja(250, 100, 44, 80, this);
	//Ninja player1 = new Ninja(250, 100, 44, 80, this);
	Orb orbThing = new Orb(720,280,20,20);
	// Enemy knight = new Enemy(250, 100, 44, 80);
	int bottom = 670;
	ObjectManager manage = new ObjectManager();
	public static BufferedImage ninjaImg;
	public static BufferedImage ninjarunningImg;
	Font gameFont;
	Font titleFont;
	static boolean victory = false;
	

	GamePanel() {
		time = new Timer(1000 / 60, this);
		player.bottom = bottom;
		manage.addObject(player);
		manage.setPlayer(player);
		manage.addObject(new Platform(300, 500, 100, 20));
		manage.addObject(new Platform(400, 600, 100, 20));
		manage.addObject(new Platform(700, 300, 100, 20));
		manage.addObject(new Platform(550, 400, 100, 20));
		manage.addObject(new Enemy(400, 630, 66, 120));
		manage.addObject(orbThing);
		manage.addObject(new Flag(1700,570, 90, 180));
		gameFont = new Font("Arial",Font.PLAIN,50 );
		titleFont = new Font("Arial",Font.PLAIN,120 );
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		repaint();
		
		// Change to Menu state later.
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == Lvl_1) {
			updateGameState();
		} 	
			
		 else if (currentState == END_STATE) {
			updateEndState();
	
		}
		 else if (currentState == WIN_STATE){
			 updateWinState();
		 }
	}

	void startGame() {
		time.start();
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == Lvl_1) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		} else if (currentState == WIN_STATE) {
			drawWinState(g);
		}
	}

	void updateMenuState() {

	}

	void updateGameState() {
		manage.update();
		manage.checkCollision();

		
		if (manage.checkCollision()) {
			player.bottom = manage.platformOffset;
		} else {
			player.bottom = bottom;
		}
		if (player.feetBox.intersects (orbThing.orbBox)) {
			orbThing.isAlive = false;
			player.orbPoints = 1;
		}
		if (!player.isAlive ) {
			currentState = END_STATE;
			manage.reset();
			player = new Ninja(250, 100, 44, 80, this);
			manage.addObject(player);
			orbThing = new Orb(720,280,20,20);
			drawReset();
			
		}
		if(victory == true){
			currentState = 4;
			manage.reset();
			player = new Ninja(250, 100, 44, 80, this);
			manage.addObject(player);
			orbThing = new Orb(720,280,20,20);
			drawReset();
			victory = false;
			
		}
	
	}
	
	void updateEndState() {

	}
	void updateWinState() {

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
		g.setColor(Color.red);
		g.fillRect(0, 0, 4000, 2000);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("GAME OVER MAN!", 400, 500);
		g.setFont(gameFont);
		g.drawString("Press ENTER to play again", 600, 600);
	}
	void drawWinState(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, 4000, 2000);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Victory! You Won!", 400, 500);
		g.setFont(gameFont);
		g.drawString("Press ENTER to play again", 600, 600);
	}
	
	void drawReset(){
		manage.addObject(new Platform(300, 500, 100, 20));
		manage.addObject(new Platform(400, 600, 100, 20));
		manage.addObject(new Platform(700, 300, 100, 20));
		manage.addObject(new Platform(550, 400, 100, 20));
		manage.addObject(new Enemy(400, 630, 66, 120));
		manage.addObject(orbThing);
		manage.addObject(new Flag(1700,570, 90, 180));
		gameFont = new Font("Arial",Font.PLAIN,50 );
		titleFont = new Font("Arial",Font.PLAIN,120 );
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
			//player1.Leftkey = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.Rightkey = true;
		//	player1.Rightkey = true;
			
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			player.jump();
		}
		if( e.getKeyCode() == KeyEvent.VK_SHIFT){
				player.speed = 10;
		}
		if( e.getKeyCode() == KeyEvent.VK_DOWN){
			player.Downkey = true;
		//	player1.Downkey = true;
	}
		if( e.getKeyCode() == KeyEvent.VK_UP){
			player.Upkey = true;
	}
		if( e.getKeyCode() == KeyEvent.VK_R){
			manage.addObject(new Enemy(400, 630, 66, 120));
	}
	
		if(e.getKeyCode() == KeyEvent.VK_ENTER && currentState == 3 || e.getKeyCode() == KeyEvent.VK_ENTER && currentState == 4){
			currentState = Lvl_1;
			System.out.println("ITIDIIDIIDIDIDIIDIDIDID");
			
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
