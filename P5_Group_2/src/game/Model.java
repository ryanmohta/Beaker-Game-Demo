package game;

import java.util.ArrayList;

public class Model {
	private int score;
	private boolean gameFinished;
	private ArrayList<ModelListener> listeners;
	
	public Model() {
		this(0);
	}
	
	public Model(int score) {
		this.score = score;
		this.gameFinished = false;
		listeners = new ArrayList<>();
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int newScore) {
		score = newScore;
		for(ModelListener mL : listeners) {
			mL.scoreChanged(newScore);
		}
	}
	
	public void incrementScore() {
		setScore(score + 1);
	}
	
	public boolean getGameFinished() {
		return gameFinished;
	}
	
	public void setGameFinished(boolean gameFinished) {
		this.gameFinished = gameFinished;
		for(ModelListener mL : listeners) {
			mL.gameFinishedChanged(gameFinished);
		}
	}
	
	public void toggleGameFinished() {
		setGameFinished(!gameFinished);
	}
	
	public void addModelListener(ModelListener mL) {
		listeners.add(mL);
	}
}
