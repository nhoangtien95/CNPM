package topicsse.java.com.entity;

import java.awt.Color;
import java.util.Random;

import topicsse.java.com.abstr.MoveableObject;
import topicsse.java.com.controller.Constant;
import topicsse.java.com.iface.IChangeSpeed;
import topicsse.java.com.iface.ISteerable;

public class Car extends MoveableObject implements ISteerable, IChangeSpeed {
	private int width;
	private int height;

	public Car() {
		// tao bien random
		Random random = new Random();
		// huong dau tien cua car la north = 0
		setHeading(Constant.NORTH);
		// tao random speed cua car
		int speed = random.nextInt(10) + 1;
		setSpeed(speed);
		// tao random color cua car
		int color = random.nextInt(Constant.COLLORCOUNT - 1);
		setColor(Constant.COLLOR[color]);
		// tao random kich thuoc cua car
		this.height = random.nextInt(5);
		this.width = random.nextInt(5);
		// khoi tao vi tri khoi dau cua car
		float[] lc = new float[2];
		lc[0] = Constant.X;
		lc[1] = Constant.Y;
		setLocation(lc);

	}

	// phuong thuc thay doi huong di chuyen cua car
	@Override
	public void steer(String action) {
		switch (action) {
		case "n":
			setHeading(Constant.NORTH);
			break;
		case "s":
			setHeading(Constant.SOUTH);
			break;
		case "w":
			setHeading(Constant.WEST);
			break;
		case "e":
			setHeading(Constant.EAST);
			break;
		}

	}

	// phuong thuc thay doi speed cua car
	@Override
	public void changeSpeed(String action) {
		int speed = getSpeed();
		switch (action) {
		case "i":
			setSpeed(speed + 1);
			break;
		case "l":
			if (speed > 1)
				setSpeed(speed - 1);
			else
				setSpeed(1);
			break;
		}
	}

	//
	@Override
	public String toString() {
		float[] loc = getLocation();
		Color color = getColor();
		String str = this.getClass().getSimpleName() + ": loc=" + loc[0] + "," + loc[1] + " color=" + "["
				+ color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "]" + " speed=" + getSpeed()
				+ " heading=" + getHeading() + " height=" + height + " width=" + width;

		return str;
	}

}
