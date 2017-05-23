package game;

import java.util.ArrayList;

public class Model {
	private int score;
	private ArrayList<ModelListener> listeners;
	
	public Model() {
		this(0);
	}
	
	public Model(int score) {
		this.score = score;
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
	
	public void addModelListener(ModelListener mL) {
		listeners.add(mL);
	}
}
