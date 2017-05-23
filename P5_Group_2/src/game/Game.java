package game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game extends Application implements ModelListener {
	
	//The model containing the score and whether the game is finished or not.
	private Model model;
	
	private boolean mode; // true = custom, false = express
	
	private Text scoreboard; //the scoreboard (obviously)

	@Override
	public void start(Stage stage) throws Exception {
		model = new Model();
		model.addModelListener(this);
		
		BeakerWorld world = new BeakerWorld(model);
		BorderPane bP = new BorderPane(world);
		
		MenuBar menubar = new MenuBar();
			Menu file = new Menu("File");
				MenuItem newExpress = new MenuItem("New Express Game");
				MenuItem newCustom = new MenuItem("New Custom Game...");
				MenuItem quit = new MenuItem("Quit");
				file.getItems().addAll(newExpress, newCustom, new SeparatorMenuItem(), quit);
		menubar.getMenus().addAll(file);
		
		scoreboard = new Text("Score: 0");
		scoreboard.setFont(new Font(20));
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
	
	@Override
	public void stop() {
		
	}
		
	public void setMode(boolean newmode){
		mode = newmode;
	}

	public boolean getMode() {
		return mode;
	}
			
	public static void main(String [] args) {
		launch(args);
	}

	@Override
	public void scoreChanged(int newValue) {
		scoreboard.setText("Score: " + newValue);
		
	}

	@Override
	public void gameFinishedChanged(boolean newValue) {
		scoreboard.setText("Game Over!");
		Platform.exit();
	}
}
