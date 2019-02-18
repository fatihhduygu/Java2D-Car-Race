package a0_GraphicProject0;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class KarsiAraba{
	private int x;
	private int y;
	private int width;
	private int height;
	Image araba;
	public KarsiAraba(int x,int y, int i) {
		araba=new ImageIcon("image/car"+i+".png").getImage();
		this.x=x;
		this.y=y;
		width=araba.getWidth(null);
		height=araba.getHeight(null);
		
	}
	
	public void move() {
		if(y>750) {
			y=-1800;
		}
		y+=4;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Image getImage() {
		return araba;
	}
	
	public Rectangle Cerceve() {
		return new Rectangle(x, y, width, height);
	}
}
