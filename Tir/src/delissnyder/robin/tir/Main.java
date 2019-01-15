package delissnyder.robin.tir;

import javax.swing.JFrame;

public class Main 
{
    public static Scene scene;
    
	public static void main(String[] args) 
	
	{ 
		JFrame frame = new JFrame("Projet");
		frame.setSize(1000, 750);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		scene = new Scene();
		frame.setContentPane(scene);
		frame.setVisible(true);
	}

}
