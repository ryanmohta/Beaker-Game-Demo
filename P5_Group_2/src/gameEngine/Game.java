package gameEngine;

import game.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game extends Application {
	private boolean mode; // true = custom, false = express
	private int numFailed; //number of drops that hit the floor
	private int score; //the number of drops that successfully land in the beaker

	public void setMode(boolean newmode){
		mode = newmode;
	}

	public boolean getMode() {
		return mode;
	}

	public void setScore(int newscore) {
		if (newscore >= 0) 
			score = newscore;
	}

	public int getScore() {
		return score;
	}
	
	public int getNumFailed() {
		return numFailed;
	}


	public boolean isGameOver() {
		if (numFailed >= 5)
			return true;
		return false;
	}
	

	@Override
	public void start(Stage stage) throws Exception {
		BeakerWorld world = new BeakerWorld();
		Scene scene = new Scene(world, 800, 600);
		stage.setScene(scene);
		stage.setTitle("Beaker Game");
		world.add(new Beaker(0,-600));
		world.add(new Dropper(0,0));
		stage.show();
	}
	
	/**
	    BorderPane root = new BorderPane();
		HBox top = new HBox();
		root.setTop(top);
		
		Label failedDrops = new Label("Failed Drops: " + Integer.toString(getNumFailed()));
		Label score = new Label("Score: " + Integer.toString(getScore()) + "      ");
		Font font = new Font(20);
		score.setFont(font);
		failedDrops.setFont(font);
		top.getChildren().addAll(score, failedDrops);
		
		
		
		Scene scene = new Scene(root,800,600);
		stage.setScene(scene);
		stage.show();
		
	 */
	
	public static void main (String [] args) {
		launch(args);
	}
}
