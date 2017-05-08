import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy extends GameObject {
	int speed;
	public static BufferedImage knightImgRight;
	public static BufferedImage knightImgLeft;
	public static BufferedImage knightImg;

	Enemy(int x, int y, int width, int height) {

		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		// Random rand = new Random();
		knightBox = new Rectangle(x, y, width, height);
		headBox = new Rectangle(x, y, width, height);
		speed = 5;
		try {
			knightImgRight = ImageIO.read(this.getClass().getResourceAsStream("Knight of the Eternal Flame.png"));
			knightImgLeft = ImageIO.read(this.getClass().getResourceAsStream("Knight Facing other way.png"));
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		knightImg = knightImgRight;
	}

	void update() {
		x = x + speed;
		if (x <= 0) {
			x = 2;
			reverseSpeed();
			knightImg = knightImgRight;

		} else if (x >= Stickman_Platformer.Width - 500) {
			x = Stickman_Platformer.Width - 505;
			reverseSpeed();
			knightImg = knightImgLeft;

		}
		headBox.setBounds(x + 15, y, width - 20, height - 100);
	}

	void draw(Graphics g) {
		g.drawImage(knightImg, x, y, width, height, null);
		g.drawRect(headBox.x, headBox.y, headBox.width, headBox.height);
	}

	public void reverseSpeed() {
		speed = -speed;
	}

}
