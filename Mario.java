import javafx.scene.canvas.GraphicsContext;

public class Mario {
	private MarioRight right;
	private GraphicsContext gc;
	
	public Mario(GraphicsContext inGc) {
		gc = inGc;
	}
	
	public void animateRight(long currentTime) {
		right = new MarioRight(gc, currentTime);
		right.start();
	}
	
	public void stopRight() {
		right.stop();
		gc.clearRect(0, 0, 1500, 900);
	}
}
