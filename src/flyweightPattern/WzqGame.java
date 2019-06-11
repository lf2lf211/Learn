package flyweightPattern;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class WzqGame {
	public static void main(String[] args) {
		new Chessboard();
	}
}

//棋盤
class Chessboard extends MouseAdapter {
	WeiqiFactory factory;
	JFrame jframe;
	Graphics graphic;
	JRadioButton wz;
	JRadioButton bz;
	private final int x = 50;
	private final int y = 50;
	private final int w = 40; // 小方格寬度和高度
	private final int rw = 560; // 棋盤寬度和高度

	Chessboard() {
		//創建享元工廠
		factory = new WeiqiFactory();
		jframe = new JFrame("享元模式在五子棋遊戲中的應用");
		// 視窗位置、大小
		jframe.setBounds(100, 100, 670, 720);
		jframe.setVisible(true);
		jframe.setResizable(false);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 新增面板
		JPanel SouthJP = new JPanel();
		jframe.add("South", SouthJP);
		// 新增選擇按鈕
		wz = new JRadioButton("白子");
		bz = new JRadioButton("黑子", true);
		ButtonGroup group = new ButtonGroup();
		group.add(wz);
		group.add(bz);
		SouthJP.add(wz);
		SouthJP.add(bz);
		JPanel CenterJP = new JPanel();
		CenterJP.setLayout(null);
		CenterJP.setSize(500, 500);
		CenterJP.addMouseListener(this);
		jframe.add("Center", CenterJP);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		graphic = CenterJP.getGraphics();
		graphic.setColor(Color.BLUE);
		graphic.drawRect(x, y, rw, rw);
		for (int i = 1; i < 14; i++) {
			// 繪製第i條豎直線
			graphic.drawLine(x + (i * w), y, x + (i * w), y + rw);
			// 繪製第i條水平線
			graphic.drawLine(x, y + (i * w), x + rw, y + (i * w));
		}
	}

	public void mouseClicked(MouseEvent e) {
		Point pt = new Point(e.getX() - 15, e.getY() - 15);
		if (wz.isSelected()) {
			//按左鍵
			if(!e.isMetaDown()) {
				//取出享元物件(棋子)，傳入非享元參數(point)
				ChessPieces c1 = factory.getChessPieces("w");
				c1.DownPieces(graphic, pt);
			} //按右鍵
			else {
				ChessPieces c1 = factory.getChessPieces("b");
				c1.DownPieces(graphic, pt);
			}
			
		} else if (bz.isSelected()) {
			//按左鍵
			if(!e.isMetaDown()) {
				ChessPieces c2 = factory.getChessPieces("b");
				c2.DownPieces(graphic, pt);
			} //按右鍵
			else {
				ChessPieces c2 = factory.getChessPieces("w");
				c2.DownPieces(graphic, pt);
			}
		}
	}
}

//抽象享元角色：棋子
interface ChessPieces {
	public void DownPieces(Graphics g, Point pt); // 下子
}

//具體享元角色：白子
class WhitePieces implements ChessPieces {
	public void DownPieces(Graphics g, Point pt) {
		g.setColor(Color.WHITE);
		g.fillOval(pt.x, pt.y, 30, 30);
	}
}

//具體享元角色：黑子
class BlackPieces implements ChessPieces {
	public void DownPieces(Graphics g, Point pt) {
		g.setColor(Color.BLACK);
		g.fillOval(pt.x, pt.y, 30, 30);
	}
}

//享元工廠角色
class WeiqiFactory {
	private ArrayList<ChessPieces> qz;

	public WeiqiFactory() {
		qz = new ArrayList<ChessPieces>();
		ChessPieces w = new WhitePieces();
		qz.add(w);
		ChessPieces b = new BlackPieces();
		qz.add(b);
	}

	public ChessPieces getChessPieces(String type) {
		if (type.equalsIgnoreCase("w")) {
			return (ChessPieces) qz.get(0);
		} else if (type.equalsIgnoreCase("b")) {
			return (ChessPieces) qz.get(1);
		} else {
			return null;
		}
	}
}
