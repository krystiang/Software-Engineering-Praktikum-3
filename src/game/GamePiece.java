package game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class GamePiece {
private Image img;


public GamePiece(int x, int y){
	ImageIcon i = new ImageIcon("C:/Users/Krystian/Desktop/Schwarzer_bauer_schach.png");
 img = i.getImage();
}


public Image getImage(){
	return img;
}
}
