package delissnyder.robin.tir;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SourisBoutons implements MouseListener
{
	private static boolean isClicked = false;
	private static int xClick;
	private static int yClick;
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
	}
	@Override
	public void mousePressed(MouseEvent e)
	{
		xClick = e.getX();
		yClick = e.getY();
		isClicked = true;
	}
	public static boolean isClicked()
	{
		return isClicked;
	}
	public static int getxClick()
	{
		return xClick;
	}
	public static int getyClick()
	{
		return yClick;
	}
	public static void setyClick(int yClick)
	{
		SourisBoutons.yClick = yClick;
	}
	public static void setClicked(boolean isClicked)
	{
		SourisBoutons.isClicked = isClicked;
	}
	public static void setxClick(int xClick)
	{
		SourisBoutons.xClick = xClick;
	}
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
		isClicked = false;
		Main.scene.setClick(false);
	}
	@Override
	public void mouseEntered(MouseEvent e)
	{
	}
	@Override
	public void mouseExited(MouseEvent e)
	{
	}
}
