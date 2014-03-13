package polygonExample;

import java.awt.Color ;
import java.awt.Graphics;

import polygonExample.plane.Plane;

public class Point implements DrawableIn2DPlane
{
	public double x;
	public double y;
	private String name;
	private Color color;
	
	private static int anonymousPointsCounter = 0;
	
	public static final int WITHPOINTNAME=1;
	public static final int WITHOUTNAME=0;
	
	public String getPointName(){return name;}
	public Color getPointColor(){return color;}
	
	
	public Point(double x , double y, String name , Color color)
	{
		this.x= x;
		this.y= y;
		this.name = name;
		this.color = color;	
	}
	public Point(double x , double y , String name)
	{
		this(x,y,name,Color.BLUE);
	}
	public Point(double x , double y)
	{
		this(x,y,"anonymousPoint"+anonymousPointsCounter++);
	}	
	public Point()
	{
		this (0,0);
	}
	public Point(Point p)
	{
		this(p.x,p.y,p.getPointName()+"copy",p.getPointColor());
	}
	
	public Point setPosition(double x  , double y )
	{
		this.x= x;
		this.y= y;
		return this;
	}
	public Point vectorShift(double u,double v)
	{
		x+= u;
		y+= v;
		return this;
	}
	
	public Point vectorShiftCopy(double u,double v)
	{
		return new Point(x+u,y+v,name+"copy",color);
	}
	
	public boolean equals(Point p)
	{
		if (p.x == x&& p.y == y)
			return true;
		/*else*/ 
			return false;
	}
	
	public String toString()
	{
		return new String(name+toString(WITHOUTNAME ));
	}
	
	public String toString(int i)
	{
		if (i==Point.WITHPOINTNAME)
		{
			return toString();
		}
		else 
			return  new String("("+ x+ "," + y+ ")");
	}
	
	public double distance(Point p)
	{
		return Math.sqrt(distanceSquared(p)) ;
	}
	
	public double distance(double px , double py)
	{
		
		return distance(new Point(px, py));
	}
	
	public double distance()
	{
		return distance(new Point(0,0));
	}
	
	public double distanceSquared(Point p)
	{
		return Math.pow( x- p.x,2) + Math.pow( y- p.y,2) ;
	}
	
	public double distanceSquared(double px , double py)
	{
		return distanceSquared(new Point (px,py));
	}
	
	public double distanceSquared()
	{
		return distanceSquared(new Point (0,0));
	}
	
	public int drawMe(Plane plane, Graphics g)
	{
		int retval = fitIn(plane);
		if (retval ==0)
		{
			Color tempColor=g.getColor();
			g.setColor(color);
			g.fillOval(convertX(plane)-4,convertY(plane)-4 ,8 ,8 );
			g.setColor(tempColor);
		}
		return retval ;
	}
	
	protected int convertX(Plane p)
	{
		return (int)(p.getWidth()*((x-p.getXStart())/(p.getXEnd()-p.getXStart())));
	}
	protected int convertY(Plane p)
	{
		return (int) (p.getHeight()*((p.getYEnd()-y)/(p.getYEnd()-p.getYStart())));
	}
	
	public int fitIn(Plane plane)
	{
		if(x<plane.getXStart())
			return -1;
		if(x>plane.getXEnd())
			return -1;
		if(y<plane.getYStart())
			return -1;
		if(y>plane.getYEnd())
			return -1;
		/*else if x E [xs,xe] and y E [ys,ye]*/ 
			return 0;
	}
}