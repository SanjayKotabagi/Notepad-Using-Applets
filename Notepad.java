import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Notepad extends Applet implements KeyListener {
	double res = 0;
	String text = "";
	Font f1;
	int sc = 0;
	int line = 10;
	Object color = Color.GREEN;
	static void drawString(Graphics g, String text, int x, int y) {
	    int lineHeight = g.getFontMetrics().getHeight();
	    for (String line : text.split("\n"))
	        g.drawString(line, x, y += lineHeight);
	}
	public void init() {
		setSize(900,800);
		f1 = new Font("Arial",Font.ROMAN_BASELINE,20);   
		addKeyListener(this);
		setFont(f1);
	}
	public void paint(Graphics g) {
		if(sc == 1) {
			g.setColor(Color.black);
		}
		if(sc == 2) {
			g.setColor(Color.red);
		}
		if(sc == 3) {
			g.setColor(Color.blue);
		}
		if(sc == 4) {
			g.setColor(Color.magenta);
		}
		Notepad.drawString(g,text, 10, line);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		try {
			if( e.getExtendedKeyCode() == 8) {
				text = text.substring(0, text.length()-1);
			}
			else if(e.getExtendedKeyCode() == 112) {
				sc = 1;
			}
			else if(e.getExtendedKeyCode() == 113) {
				sc = 2;
			}
			else if(e.getExtendedKeyCode() == 114) {
				sc = 3;
			}
			else if(e.getExtendedKeyCode() == 115) {
				sc = 4;
			}
			else if(e.getExtendedKeyCode() == 27) {
				text = "";
			}
			else if(e.getExtendedKeyCode() == 10) {
				text += "\r\n";
			}
			else {
				text += e.getKeyChar();
			}
		}
		catch(Exception exc) {
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

}
