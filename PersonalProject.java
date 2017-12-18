import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PersonalProject extends Application {

	private GraphicsContext gc;
	private final int CANVASWIDTH = 1500;
	private final int CANVASHEIGHT = 900;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage myStage){
		myStage.setTitle("My Personal Project");
		BorderPane root = new BorderPane();
		Canvas myCanvas = new Canvas(CANVASWIDTH, CANVASHEIGHT);
		gc = myCanvas.getGraphicsContext2D();
		MyTimer testTimer = new MyTimer(gc, System.nanoTime());
		testTimer.start();
		root.setCenter(myCanvas);
		myStage.setScene(new Scene(root));
		myStage.show();
	}
	
}
