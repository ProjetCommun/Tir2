package delissnyder.robin.tir;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener
{
	@Override
	public void keyTyped(KeyEvent e)
	{
	}
	@Override
	public void keyPressed(KeyEvent e)
	{
		switch (e.getKeyCode())
		{
		case KeyEvent.VK_ENTER:
			if(Main.scene.isDefaite()==true||Main.scene.isVictoire()==true)
			{
				Main.scene.setVieCible1(10);
				Main.scene.setVieJoueur(3);
				Main.scene.setxCible1(5);
				Main.scene.setyCible1(250);
				break;
			}
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}
}
