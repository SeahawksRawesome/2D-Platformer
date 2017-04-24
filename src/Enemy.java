import java.awt.Graphics;

public class Enemy extends GameObject {

	Enemy(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	void update() {
		for (int i = 0; i < 10; i += 1) {
			x += 1;
			System.out.println("yep");
		}
		for (int i = 0; i < 10; i += 1) {
			x -= 1;
		}
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.knightImg, x, y, width, height, null);
	}
}
