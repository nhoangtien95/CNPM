package topicsse.java.com.controller;

import java.awt.Color;

public class Constant {
	// vi tri bat dau cua car
	public final static float X = (float) 247.5;
	public final static float Y = (float) 2.5;
	// thoi gian
	// kich thuoc cua map
	public final static int SIZEMAP = 10000;
	// kich thuoc cua fieldsquares
	public final static int SIZEFIELDSQUARES = 5;
	// so mang bat dau cua car
	public final static int LIVE = 3;
	// huong di chuyen cua car
	public final static int NORTH = 0;
	public final static int EAST = 90;
	public final static int SOUTH = 180;
	public final static int WEST = 270;
	// ban kinh cua monterball
	public final static int RADIUS = 2;
	// mau sac co the thay doi cua monterball, timeticket
	public final static Color[] COLLOR = { Color.RED, Color.ORANGE, Color.BLUE, Color.GREEN, Color.YELLOW };
	public final static int COLLORCOUNT = 5;
	// mau sac co the thay doi cua fieldsquares
	public final static Color[] COLLORFIELDSQUARES = { Color.WHITE, Color.black };
	// score
	public final static int SCORE = 50;
	// thoi gian
	public final static int TIME = 10;
	public final static int TIMEDOWN = 2;
	public final static int TIMETICKET = 5;
	public final static int TIMETICKETDOWN = 1;

	// action
	public final static String HNORTH = "n";
	public final static String HEAST = "e";
	public final static String HSOUTH = "s";
	public final static String HWEST = "w";
	public final static String INCREASE = "i";
	public final static String LOWER = "l";
	public final static String ADDMOSTERBALL = "b";
	public final static String ADDTIMETICKET = "k";
	public final static String GROUP = "g";
	public final static String ONE = "1";
	public final static String TWO = "2";
	public final static String THREE = "3";
	public final static String DISPLAY = "d";
	public final static String MAP = "m";
	public final static String QUIT = "q";
	public final static String GAMECLOCK = "t";

}
