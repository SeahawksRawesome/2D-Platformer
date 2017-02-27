public class ObjectManager {

	public boolean checkCollision(stickman s, Platform p) {
		if (s.CollisionBox.intersects(p.CollisionBox)) {
			return true;
		} else {
			return false;
		}

	}
}
