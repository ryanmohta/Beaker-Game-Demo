package game;

import java.util.Optional;

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
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * {@code Game} is the GUI class for our project. It extends
 * {@link Application} and contains {@link javafx.scene.Node}
 * objects to create the layout of the game.
 *
 * @author Ryan Mohta and Oleon Hariharan
 */
public class Game extends Application implements ModelListener {

	private BorderPane borderPane; // the BorderPane which contains the MenuBar, World, and HBox.

	private BeakerWorld world; // the world!
	private Beaker beaker; // the beaker used during the game.

	private Text scoreboard; // the text box showing the current score.

	@Override
	public void init() {
		Model model = new Model();
		model.addModelListener(this);

		MenuBar menuBar = new MenuBar();
		Menu file = new Menu("File");
		MenuItem newExpress = new MenuItem("New Express Game");
			newExpress.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					reset();
				}
			});
		MenuItem newCustom = new MenuItem("New Custom Game...");
			newCustom.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					TextInputDialog dialog = new TextInputDialog("5");
					dialog.setTitle("Custom Game");
					dialog.setContentText("Please enter a speed for the beaker(enter an integer): ");
					
					Optional<String> result = dialog.showAndWait();
				}
			});
		MenuItem quit = new MenuItem("Quit");
			quit.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					Platform.exit();
				}
			});
		file.getItems().addAll(newExpress, newCustom, new SeparatorMenuItem(), quit);
		menuBar.getMenus().addAll(file);

		scoreboard = new Text("Score: 0");
		scoreboard.setFont(new Font(20));

		HBox hBox = new HBox(20, scoreboard);
		hBox.setPadding(new Insets(20));

		world = new BeakerWorld(model);

		borderPane = new BorderPane(world);
		borderPane.setTop(menuBar);
		borderPane.setBottom(hBox);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(borderPane, 800, 600);
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

	/**
	 * Resets the {@link BeakerWorld} to its original form.
	 * Used for starting a new game.
	 */
	public void reset() {
		beaker.start();
		world.setAcceptingKeystrokes(true);
		world.getModel().setScore(0);
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
