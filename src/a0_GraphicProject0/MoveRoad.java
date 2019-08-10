package a0_GraphicProject0;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class MoveRoad {
	private Image road1;
	private Image road2;
	private int y = -1500;

	public MoveRoad() {
		imageUpload();
		yolTasi();

	}

	private void imageUpload() {
		road2 = new ImageIcon("image/road.png").getImage();
	}

	public Image getImage() {
		return road2;
	}

	public void yolTasi() {
		y += 3;
		if (y > 0) {
			y = -1500;
		}
	}

	public int getY() {
		return y;
	}
}
