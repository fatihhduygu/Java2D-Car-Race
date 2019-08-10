package a0_GraphicProject0;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ArabaYarisi extends JFrame {
	public ArabaYarisi() {
		Cerceve();
	}

	private void Cerceve() {
		add(new Board());
		setTitle("Araba Yarisi");
		setSize(750, 750);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				ArabaYarisi oyna = new ArabaYarisi();
				oyna.setVisible(true);
			}
		});

	}

}
