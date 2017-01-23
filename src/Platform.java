import java.awt.Color;
import java.awt.Graphics;

public class Platform extends GameObject {
	Platform(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
	}
	void update(){
		  
	}
	void draw(Graphics g){
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 100, 20);
	}
	
}
