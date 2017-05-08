import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Stickman extends GameObject {
	public static BufferedImage ninjaImg;
	public static BufferedImage ninjaImgRight;
	public static BufferedImage ninjaImgLeft;
	public static ImageIcon ninjaRunningRightImg;
	public static ImageIcon ninjaRunningLeftImg;
	int speed;
	boolean Rightkey;
	boolean Leftkey;
	boolean Spacekey;
	int bottom = 700;
	final int gravity = 1;
	int velocity = 0;
	int jumppower = 20;
	boolean doublejump = true;
	int whichImg;
	GamePanel panel;

	Stickman(int x, int y, int width, int height, GamePanel gamePanel) {
		super();
		panel = gamePanel;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 5;
		collisionBox = new Rectangle(x, y, width, height);
		feetBox = new Rectangle(x, y, width, height);
		try {
			ninjaImgRight = ImageIO.read(this.getClass().getResourceAsStream("Ninja Idle.png"));
			ninjaImgLeft = ImageIO.read(this.getClass().getResourceAsStream("NinjaImgLeft.png"));
			ninjaRunningRightImg = new ImageIcon(this.getClass().getResource("Ninja Running.gif"));
			ninjaRunningLeftImg = new ImageIcon(this.getClass().getResource("Ninja Running Left.gif"));
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void update() {
		super.update();
		if (Rightkey) {
			x += speed;
			ninjaImg = ninjaImgRight;
		}
		if (Leftkey) {
			x -= speed;
			ninjaImg = ninjaImgLeft;
		}
		velocity += gravity;
		y += velocity;
		if (y >= bottom) {
			y = bottom;
			velocity = 0;
		}
		// collisionBox.setBounds(x, y, width, height);
		feetBox.setBounds(x + 11, y + 70, width - 24, height - 70);
	}

	void draw(Graphics g) {
		// g.setColor(Color.WHITE);
		// g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width,
		// collisionBox.height);
		g.setColor(Color.BLACK);
		g.drawRect(feetBox.x, feetBox.y, feetBox.width, feetBox.height);
		if (Rightkey) {
			ninjaRunningRightImg.paintIcon(panel, g, x, y);
		} else if (Leftkey) {
			ninjaRunningLeftImg.paintIcon(panel, g, x, y);
		} else {
			g.drawImage(ninjaImg, x, y, width, height, null);
		}
	}

	public void jump() {
		// its opposite. so if false, true. if true, false
		if (doublejump) {
			if (velocity == 0) {
				velocity -= jumppower;
			}
		} else {
			velocity -= jumppower;
			jumppower = 15;
		}

	}

}
