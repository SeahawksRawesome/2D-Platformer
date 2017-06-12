import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class Orb extends GameObject {
	
	public static BufferedImage orb;
	
	Orb(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		orbBox = new Rectangle(x, y, width, height);
		try {
			orb = ImageIO.read(this.getClass().getResourceAsStream("Orb copy.png"));
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void update(){
		orbBox.setBounds(x, y, width, height );
	}
	void draw(Graphics g){
		g.drawImage(orb, x, y, width, height, null);
		g.setColor(Color.BLACK);
		g.drawRect(collisionBox.x, collisionBox.y, collisionBox.width, collisionBox.height);
	}
	
}
