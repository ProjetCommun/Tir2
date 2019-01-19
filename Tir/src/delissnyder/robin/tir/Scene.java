package delissnyder.robin.tir;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Scene extends JPanel
{
	private ImageIcon icoViseur;
	private Image imgViseur;
	private ImageIcon icoCible1;
	private Image imgCible1;
	private ImageIcon icoFond;
	private Image imgFond;
	private ImageIcon icoVictoire;
	private Image imgVictoire;
	private ImageIcon icoDefaite;
	private Image imgDefaite;
	
	private int xCible1;
	private int yCible1;
	private int dxCible1;
	private int dyCible1;
	private int vieCible1;
	private int randomCounter;
	private int vieJoueur;
	
	private boolean click;
	private boolean FinCiblex;
	private boolean FinCibley;
	private boolean victoire;
	private boolean defaite;
	private boolean random;
	private boolean fourth;
	private boolean third;
	private boolean second;
	
	private Thread chronoEcran;
	
	private Graphics g2;
	
	public Scene()
	{
		this.icoViseur = new ImageIcon(getClass().getResource("/images/Viseur.png"));
		this.imgViseur = this.icoViseur.getImage();
		this.icoCible1 = new ImageIcon(getClass().getResource("/images/Cible.png"));
		this.imgCible1 = this.icoCible1.getImage();
		this.icoFond = new ImageIcon(getClass().getResource("/images/Fond.jpg"));
		this.imgFond = this.icoFond.getImage();
		this.icoVictoire = new ImageIcon(getClass().getResource("/images/Victoire.jpg"));
		this.imgVictoire = this.icoVictoire.getImage();
		this.icoDefaite = new ImageIcon(getClass().getResource("/images/Defaite.jpg"));
		this.imgDefaite = this.icoDefaite.getImage();
		
		this.click = false;
		
		this.xCible1 = 0;
		this.yCible1 = 250;
		this.vieCible1 = 10;
		this.randomCounter=0;
		this.vieJoueur=5;
		
		this.FinCiblex=false;
		this.FinCibley=false;
		this.random = false;
		second=false;
		third=false;
		fourth=false;
		
		this.addKeyListener(new Clavier());
		this.addMouseMotionListener(new Souris());
		this.addMouseListener(new SourisBoutons());
		this.setFocusable(true);
		this.requestFocusInWindow();
		
		chronoEcran = new Thread(new ChronoDepart());
		chronoEcran.start();
	}
	public void deplacementsCibles()
	{
		if(this.random==true)
		{
			if(this.xCible1<=0)
			{
				this.xCible1=1;
			}else
			if(this.xCible1>=935)
			{
				this.xCible1=934;
			}
			if(this.yCible1<=0)
			{
				this.yCible1=1;
			}else
			if(this.yCible1>=665)
			{
				this.yCible1=664;
			}
		}
		else
		{
			if(this.xCible1>=0&&this.xCible1<=935)
			{
			}else
			{
				this.FinCiblex=true;
			}
			if(this.FinCiblex==true)
			{
				this.dxCible1=-this.dxCible1;
				if(this.xCible1<=10)
				{
					this.FinCiblex=false;
				}
			}
			if(this.yCible1>=0&&this.yCible1<=665)
			{
			}else
			{
				this.FinCibley=true;
			}
			if(this.FinCibley==true)
			{
				this.dyCible1=-this.dyCible1;
				if(this.yCible1<=10)
				{
					this.FinCibley=false;
				}
			}
		}
		if(this.victoire==true||this.defaite==true) {this.dxCible1=0; this.dyCible1=0;}
	}
	public void contactTir()
	{
		if(this.click==true || Souris.getxSouris()<this.xCible1 || Souris.getxSouris()>this.xCible1+50 || 
		   Souris.getySouris()<this.yCible1||Souris.getySouris()>this.yCible1+50||SourisBoutons.isClicked()==false)
		{	
			if (SourisBoutons.isClicked()==true&&this.click==false)
			{
				this.vieJoueur=this.vieJoueur-1;
				this.click=true;
			}
			this.icoCible1 = new ImageIcon(getClass().getResource("/images/Cible.png"));
			this.imgCible1 = icoCible1.getImage();
		}
		else
		{
			if(this.click==false)
			{this.vieCible1=this.vieCible1-1;
			this.icoCible1 = new ImageIcon(getClass().getResource("/images/CibleTouchée.png"));
			this.imgCible1 = icoCible1.getImage();
			}
			this.click = true;
		}
		switch(this.vieJoueur)
		{
		case 0:
			this.defaite=true;
			break;
		case 5:
			this.defaite=false;
			break;
		}
		switch (this.vieCible1)
		{
		case -1:
			this.vieCible1=0;
			break;
		case 0:
			this.victoire=true; 
			break;
		case 1:
			this.dyCible1=5;
			this.dxCible1=5;
			break;
		case 2:
			this.dyCible1=4;
			this.dxCible1=5;
			break;
		case 3:
			this.dyCible1=4;
			this.dxCible1=4;
			break;
		case 4:
			this.dyCible1=4;
			this.dxCible1=3;
			break;
		case 5:
			this.dyCible1=3;
			this.dxCible1=3;
			break;
		case 6:
			this.dxCible1=3;
			this.dyCible1=2;
			break;
		case 7:
			this.dyCible1=2;
			this.dxCible1=2;
			break;
		case 8:
			this.dxCible1=2;
			this.dyCible1=1;
			this.random=true;
			break;
		case 9:
			this.dyCible1=1;
			this.dxCible1=1;
			break;
		case 10:
			this.dxCible1=1;
			this.victoire=false;
			this.random=false;
			break;
		default:
			break;
		}
	}
	public void randomGen()
	{
		if(this.random==true)
		{
			this.randomCounter=this.randomCounter+1;
			if(this.randomCounter>=35)
			{
				int randomGen = (int)(Math.random()*100); 
				if(randomGen<25&&randomGen>0)
				{this.fourth=false;
				this.third = false;
				this.second = false;
				this.randomCounter=0;
				}
				else 
				if(randomGen<50&&randomGen>25)
				{
					this.fourth=false;
					this.third = false;
					this.second = true;
					this.randomCounter=0;
				}else 
				if(randomGen<75&&randomGen>50)
				{
					this.fourth=false;
					this.third = true;
					this.second = false;
					this.randomCounter=0;
				}
				else 
				if(randomGen<100&&randomGen>75)
				{
					this.fourth=true;
					this.third = false;
					this.second = false;
					this.randomCounter=0;
				}
			}
			if(second==true)
			{
				this.dxCible1=-this.dxCible1;
			}else if(third==true)
			{
				this.dxCible1 =-this.dxCible1;
				this.dyCible1 =-this.dyCible1;
			}else if(fourth==true)
			{
				this.dyCible1 =-this.dyCible1;
			}	
		}
		this.xCible1 = this.xCible1+this.dxCible1;
		this.yCible1 = this.yCible1+this.dyCible1;
	}
	//GETTERS/SETTERS
	public Graphics getG2()
	{
		return g2;
	}
	public boolean isVictoire()
	{
		return victoire;
	}
	public boolean isDefaite()
	{
		return defaite;
	}
	public int getxCible1()
	{
		return xCible1;
	}
	public void setxCible1(int xCible1)
	{
		this.xCible1 = xCible1;
	}
	public int getyCible1()
	{
		return yCible1;
	}
	public void setyCible1(int yCible1)
	{
		this.yCible1 = yCible1;
	}
	public int getVieJoueur()
	{
		return vieJoueur;
	}
	public void setVieJoueur(int vieJoueur)
	{
		this.vieJoueur = vieJoueur;
	}
	public void setG2(Graphics g2)
	{
		this.g2 = g2;
	}
	public ImageIcon getIcoViseur()
	{
		return icoViseur;
	}
	public void setIcoViseur(ImageIcon icoViseur)
	{
		this.icoViseur = icoViseur;
	}
	public Image getImgViseur()
	{
		return imgViseur;
	}
	public void setImgViseur(Image imgViseur)
	{
		this.imgViseur = imgViseur;
	}
	public boolean isClick()
	{
		return click;
	}
	public void setClick(boolean click)
	{
		Main.scene.click = click;
	}
	public int getVieCible1()
	{
		return vieCible1;
	}
	public void setVieCible1(int vieCible1)
	{
		this.vieCible1 = vieCible1;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.g2 = (Graphics2D)g;
		g2.drawImage(imgFond, 0, 0, null);
		this.contactTir();
		this.deplacementsCibles();
		this.randomGen();
		g2.drawImage(imgCible1, xCible1, yCible1, null);
		if(SourisBoutons.isClicked()==true)
		{
			this.icoViseur = new ImageIcon(getClass().getResource("/images/ViseurClick.png"));
			this.imgViseur = icoViseur.getImage();
		}else {this.icoViseur = new ImageIcon(getClass().getResource("/images/Viseur.png"));
		this.imgViseur = icoViseur.getImage();}
		g2.drawImage(imgViseur, Souris.getxSouris()-100,Souris.getySouris()-100, null);
		if(victoire==true)
			g2.drawImage(imgVictoire,0,0,null);
		if (defaite==true)
			g2.drawImage(imgDefaite,0,0,null);
		g2.setColor(new Color(247,21,21));
		g2.drawString(Integer.toString(vieCible1), 20, 20);
		g2.drawString(Integer.toString(vieJoueur), 950, 20);
		
    }
}
