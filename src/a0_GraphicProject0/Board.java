package a0_GraphicProject0;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
	private Timer timer;
	private Araba araba;
	private MoveRoad road;
	private Image bitis;
	private int puan = 0;
	// --------------------
	private ArrayList karsiaraba;
	private boolean carpma;
	private int[][] pozisyon = { { 190, -1100, 1 }, { 270, -2000, 2 }, { 370, -1600, 3 }, { 480, -600, 4 },
			{ 190, -1500, 4 }, { 270, -2900, 1 }, { 370, -2500, 7 }, { 480, -2800, 8 }, { 480, -4400, 1 } };

	public Board() {
		Ekran();
		TimerBaslat();
		carpma = false;
		karsiAraba();
		bitis = new ImageIcon("image/road2.png").getImage();
	}

	private void karsiAraba() {
		karsiaraba = new ArrayList();
		for (int i = 0; i < pozisyon.length; i++) {
			karsiaraba.add(new KarsiAraba(pozisyon[i][0], pozisyon[i][1], pozisyon[i][2]));
		}
	}

	private void Ekran() {
		setFocusable(true);
		setDoubleBuffered(true);
		setBackground(Color.gray);
		// --------------------------------
		addKeyListener(new KeyOlaylari());
		araba = new Araba();
		road = new MoveRoad();
	}

	private void TimerBaslat() {
		timer = new Timer(5, this);
		timer.start();
	}

	private void cizimYap(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHints(rh);
		if (!carpma) {
			g2d.drawImage(road.getImage(), 0, road.getY(), this);
			g2d.drawImage(araba.getImage(), araba.getX(), araba.getY(), this);
			for (int i = 0; i < karsiaraba.size(); i++) {
				puanArtir();
				KarsiAraba a = (KarsiAraba) karsiaraba.get(i);
				g2d.drawImage(a.getImage(), a.getX(), a.getY(), null);
			}
			Font small = new Font("Arial", Font.BOLD, 30);
			FontMetrics metr = this.getFontMetrics(small);
			g2d.setColor(Color.white);
			g2d.setFont(small);
			g2d.drawString("Skore:" + puan / 40, 580, 40);
			if (puan / 40 > 100) {
				timer.setDelay(4);
			}
			if (puan / 40 > 300) {
				timer.setDelay(3);
			}
		}
		if (carpma) {
			timer.stop();
			String mesaj = "Game Over";
			Font small = new Font("Arial", Font.BOLD, 40);
			FontMetrics metr = this.getFontMetrics(small);
			g2d.drawImage(bitis, 0, 0, null);
			g2d.setColor(Color.white);
			g2d.setFont(small);
			g2d.drawString(mesaj, 260, 335);
			g2d.setFont(new Font("Arial", Font.BOLD, 15));
			g2d.drawString("Skore:" + puan / 40, 325, 360);

			JButton bt=new JButton();
			bt.setBackground(Color.BLUE);
			bt.setLabel("Retry");
			bt.setForeground(Color.white);
			bt.setSize(100, 35);
			bt.setLocation(300, 400);
			add(bt);
			bt.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					ArabaYarisi arabaYarisi=new ArabaYarisi();
					arabaYarisi.setVisible(true);
					
				}
			});
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		cizimYap(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < karsiaraba.size(); i++) {
			KarsiAraba a = (KarsiAraba) karsiaraba.get(i);
			a.move();
		}

		araba.Tasi();
		road.yolTasi();
		carpismaKontrolEt();
		puan++;
		repaint();
	}

	private void carpismaKontrolEt() {
		Rectangle r = araba.Cerceve();
		for (int i = 0; i < karsiaraba.size(); i++) {
			KarsiAraba a = (KarsiAraba) karsiaraba.get(i);
			Rectangle r1 = a.Cerceve();
			if (r.intersects(r1)) {
				carpma = true;
			}
		}
	}

	public void puanArtir() {
		puan++;
	}

	public class KeyOlaylari extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			araba.KeyPress(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			araba.KeyReleased(e);
		}
	}
}
