import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Flag extends GameObject {
	public static BufferedImage flag;
	
	
	Flag(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		flagBox = new Rectangle(x, y, width, height);
		try {
			flag = ImageIO.read(this.getClass().getResourceAsStream("Flag.png"));
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void update(){
		flagBox.setBounds(x, y, width, height );
	}
	void draw(Graphics g){
		g.drawImage(flag, x, y, width, height, null);
		g.setColor(Color.BLACK);
		g.drawRect(flagBox.x, flagBox.y, flagBox.width, flagBox.height);
	}
	}


