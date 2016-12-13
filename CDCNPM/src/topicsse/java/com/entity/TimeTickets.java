package topicsse.java.com.entity;

import java.awt.Color;
import java.util.Random;

import topicsse.java.com.abstr.GameObject;
import topicsse.java.com.abstr.FixedObject;
import topicsse.java.com.controller.Constant;

public class TimeTickets extends FixedObject {
	private int width;
	private int height;
	private int time;

	public TimeTickets(int time) {
		Random random = new Random();
		this.height = random.nextInt(4) + 1;
		this.width = random.nextInt(4) + 1;
		this.time = time;
		int color = random.nextInt(Constant.COLLORCOUNT - 1);
		setColor(Constant.COLLOR[color]);
		float[] lc = new float[2];
		lc[0] = random.nextFloat() * 500;
		lc[1] = random.nextFloat() * 500;
		setLocation(lc);
	}

	@Override
	public String toString() {
		float[] loc = getLocation();
		Color color = getColor();
		String str = this.getClass().getSimpleName() + ": loc=" + loc[0] + "," + loc[1] + " color=" + "["
				+ color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "]" + " height=" + height
				+ " width=" + width;
		return str;
	}

	public int getTime() {
		return time;
	}
}
