package polygonExample;

import java.awt.Graphics;

import polygonExample.plane.Plane;

public class Trapezium extends CanonicalQuadrilateral
{
	public static final int sidesCount=4;
	public Trapezium (Point p1,Point p2,Point p3,Point p4)
	{
		orderPoints(p1, p2, p3, p4);
		Point p[]=vertices;
		Line l[] =new Line[p.length];
		for(int i = 0 ; i<p.length;i++)
			l[i]=new Line(p[i],p[(i+1)%p.length]);
		/*for (int i = 0; i < l.length; i++) 
			for (int j = i+1; j < l.length; j++)
			{ 
				if(l[i].intersects(l[j]))
					throw new IllegalArgumentException("the line "+i+" and the line "+j+" is Intersecting");
			 }*/
		vertices=p;
	}
	public Trapezium (Point p[])
	{
		this(p[0], p[1], p[2], p[3]);
	}
	
	public Trapezium (Line l1,Line l2)
	{
		this(l1.startPoint, l1.endPoint, l2.startPoint, l2.endPoint);
	}
		
	public double getArea()
	{
		Line base1=new Line(vertices[0], vertices[1]);
		Line base2=new Line(vertices[2], vertices[3]);
		return ((base1.length()+base2.length())*base1.distance(base2))/2;
	}
	@Override
	public int drawMe(Plane p, Graphics g)
	{
		return super.drawMe(p, g);
	}
	public void orderPoints  (Point p1,Point p2,Point p3,Point p4)
	{
		EuclideanLine l1= new EuclideanLine(p1, p2);
		EuclideanLine l2= new EuclideanLine(p3, p4);
		EuclideanLine l3= new EuclideanLine(p1, p3);
		EuclideanLine l4= new EuclideanLine(p2, p4);
		EuclideanLine l5= new EuclideanLine(p1, p4);
		EuclideanLine l6= new EuclideanLine(p2, p3);
		if (l1.parallel(l2)) 
		{
			if(checkDirection(l1, l2))
				 vertices=mackArrPoint (p1,p2,p4,p3);
			else 
				vertices=mackArrPoint(p1,p2,p3,p4);
		}
		else if (l3.parallel(l4)) 
		{
			if(checkDirection(l3, l4))
				 vertices=mackArrPoint (p1,p3,p4,p2);
			else 
				vertices=mackArrPoint(p1,p3,p2,p4);
		}
		else if (l5.parallel(l6)) 
		{
			if(checkDirection(l5, l6))
				 vertices=mackArrPoint (p1,p4,p2,p3);
			else 
				vertices=mackArrPoint(p1,p4,p3,p2);
		}
		else 
			throw new IllegalArgumentException("");		
	}
	protected Point[] mackArrPoint(Point p1,Point p2,Point p3,Point p4)
	{
		Point ret[]=  new Point[4];
		ret[0]=p1;
		ret[1]=p2;
		ret[2]=p3;
		ret[3]=p4;
		return ret; 		
	}
		
	
	protected boolean checkDirection(EuclideanLine l1,EuclideanLine l2)
	{
		if (l1.getDirection()==l2.getDirection())
			return true;	
		return false;
	}

}

