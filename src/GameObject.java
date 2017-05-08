import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	Rectangle collisionBox;
	Rectangle feetBox;
	Rectangle headBox;
	Rectangle knightBox;
	boolean isAlive = true;

	GameObject() {
		collisionBox = new Rectangle(x, y, width, height);

	}

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	void draw(Graphics g) {

	}
}
