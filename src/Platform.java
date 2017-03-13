import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Platform extends GameObject {
	Platform(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collisionBox = new Rectangle(x, y, width, height -15);
	}
	void update(){
		collisionBox.setBounds(x, y, width, height -15);
	}
	void draw(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
	}
	
}
