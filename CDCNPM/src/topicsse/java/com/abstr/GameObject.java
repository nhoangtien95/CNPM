package topicsse.java.com.abstr;

import java.awt.Color;

public abstract class GameObject {
	private float[] location;
	private Color color;

	public float[] getLocation() {
		return location;
	}

	public void setLocation(float[] location) {
		this.location = location;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	

}
