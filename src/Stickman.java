import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Stickman extends GameObject {

	int speed;
	boolean Rightkey;
	boolean Leftkey;
	boolean Spacekey;
	int bottom = 700;
	final int gravity = 1;
	int velocity = 0;
	int jumppower = 25;
	boolean doublejump = true;

	Stickman(int x, int y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 5;
		collisionBox = new Rectangle(x, y, width, height);
	}

	void update() {
		super.update();
		if (Rightkey) {
			x += speed;
		}
		if (Leftkey) {
			x -= speed;
		}
		velocity += gravity;
		y += velocity;
		if (y >= bottom) {
			y = bottom;
			velocity = 0;
		}
		collisionBox.setBounds(x, y, width, height);

	}

	void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, width, height);
		g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
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
