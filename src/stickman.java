import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class stickman extends GameObject{
	int speed;
	boolean Rightkey;
	boolean Leftkey;
	boolean Spacekey;
	final int bottom = 700;
	final int gravity = 1;
	int velocity = 0;
	int jumppower = 25;
	boolean doublejump = true;
	//DO the Collision next class
	stickman(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		speed = 5;
		CollisionBox = new Rectangle(x, y, width, height);
	}
	void update(){
		if(Rightkey){
			x+= speed;
		}
		if(Leftkey){
			x-= speed;
		}
		velocity += gravity;
		y+= velocity;
		if(y >= bottom){
			y = bottom;
			velocity = 0;
		}
		CollisionBox.setBounds(x, y, width, height);
		
		
	}
	void draw(Graphics g){
	g.setColor(Color.BLACK);
	g.fillRect(x, y, width, height);
	g.drawRect(CollisionBox.x, CollisionBox.y, CollisionBox.width, CollisionBox.height);
	}
	public void jump(){
		//its opposite. so if false, true. if true, false
		if(doublejump){
			if(velocity == 0){
				velocity -= jumppower;
			} 
		}
		else{
			velocity -= jumppower;
			jumppower = 15;
		}
	}



}
