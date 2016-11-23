package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements MouseListener, ActionListener {

	private static final long serialVersionUID = 8155140574736109939L;
	private int fieldCount;
	private List<GameField> gameFields = new ArrayList<GameField>();
	private Image img;
	//public Graphics2D g2;
	private Timer time;
	private GameField lastClickedGameField;

	// private List<GamePiece> gamePieces = new ArrayList<GamePiece>();

	public Board(int fieldCount) {
		addMouseListener(this);
		this.fieldCount = fieldCount;
		this.time = new Timer(1000, this);
		time.start();
		setGameFields();
		setGamePieces();
	}

	/**
		 * 
		 */

	public void setGamePieces() {
		gameFields.get(7).setPiece(new GamePiece(gameFields.get(7).getX(), gameFields.get(7).getY()));

	}
	
	public void setGameFields(){
		int hoehe = 50;
		int kante = 50;
		int mx = kante;
		int my = hoehe;
		int flag = 0;
		for (int j = 0; j < fieldCount; j++) {
			for (int i = 0; i < fieldCount; i++) {
				gameFields.add(new GameField(mx, my));

				my += hoehe * 2;
			}
			if (flag == 0) {
				my = 2 * hoehe;
				flag = 1;
			} else {
				my = hoehe;
				flag = 0;
			}
			mx += (int) (kante * 1.5);
		}
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		 g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		 RenderingHints.VALUE_ANTIALIAS_ON);

			int hoehe = 50;
			int kante = 50;
		 
for(GameField gf : gameFields){
				int ax = (gf.getX() + kante); // rechter Punkt
				int ay = (gf.getY());
				int bx = (int) (gf.getX() + (kante * 0.5)); // unterer rechter Punkt
				int by = (gf.getY() + hoehe);
				int cx = (int) (gf.getX() - (kante * 0.5)); // unterer linker Punkt
				int cy = (gf.getY() + hoehe);
				int dx = (gf.getX() - kante); // linker Punkt
				int dy = (gf.getY());
				int ex = (int) (gf.getX() - (kante * 0.5)); // oberer linker Punkt
				int ey = (gf.getY() - hoehe);
				int fx = (int) (gf.getX() + (kante * 0.5)); // oberer rechter Punkt
				int fy = (gf.getY() - hoehe);

				Polygon polygon = new Polygon();

				polygon.addPoint(ax, ay);
				polygon.addPoint(bx, by);
				polygon.addPoint(cx, cy);
				polygon.addPoint(dx, dy);
				polygon.addPoint(ex, ey);
				polygon.addPoint(fx, fy);

				g2.drawPolygon(polygon);
}

int i = 0;
		for (GameField gf : gameFields) {
			i++;
			if(gf.getPiece() != null){
				System.out.println(i);
			g2.drawImage(gf.getPiece().getImage(), gf.getX(), gf.getY(), null);
			}
			else{
     			g2.setColor(Color.WHITE);
				g2.fillRect(gf.getX(), gf.getY(), 33, 43);
				g2.drawRect(gf.getX(), gf.getY(), 33, 43);
			}
		}

	}

	public void mousePressed(MouseEvent event) {
		GameField nearestGameField = gameFields.get(0);
		for (GameField gf : gameFields) {
			if ((Math.sqrt(Math.pow((gf.getX() - event.getX()), 2)
					+ Math.pow((gf.getY() - event.getY()), 2))) < (Math
					.sqrt(Math.pow((nearestGameField.getX() - event.getX()), 2)
							+ Math.pow((nearestGameField.getY() - event.getY()),
									2)))) {
				nearestGameField = gf;
			}
		}
		System.out.println(nearestGameField.getX()+ " " + nearestGameField.getY());
		lastClickedGameField = nearestGameField;

	}
	
	public void mouseReleased(MouseEvent event) {
		GameField nearestGameField = gameFields.get(0);
		for (GameField gf : gameFields) {
			if ((Math.sqrt(Math.pow((gf.getX() - event.getX()), 2)
					+ Math.pow((gf.getY() - event.getY()), 2))) < (Math
					.sqrt(Math.pow((nearestGameField.getX() - event.getX()), 2)
							+ Math.pow((nearestGameField.getY() - event.getY()),
									2)))) {
				nearestGameField = gf;
			}
		}
		System.out.println(nearestGameField.getX()+ " " + nearestGameField.getY());
		System.out.println(nearestGameField.getPiece());
		nearestGameField.setPiece(lastClickedGameField.getPiece());
		if(lastClickedGameField != nearestGameField){
		lastClickedGameField.setPiece(null);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
