package polygonExample;

import java.awt.Graphics;

import polygonExample.plane.Plane;


public abstract class Polygon implements DrawableIn2DPlane
{	
	protected int sidesCount ;
	protected Point vertices[];
	
	public Polygon(Point p[]) 
	{
		if (p.length > 2)
		{
			for (int i = 0 ; i<p.length-1 ; i++)
				for (int j = i+1 ; j<p.length ; j++)
					if (p[i]==p[j])
						throw new IllegalArgumentException("Dublicated Vertex:"+p[i]+"at indexes["+i+"] and ["+j+"]") ;
			sidesCount=p.length;
		}
		else 
			throw new  IllegalArgumentException("vertices array of length of 2 or less in PolygonExample.Polygone.Polygon(Point p[]) ");
	}
	
	public Polygon()
	{
		Point Square[]={new Point(1,1),new Point(-1,1),new Point(-1,-1),new Point(1,-1)};
		vertices=Square;
		sidesCount=4;
	}
	
	public abstract double getArea();
	
	public  Polygon vectorShift(double u,double v)
	{
		for(int i =0 ; i<this.sidesCount; i++)
			vertices[i].vectorShift(u, v);		
		return this;
	}
	
	public boolean equals(Polygon p)
	{
		if(sidesCount!=p.sidesCount)
			return false;
		for(int i=0;i<sidesCount;i++)
			if(!vertices[i].equals(p.vertices[i]))
				return false;	
		return true;
	}
	
	public void movePoint(int i , Point p)
	{
		if(i>sidesCount)
			throw new IllegalArgumentException("Polygon.movePoint(int i='"+i+"'> 'sidesCount="+sidesCount+"' , Point p)");
		vertices[i]=p;
		
	}
	public void sheftPoint(int i , double u , double v)
	{
		if(i>sidesCount)
			throw new IllegalArgumentException("Polygon.sheftPoint(int i='"+i+"'> 'sidesCount="+sidesCount+"' , Point p)");
		vertices[i].vectorShift(u, v);
	
	}
	public int drawMe(Plane p, Graphics g)
	{
		int retval=fitIn(p);
		if(retval==0)
		{
			for(int i=0;i<sidesCount;i++)
			{
				Line line=new Line(vertices[i],
									vertices[(i+1)%sidesCount]);
				line.drawMe(p, g);
			}
		}
		return retval;
	}
	
	public int fitIn(Plane p) 
	{
		int retval=0;
		for(int i=0;i<sidesCount;i++)
			retval +=vertices[i].fitIn(p);
		return retval;
	}
}
