package topicsse.java.com.controller;

public class Game {
	private GameWord gameWord;

	public Game() {
		gameWord = new GameWord();
		play();
	}

	public void play() {
		gameWord.getCommand();

	}
}
