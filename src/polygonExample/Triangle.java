package polygonExample;

import java.awt.Graphics;

import polygonExample.plane.Plane;


public class Triangle extends CanonicalPolygon 
{
	public Triangle()
	{
		Point p[]={new Point(0,10), new Point(-5,0) ,new Point(5,0)};
		vertices=p;
		sidesCount =3;
	}
	public Triangle(double diameter)
	{
		super(3, diameter);
	}
	public Triangle(double diameter, double angle)
	{
		super(3, diameter, angle);
	}
	public Triangle(Point p, double diameter, double angle)
	{
		super(p, 3, diameter, angle);
	}
	public Triangle(Point p1,Point p2,Point p3)
	{
		Point p[]={p1,p2,p3};
		vertices=p;
	}
	
	public double getArea()
	{
		Line base=new Line(vertices[0], vertices[1]);
		return base.length()*base.distance(vertices[2])/2;
	}
	
	
}
