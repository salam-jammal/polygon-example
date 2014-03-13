package polygonExample;

public class Rectangel extends Parallelogram 
{
	public Rectangel (Point p[])
	{
		super(p);
		Line l[] =new Line[p.length];
		for(int i = 0 ; i<p.length;i++)
			l[i]=new Line(p[i],p[(i+1)%p.length]);
		EuclideanLine euclideanLine[] =new EuclideanLine[l.length];
		for (int i = 0; i < l.length; i++)
			if (euclideanLine[i].getAngle(euclideanLine[i+1])!=Math.PI/2) 
				throw new IllegalArgumentException("");	
		vertices=p;		
	}

}
