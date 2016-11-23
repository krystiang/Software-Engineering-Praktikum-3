package game;

import java.awt.*;
import javax.swing.*;

class Frame extends JFrame{

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 500);
		Board board = new Board(5);
		f.add(board);
		f.setVisible(true);
	}
}
