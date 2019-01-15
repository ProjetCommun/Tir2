package delissnyder.robin.tir;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Souris implements MouseMotionListener
{
	private static int xSouris;
	private static int ySouris;
	@Override
	public void mouseMoved(MouseEvent e)
	{
		xSouris = e.getX();
		ySouris = e.getY();
	}
	public static int getxSouris()
	{
		return xSouris;
	}
	public static int getySouris()
	{
		return ySouris;
	}
	@Override
	public void mouseDragged(MouseEvent e)
	{
		xSouris = e.getX();
		ySouris = e.getY();
	}
}
