package polygonExample;

public class Parallelogram extends Trapezium
{
	

	public Parallelogram (Point p[])
	{
		super(p);
		EuclideanLine l1=new EuclideanLine(p[1],p[2]);
		EuclideanLine l2=new EuclideanLine(p[3],p[0]);
		if(!l1.parallel(l2))
			throw new IllegalArgumentException("");
		//vertices=p;
	}
	public Parallelogram (Point p1,Point p2,Point p3,Point p4)
	{
		super(p1, p2, p3, p4);
		EuclideanLine l1=new EuclideanLine(p2,p3);
		EuclideanLine l2=new EuclideanLine(p4,p1);
		if(!l1.parallel(l2))
			throw new IllegalArgumentException("");	
		Point p[]=vertices;
		Line l[] =new Line[p.length];
		for(int i = 0 ; i<p.length;i++)
			l[i]=new Line(p[i],p[(i+1)%p.length]);
		
		
	}
	
	
	//public Parallelogram()
//	{
		
	//}
	
	
	
	public double getArea()
	{
		Line base = new Line(vertices[2], vertices[3]);
		return (base.length()*base.distance(vertices[0]));
	}
	
}


