import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class MyTimer extends AnimationTimer {

	private GraphicsContext gc;
	private long startTime;
	private int last;
	private boolean changed;
	
	public MyTimer(GraphicsContext newGc, long time) {
		gc = newGc;
		startTime = time;
		last = 0;
		changed = true;
	}
	
	public void handle(long currentTime) {
		currentTime = (long) ((currentTime - startTime) / 1000000000.0);
		if (last != currentTime) {
			last = (int) currentTime;
			System.out.println(currentTime);
			gc.clearRect(0, 0, 1500, 900);
			changed = true;
		}
		if (changed) {
			if (currentTime % 3 == 0) {
				gc.fillText("Hello", 0, 200);
			}
			else if (currentTime % 3 == 1) {
				gc.fillText("With", 0, 400);
			}
			else{
				gc.fillText("Friends", 0, 700);
			}
			changed = false;
		}
	}

	
}
