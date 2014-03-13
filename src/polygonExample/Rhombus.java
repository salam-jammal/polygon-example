package polygonExample;

public class Rhombus extends Parallelogram 
{
	
	public Rhombus (Point p[])
	{
		super(p);
		Line l[] =new Line[p.length];
		for(int i = 0 ; i<p.length;i++)
			l[i]=new Line(p[i],p[(i+1)%p.length]);
		for (int i = 0; i < l.length; i++)
			if (l[i].length()!=l[i+1].length()) 
				throw new IllegalArgumentException("");	
		vertices=p;		
	}
}
