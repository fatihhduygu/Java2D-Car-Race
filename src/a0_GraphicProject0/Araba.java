package a0_GraphicProject0;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Araba {
	private int x;
	private int y;
	private int width;
	private int height;
	private int dx;
	private int dy;
	private int key;
	MoveRoad road = new MoveRoad();
	Image car;

	public Araba() {
		ImageUpload();
		x = 325;
		y = 610;
	}

	private void ImageUpload() {
		car = new ImageIcon("image/car.png").getImage();
		width = car.getWidth(null);
		height = car.getHeight(null);
	}

	public void Tasi() {
		x += dx;
		y += dy;
		if (x < 180) {
			x = 180;
		} else if (y > 625) {
			y = 625;
		} else if (y < 0) {
			y = 0;
		} else if (x > 486) {
			x = 486;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImage() {
		return car;
	}

	public Rectangle Cerceve() {
		return new Rectangle(x, y, width, height);
	}

	public void KeyPress(KeyEvent e) {
		key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			dx = -2;
		}
		if (key == KeyEvent.VK_RIGHT) {
			dx = +2;
		}
		if (key == KeyEvent.VK_UP) {
			dy = -1;
		}
		if (key == KeyEvent.VK_DOWN) {
			dy = +2;
		}

		if (key == KeyEvent.VK_SHIFT) {
			dy = -2;
		}

		if (key == KeyEvent.VK_W) {
			dy = -1;
		}

		if (key == KeyEvent.VK_A) {
			dx = -2;
		}
		if (key == KeyEvent.VK_S) {
			dy = +2;
		}
		if (key == KeyEvent.VK_D) {
			dx = +2;
		}
	}

	public void KeyReleased(KeyEvent e) {
		key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		if (key == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
		if (key == KeyEvent.VK_UP) {
			dy = 0;
		}
		if (key == KeyEvent.VK_DOWN) {
			dy = 0;
		}

		if (key == KeyEvent.VK_SHIFT) {
			dy = 0;
		}
		if (key == KeyEvent.VK_W) {
			dy = 0;
		}

		if (key == KeyEvent.VK_A) {
			dx = 0;
		}
		if (key == KeyEvent.VK_S) {
			dy = 0;
		}
		if (key == KeyEvent.VK_D) {
			dx = 0;
		}
	}
}
