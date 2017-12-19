import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Mario {
	private MarioRight right;
	private GraphicsContext gc;
	//X position, Y position
	private int[] positions = {300, 300};
	private int imageWidth = 50;
	private int imageHeight = 100;
	//Get a sprite of him standing
	private Image standingRight = new Image("marioStandingRight.png", imageWidth, imageHeight, true, true);
	private Image standingLeft = new Image("marioStandingLeft.png", imageWidth, imageHeight, true, true);
	private MarioLeft left;
	
	public Mario(GraphicsContext inGc) {
		gc = inGc;
		gc.drawImage(standingRight, positions[0], positions[1]);
	}
	
	public void animateRight(long currentTime) {
		right = new MarioRight(gc, currentTime, positions, imageWidth, imageHeight);
		right.start();
	}
	
	public void stopRight() {
		right.stop();
		gc.clearRect(0, 0, 1500, 900);
		gc.drawImage(standingRight, positions[0], positions[1]);
	}
	
	public void animateLeft(long currentTime) {
		left = new MarioLeft(gc, currentTime, positions, imageWidth, imageHeight);
		left.start();
	}
	
	public void stopLeft() {
		left.stop();
		gc.clearRect(0, 0, 1500, 900);
		gc.drawImage(standingLeft, positions[0], positions[1]);
	}
}
