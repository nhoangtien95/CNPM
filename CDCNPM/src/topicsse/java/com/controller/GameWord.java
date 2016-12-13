package topicsse.java.com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import topicsse.java.com.entity.Car;
import topicsse.java.com.entity.FieldSquares;
import topicsse.java.com.entity.MonsterBall;
import topicsse.java.com.entity.TimeTickets;

public class GameWord {
	private int currentlevel;
	private int currentScore;
	private int minimumScore;
	private int time;
	private int live;
	private FieldSquares[][] squares;
	private Car car;
	private List<MonsterBall> listMonsterBall;
	private List<TimeTickets> listTimeTicket;

	public GameWord() {
		// khoi tao map
		createMap();
		// khoi tao live
		live = Constant.LIVE;
		// khoi tao level
		currentlevel = 1;
		// khoi tao current score
		currentScore = 0;
		// khoi tao minimum score
		minimumScore = Constant.SCORE * 100;
		// khoi tao thoi gian
		time = Constant.TIME;
		// khoi tao car
		car = new Car();
		// khoi tao danh sach monster ball
		listMonsterBall = new ArrayList<MonsterBall>();
		// khoi tao danh sach timeticket
		listTimeTicket = new ArrayList<TimeTickets>();
	}

	// khoi tao map
	private void createMap() {
		squares = new FieldSquares[100][100];
		float[] loc;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				loc = new float[2];
				squares[i][j] = new FieldSquares();
				loc[0] = (float) ((i + 1) * 5 - 2.5);
				loc[1] = (float) ((j + 1) * 5 - 2.5);
				if (i == 0 || j == 0 || i == 99 || j == 99) {
					squares[i][j].changeColor();
				}
				squares[i][j].setLocation(loc);
			}
		}
	}

	// hien thi
	private void display() {
		System.out.println("current level: " + currentlevel + " - live: " + live + " - time: " + time + " - score: "
				+ currentScore + " - minimum score: " + minimumScore);
	}

	// them moi 1 monsterball
	private void addMonsterBall() {
		MonsterBall monsterBall = new MonsterBall();
		listMonsterBall.add(monsterBall);
	}

	// them moi 1 timeticket
	private void addTimeTicket() {
		int time = Constant.TIMETICKET - (currentlevel - 1) * Constant.TIMETICKETDOWN;
		TimeTickets timeTickets = null;
		if (time <= 0)
			time = 1;
		timeTickets = new TimeTickets(time);
		listTimeTicket.add(timeTickets);
	}

	// tang level
	private void nextLevel() {
		currentlevel++;
		live = Constant.LIVE;
		createMap();
		currentScore = 0;
		time = Constant.TIME - Constant.TIMEDOWN * currentlevel;
		if (time <= 0)
			time = 1;
		minimumScore = minimumScore + 1000;
		if (minimumScore >= 10000)
			minimumScore = 10000;
		car = new Car();
		listMonsterBall = new ArrayList<MonsterBall>();
		listTimeTicket = new ArrayList<TimeTickets>();
	}

	// thay doi huong di chuyen cua car
	private void changeHeading(String head) {
		car.steer(head);
	}

	// thay doi toc do cua car
	private void changeSpeed(String action) {
		car.changeSpeed(action);
	}

	// hien thi map
	private void showMap() {
		System.out.println(car.toString());
		for (MonsterBall ball : listMonsterBall) {
			System.out.println(ball.toString());
		}
		for (TimeTickets tickets : listTimeTicket) {
			System.out.println(tickets.toString());
		}
	}

	// mat mang
	private void die() {
		car = new Car();
		live--;
		if (live == 0)
			endGame();
	}

	// ket thuc game
	private void endGame() {
		System.out.println("Game Over!!!");
		System.exit(1);
	}

	// su kien car va cham voi 1 monsterball
	private void collidedMonsterBall() {
		if (listMonsterBall.size() > 0) {
			die();
			for (MonsterBall monsterBall : listMonsterBall) {
				monsterBall.changeColor();
			}
		}
	}

	// su kien car va cham voi 1 timeticket
	private void collidedTimeTicket() {
		if (listTimeTicket.size() > 0) {
			int i;
			if (listTimeTicket.size() == 1)
				i = 0;
			else {
				Random random = new Random();
				i = random.nextInt(listTimeTicket.size() - 1);
			}
			time = time + listTimeTicket.get(i).getTime();
			listTimeTicket.remove(i);
		}
	}

	// kiem tra dieu kien de chuyen qua mang tiep theo
	private void check() {
		System.out.println(minimumScore);
		if (currentScore >= minimumScore) {
			nextLevel();
		}
	}

	//
	private void gameClock() {
		car.move();
		for (MonsterBall monsterBall : listMonsterBall) {
			monsterBall.move();
		}
		time--;
		if (time == 0)
			die();
	}

	// dem so luong square ma car da di qua
	public int getCount() {
		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (squares[i][j].getColor().equals(Constant.COLLORFIELDSQUARES[1])) {
					count++;
				}
			}
		}
		return count;
	}

	// them vao mot so ngau nhien cac square
	private void addRandom() {
		Random random = new Random();
		int size = random.nextInt(Constant.SIZEMAP - getCount());
		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (squares[i][j].getColor().equals(Constant.COLLORFIELDSQUARES[0])) {
					if (count == size)
						break;
					squares[i][j].setColor(Constant.COLLORFIELDSQUARES[1]);
					count++;
				}
				if (count == size)
					break;
			}
		}
		currentScore = getCount();
		System.out.println("score: " + currentScore);
		check();
	}

	// them vao 1 square
	private void addSquare() {
		boolean b = false;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (squares[i][j].getColor().equals(Constant.COLLORFIELDSQUARES[0])) {
					squares[i][j].changeColor();
					b = true;
					break;
				}
				if (b == true)
					break;
			}
		}
		currentScore = getCount();
		check();
	}

	// nhan thong tin nhap vao tu ban phim
	public void getCommand() {
		Scanner scan = new Scanner(System.in);
		String input = null;
		do {
			System.out.print("please enter key: ");
			input = scan.nextLine();
			switch (input) {
			case Constant.HNORTH:
				changeHeading(input);
				break;
			case Constant.HEAST:
				changeHeading(input);
				break;
			case Constant.HSOUTH:
				changeHeading(input);
				break;
			case Constant.HWEST:
				changeHeading(input);
				break;
			case Constant.INCREASE:
				changeSpeed(input);
				break;
			case Constant.LOWER:
				changeSpeed(input);
				break;
			case Constant.ADDMOSTERBALL:
				addMonsterBall();
				break;
			case Constant.ADDTIMETICKET:
				addTimeTicket();
				break;
			case Constant.GROUP:
				addRandom();
				break;
			case Constant.ONE:
				collidedMonsterBall();
				break;
			case Constant.TWO:
				addSquare();
				break;
			case Constant.THREE:
				collidedTimeTicket();
				break;
			case Constant.DISPLAY:
				display();
				break;
			case Constant.MAP:
				showMap();
				break;
			case Constant.GAMECLOCK:
				gameClock();
				break;
			case Constant.QUIT:

				break;
			default:
				System.out.println("no key!");
				break;
			}

		} while (!input.equals(Constant.QUIT));
		System.out.println("end.");
	}

}
