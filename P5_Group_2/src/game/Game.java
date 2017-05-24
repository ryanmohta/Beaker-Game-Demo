package game;

import javafx.application.Application;
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

/**
 * {@link Game} is the GUI class for our project. It extends
 * {@link Application} and contains {@link javafx.scene.Node}
 * objects to create the layout of the game.
 *
 * @author Ryan Mohta and Oleon Hariharan
 */
public class Game extends Application implements ModelListener {

	private boolean mode; // true = custom, false = express

	private BorderPane borderPane; // the BorderPane which contains the MenuBar, World, and HBox.

	private MenuBar menuBar;
	private Menu file;
	private MenuItem newExpress, newCustom, quit;

	private BeakerWorld world; // the world!
	private Beaker beaker; // the beaker used during the game.

	private HBox hBox;
	private Text scoreboard; // the text box showing the current score.

	@Override
	public void init() {
		Model model = new Model();
		model.addModelListener(this);

		menuBar = new MenuBar();
			file = new Menu("File");
				newExpress = new MenuItem("New Express Game");
				newExpress.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						reset();
					}
				});
				newCustom = new MenuItem("New Custom Game...");
				quit = new MenuItem("Quit");
			file.getItems().addAll(newExpress, newCustom, new SeparatorMenuItem(), quit);
		menuBar.getMenus().addAll(file);

		scoreboard = new Text("Score: 0");
		scoreboard.setFont(new Font(20));

		hBox = new HBox(20, scoreboard);
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

	/**
	 * Sets the {@code mode} variable to the parameter.
	 * @param newMode the new {@code mode} value.
	 *                {@code true} is custom,
	 *             {@code false} is express.
	 */
	public void setMode(boolean newMode){
		mode = newMode;
	}

	/**
	 * Returns the {@code mode} for the Game.
	 * @return the mode. {@code true} is custom,
	 * {@code false} is express.
	 */
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
