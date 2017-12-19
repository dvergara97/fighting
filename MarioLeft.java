import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class MarioLeft extends AnimationTimer {

	private GraphicsContext gc;
	private Image frame1;
	private Image frame2;
	private Image frame3;
	private final int imageWidth;
	private final int imageHeight;
	private int[] positions;
	private long startTime;
	private int last;
	private boolean changed;
	private int currentFrame = 0;
	
	public MarioLeft(GraphicsContext newGc, long inTime, int[] inPositions, int inImageWidth, int inImageHeight) {
		imageWidth = inImageWidth;
		imageHeight = inImageHeight;
		frame1 = new Image("marioLeft1.png", imageWidth, imageHeight, true, true);
		frame2 = new Image("marioLeft2.png", imageWidth, imageHeight, true, true);
		frame3 = new Image("marioLeft3.png", imageWidth, imageHeight, true, true);
		gc = newGc;
		startTime = inTime;
		positions = inPositions;
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
		if ( positions[0] > 0) {
			positions[0] -= 3;
		}
		gc.clearRect(0, 0, 1500, 900);
		if (currentFrame <= 20) {
			gc.drawImage(frame1, positions[0], positions[1]);
		}
		else if (currentFrame <= 40) {
			gc.drawImage(frame2, positions[0], positions[1] + 5);
		}
		else if (currentFrame <= 60){
			gc.drawImage(frame3, positions[0], positions[1] + 10);
		}
		else {
			gc.drawImage(frame2, positions[0], positions[1] + 5);
			if (currentFrame == 80) {
				currentFrame = -1;
			}
		}
		currentFrame += 1;
		
/*
		if (last != currentTime) {
			last = (int) currentTime;
			gc.clearRect(0, 0, 1500, 900);
			changed = true;
		}
		if (changed) {
			if (currentTime % 3 == 0 ) {
				gc.drawImage(frame1, positions[0], positions[1]);
			}
			else if (currentTime % 3 == 1) {
				gc.drawImage(frame2, positions[0], positions[1]);
			}
			else {
				gc.drawImage(frame3, positions[0], positions[1]);
			}
			changed = false;
		}
		*/
		
	}
	
}
