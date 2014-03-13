package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.print.attribute.standard.MediaSize.Other;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import org.omg.CORBA.PUBLIC_MEMBER;

import polygonExample.Line;
import polygonExample.Parallelogram;
import polygonExample.Point;
import polygonExample.Trapezium;
import polygonExample.Triangle;
import polygonExample.plane.Plane;

public class Editor extends JPanel
{
	private JButton editFigureButton=new JButton("Edit polygon");
	private JButton addFigureButton=new JButton("Add polygon");
	public Plane Plane;
	

	public Editor() 
	{
		FlowLayout layout= new FlowLayout();
		setLayout(layout);
		layout.setAlignment(FlowLayout.CENTER);
		add(editFigureButton);
		add(addFigureButton);
		//layout.setAlignment(FlowLayout.LEADING);
			
		editFigureButton.addActionListener
		(		new ActionListener() 
				{ public void actionPerformed(ActionEvent a) {edit();} }
		);
		addFigureButton.addActionListener
		(		new ActionListener() 
				{ public void actionPerformed(ActionEvent a) {add();} }
		);
	}
	public void add()
	{
		
		int k = 0 ;
		String possibleValues[]={"Point","Line","Triangle","Trapezium"," Parallelogram","Rectangel","Rhombus","square"};
		String shape =
				(String) JOptionPane.showInputDialog(
									getParent(),
									"Select the shape",
									"Selective",
									JOptionPane.QUESTION_MESSAGE,
									null, // an Icon
									possibleValues,
									possibleValues[0]);
		
			int numOfPoint=1;
			switch (shape) 
			{
				case "Point":
					numOfPoint=1;
					break;
				case "Line":
					numOfPoint=2;
					break;
				case "Triangle":
					numOfPoint=3;
					break;
				case "Trapezium" :
				case "Parallelogram" :
				case "Rectangel":
				case "Rombus":
				case "square":
					numOfPoint=4;
					break;
			}	
		
				PointsAcquzier m = new PointsAcquzier(numOfPoint);
			
//				Point[] q =new Point[numOfPoint];
//						q=m.confirm();
//				for (int i = 0; i <q.length; i++) //just for test 
//					{
//						System.out.println(q[i]);
//					}
//					switch (q.length) 
//					{
//						case 1:
//							Point point=q[1];
//							Plane.addElement(point);
//							break;
//						case 2:
//							Line line=new Line(q[1],q[2]);
//							Plane.addElement(line);
//							break;
//						case 3:
//							Triangle triangle=new Triangle(q[1],q[2],q[3]);
//							Plane.addElement(triangle);
//							break;
////						case 4:
//											
				//	}
			
		
	}
	
	public void edit()
	{	
	}
	
}
