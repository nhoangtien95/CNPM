package topicsse.java.com.abstr;

import topicsse.java.com.iface.IMoveable;

public abstract class MoveableObject extends GameObject implements IMoveable {
	private int heading;
	private int speed;

	public int getHeading() {
		return heading;
	}

	public void setHeading(int heading) {
		this.heading = heading;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public void move() {
		float x = (float) Math.cos(Math.toRadians(90 - heading)) * speed;
		float y = (float) Math.sin(Math.toRadians(90 - heading)) * speed;
		float[] arr = getLocation();
		arr[0] = x + arr[0];
		arr[1] = y + arr[1];
	}

}
