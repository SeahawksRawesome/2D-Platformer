import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {

	int platformOffset = 0;
	ArrayList<GameObject> objects;

	ObjectManager() {
		objects = new ArrayList<GameObject>();

	}

	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}

	public boolean checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				if (o1 instanceof Stickman) {

				}
				if ((o1 instanceof Stickman && o2 instanceof Orb)) {
					System.out.println("Yo, dis is workun");
					if (((Stickman) o1).feetBox.intersects(((Orb) o2).orbBox)) {
						System.exit(0);
						o2.isAlive = false;
					}
				}
				if ((o2 instanceof Platform && o1 instanceof Stickman)) {
					if (((Stickman) o1).feetBox.intersects(o2.collisionBox)) {
						// This is the collision code for the Platform and
						// Stickman.
						System.out.println("Collided");
						// if(o2.y > o1.y + 75){
						platformOffset = o2.y - o1.height + 1;
						// }

						return true;
					}

				}
				
				if ((o1 instanceof Stickman && o2 instanceof Enemy)) {
					if (((Stickman) o1).feetBox.intersects(o2.headBox)) {
						System.out.println("Yup");
						o2.isAlive = false;
					}
				}
				if ((o1 instanceof Stickman && o2 instanceof Enemy)) {
					if (((Stickman) o1).feetBox.intersects(o2.knightBox)) {
						System.out.println("crumbs");
						o1.isAlive = false;
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
		purgeObjects();
	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
	}

}
