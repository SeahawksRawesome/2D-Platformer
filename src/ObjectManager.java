import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	
	int platformOffset = 0;
	ArrayList<GameObject> objects;
	ObjectManager(){
		objects = new ArrayList<GameObject>();
		
	}
	public boolean checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				if(o1 instanceof Stickman){
					
				}
			
				if (o1.collisionBox.intersects(o2.collisionBox)) {
					if ((o1 instanceof Platform && o2 instanceof Stickman) 
						|| (o2 instanceof Platform && o1 instanceof Stickman)) {
						//This is the collision code for the Platform and Stickman.
						System.out.println("Collided");
						platformOffset = o1.y;
						return true;
					}
					
				}
			}
		}
		platformOffset = 0;
		return false;

	}

	public void addObject(GameObject o) {
		objects.add(o);
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.update();
		}
	}
	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
	}
			

}
