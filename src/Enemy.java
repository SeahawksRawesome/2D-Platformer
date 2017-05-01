import java.awt.Graphics;
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

		} else if (x >= Stickman_Platformer.Width) {
			x = Stickman_Platformer.Width - 5;
			reverseSpeed();
			knightImg = knightImgLeft;

		}
	}

	void draw(Graphics g) {
		g.drawImage(knightImg, x, y, width, height, null);
	}

	public void reverseSpeed() {
		speed = -speed;
	}

}
