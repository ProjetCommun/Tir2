package delissnyder.robin.tir;
public class ChronoDepart implements Runnable
{
	private int pause = 15;
	@Override
	public void run()
	{
		while(true)
		{
			Main.scene.repaint();
			try
			{
				Thread.sleep(pause);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
