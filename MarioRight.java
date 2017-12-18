import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class MarioRight extends AnimationTimer {

	private GraphicsContext gc;
	private Image frame1;
	private Image frame2;
	private Image frame3;
	private long startTime;
	private int last;
	private boolean changed;
	
	public MarioRight(GraphicsContext newGc, long inTime) {
		frame1 = new Image("marioRight1.png");
		frame2 = new Image("marioRight2.png");
		frame3 = new Image("marioRight3.png");
		gc = newGc;
		startTime = inTime;
		last = 0;
		changed = true;
	}
	
	
	public Image getFrame1() {
		return frame1;
	}
	
	public Image getFrame2() {
		return frame2;
	}
	
	public Image getFrame3() {
		return frame3;
	}


	@Override
	public void handle(long currentTime) {
		currentTime = (long) ((currentTime - startTime) / 1000000000.0);
		if (last != currentTime) {
			last = (int) currentTime;
			gc.clearRect(0, 0, 1500, 900);
			changed = true;
		}
		if (changed) {
			if (currentTime % 3 == 0 ) {
				gc.drawImage(frame1, 30, 30);
			}
			else if (currentTime % 3 == 1) {
				gc.drawImage(frame2, 30, 30);
			}
			else {
				gc.drawImage(frame3, 30, 30);
			}
			changed = false;
		}
	}
	
}
