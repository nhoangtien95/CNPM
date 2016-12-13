package topicsse.java.com.entity;

import java.awt.Color;
import java.util.Random;

import topicsse.java.com.abstr.MoveableObject;
import topicsse.java.com.controller.Constant;
import topicsse.java.com.iface.IChangeColor;

public class MonsterBall extends MoveableObject implements IChangeColor {
	private int radius;

	public MonsterBall() {
		Random random = new Random();
		this.radius = Constant.RADIUS;
		// khoi tao huong di chuyen cho monterball;
		int heading = random.nextInt(360);
		setHeading(heading);
		// khoi tao mau cho monterball
		int color = random.nextInt(Constant.COLLORCOUNT - 1);
		setColor(Constant.COLLOR[color]);
		// khoi tao vi tri cho monterball
		float[] lc = new float[2];
		lc[0] = random.nextFloat() * 500;
		lc[1] = random.nextFloat() * 500;
		setLocation(lc);
	}

	@Override
	public void changeColor() {
		Random random = new Random();
		int color;
		do {
			color = random.nextInt(Constant.COLLORCOUNT - 1);
		} while (getColor().equals(Constant.COLLOR[color]));
		setColor(Constant.COLLOR[color]);
	}

	@Override
	public String toString() {
		float[] loc = getLocation();
		Color color = getColor();
		String str = this.getClass().getSimpleName() + ": loc=" + loc[0] + "," + loc[1] + " color=" + "["
				+ color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "]" + " speed=" + getSpeed()
				+ " heading=" + getHeading() + " radius=" + radius;
		return str;
	}

}
