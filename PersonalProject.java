import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PersonalProject extends Application {

	private GraphicsContext gc;
	private final int CANVASWIDTH = 1500;
	private final int CANVASHEIGHT = 900;
	private boolean player1Animated = false;
	private Mario player1;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage myStage){
		myStage.setTitle("My Personal Project");
		BorderPane root = new BorderPane();
		Canvas myCanvas = new Canvas(CANVASWIDTH, CANVASHEIGHT);
		gc = myCanvas.getGraphicsContext2D();
		player1 = new Mario(gc);
//		MyTimer testTimer = new MyTimer(gc, System.nanoTime());
//		testTimer.start();
		root.setCenter(myCanvas);
		Scene battleGround = new Scene(root);
		KeyPresses actions = new KeyPresses();
		KeyReleases releases = new KeyReleases();
		battleGround.setOnKeyPressed(actions);
		battleGround.setOnKeyReleased(releases);
		myStage.setScene(battleGround);
		myStage.show();
	}
	
	
	private class KeyPresses implements EventHandler <KeyEvent> {

		@Override
		public void handle(KeyEvent key) {
			long currentTime = System.nanoTime();
			
			if (key.getText().equals("d")) {
				if (! player1Animated) {
					player1.animateRight(currentTime);
					player1Animated = true;
				}
			}
			else {
				System.out.println("This is not d");
			}
		}

	}
	
	private class KeyReleases implements EventHandler <KeyEvent> {
		
		@Override
		public void handle(KeyEvent key) {
			if (key.getText().equals("d")) {
				player1Animated = false;
				player1.stopRight();
				System.out.println("d is released");
			}
		}
	}

}
