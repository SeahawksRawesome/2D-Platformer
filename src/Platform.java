import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Platform extends GameObject {
	Platform(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		CollisionBox = new Rectangle(x, y, width, height);
	}
	void update(){
		CollisionBox.setBounds(x, y, width, height);
	}
	void draw(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(CollisionBox.x, CollisionBox.y, CollisionBox.width, CollisionBox.height);
	}
	
}
