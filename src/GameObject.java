import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	Rectangle CollisionBox;

	GameObject() {
		CollisionBox = new Rectangle(x, y, width, height);

	}

	void update() {
		CollisionBox.setBounds(x, y, width, height);
	}

	void draw(Graphics g) {

	}
}
