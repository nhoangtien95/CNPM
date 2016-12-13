package topicsse.java.com.entity;

import topicsse.java.com.abstr.GameObject;
import topicsse.java.com.abstr.FixedObject;
import topicsse.java.com.controller.Constant;
import topicsse.java.com.iface.IChangeColor;

public class FieldSquares extends FixedObject implements IChangeColor {
	private int width;
	private int height;

	public FieldSquares() {
		super();
		// khoi tao kich thuoc cua fieldsquares
		this.width = Constant.SIZEFIELDSQUARES;
		this.height = Constant.SIZEFIELDSQUARES;
		// khoi tao color cho fieldsquares
		setColor(Constant.COLLORFIELDSQUARES[0]);
	}

	@Override
	public void changeColor() {
		setColor(Constant.COLLORFIELDSQUARES[1]);
	}

}
