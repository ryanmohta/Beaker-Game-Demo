package game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	
	private BeakerWorld world; // the world!
	private Beaker beaker; // the beaker used during the game.
	private Text scoreboard; // the text box showing the current score.
	
	@Override
	public void start(Stage stage) throws Exception {
		model = new Model();
		model.addModelListener(this);
		
		world = new BeakerWorld(model);
		BorderPane bP = new BorderPane(world);
		
		MenuBar menubar = new MenuBar();
			Menu file = new Menu("File");
				MenuItem newExpress = new MenuItem("New Express Game");
//				newExpress.setOnAction(new EventHandler<ActionEvent>() {
//					@Override
//					public void handle(ActionEvent event) {
//						try {
//							start(stage);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});
				MenuItem newCustom = new MenuItem("New Custom Game...");
				MenuItem quit = new MenuItem("Quit");
//				quit.setOnAction(new EventHandler<ActionEvent>() {
//					@Override
//					public void handle(ActionEvent event) {
//						Platform.exit();
//					}
//				});
				file.getItems().addAll(newExpress, newCustom, new SeparatorMenuItem(), quit);
		menubar.getMenus().addAll(file);
		
		scoreboard = new Text("Score: 0");
		scoreboard.setFont(new Font(20));
		HBox hB = new HBox(20, scoreboard);
		hB.setPadding(new Insets(20));
		bP.setBottom(hB);
		bP.setTop(menubar);

		Scene scene = new Scene(bP, 800, 600);
		stage.setScene(scene);
		stage.setTitle("Beaker Game");

		beaker = new Beaker(world.getWidth(), 350);
		world.add(beaker);
		
		world.start();
		stage.show();
	}
	
	@Override
	public void stop() {
		beaker.stop();
		world.toggleAcceptingKeystrokes();
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
		scoreboard.setText("Game Over!  -  " + scoreboard.getText());
		stop();
	}
}
