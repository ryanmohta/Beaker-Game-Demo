package gameEngine;

import game.*;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game extends Application {
	private boolean mode; // true = custom, false = express
	private int numFailed; //number of drops that hit the floor
	private IntegerProperty score; //the number of drops that successfully land in the beaker
	
	private Text scoreboard; //the scoreboard (obviously)

	public void setMode(boolean newmode){
		mode = newmode;
	}

	public boolean getMode() {
		return mode;
	}

	public void setScore(int newscore) {
		if (newscore >= 0) 
			score.set(newscore);
	}

	public int getScore() {
		return score.get();
	}
	
	public void incrementScore() {
		score.set(score.get() + 1);
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
		BorderPane bP = new BorderPane(world);
		
		scoreboard = new Text("Score: 0");
		scoreboard.setFont(new Font(20));
		MenuBar menubar = new MenuBar();
		Menu file = new Menu("File");
		menubar.getMenus().add(file);
		HBox hB = new HBox(20, scoreboard);
		hB.setPadding(new Insets(20, 50, 20, 700));
		bP.setBottom(hB);
		bP.setTop(menubar);

		Scene scene = new Scene(bP, 800, 600);
		stage.setScene(scene);
		stage.setTitle("Beaker Game");
		world.add(new Beaker(world.getWidth(), 350));
		
		world.start();
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
