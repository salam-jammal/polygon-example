package polygonExample;

import java.awt.Color;

import javax.swing.JFrame;

import polygonExample.plane.Plane;

public class Test 
{
	public static void main(String a[])
	{
		Plane plane = new Plane(-40, 60, -40, 60, 500, 500);
		Point p= new Point(50,50,"p",Color.red);
		Point p1= new Point(30,30,"p1",Color.yellow);
		Line line=new Line(p,p1);
		//line.setColor(256,256,256);

		/*plane.addElement(p);
		plane.addElement(new Point(0,0,"",Color.GREEN));
		plane.addElement(new Point(-20,-20,"S",Color.BLUE));*/
		
		//Triangle triangle=new Triangle();
		//Trapezium trapezium = new Trapezium(new Point(-10,10), new Point(50,50), new Point(10,10), new Point(0,0));
		//Parallelogram parallelogram = new Parallelogram(new Point(20,0), new Point(10,50), new Point(50,50), new Point(0,0));
		//Rhombus rhombus =new Rhombus();
		//plane.addElement(triangle);
		//plane.addElement(trapezium);
		
		plane.addElement(line);
		JFrame app=new JFrame();
		app.add(plane);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.pack();
		app.setVisible(true);
		app.setResizable(false);
		
	}
}
