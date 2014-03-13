package gui;

import gui.MotherWindow.exitListener;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Closeable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import polygonExample.Line;
import polygonExample.Point;
import polygonExample.Triangle;
import polygonExample.plane.Plane;

public class PointsAcquzier extends JFrame

{
	PointAcquzier pas[];
	
	JButton confirmButton =new JButton("Ok");
	JButton backButton =new JButton("cancel");
	JPanel buttonJPanel =new JPanel();
	JPanel panels =new JPanel();

	JPanel nameAndColorPanel =new JPanel();
	JLabel nameOfPolygonJLabel=new JLabel("name: ");	
	JLabel colorOfPolygonJLabel=new JLabel("color: ");	
	JTextField nameOfPolygon=new JTextField(5);
	JTextField colorOfPolygon=new JTextField(" 256,256,256 ");
	public String getpolygonName(){return nameOfPolygon.getText();}
	public String getcolor(){return colorOfPolygon.getText();}
	
	
	public class PointAcquzier extends JPanel 
	{
		JTextField 	xField =new JTextField(4);
		JTextField 	yField =new JTextField(4);
		JTextField 	nameField =new JTextField(3);
		JLabel 	message =new JLabel("Enter point: Name: ");
		JLabel 	xLable =new JLabel("x:");
		JLabel 	yLable =new JLabel("y:");
		
		public double getXVal(){return Double.parseDouble(xField.getText());}
		public double getYVal(){return Double.parseDouble(yField.getText());}
		public String getName(){return nameField.getText();}
		public void setnamefiled(String name){}
		
		public PointAcquzier ()
		{
			FlowLayout layout= new FlowLayout();
			setLayout(layout);
			layout.setAlignment(FlowLayout.CENTER);
			
			add(message);
			add(nameField);
			add(xLable);
			add(xField);
			add(yLable);
			add(yField);
		}		
	}
	
	public PointsAcquzier (int num)
	{
		
		setLayout(new BorderLayout(5,0));
		
		pas=new PointAcquzier[num];
		panels.setLayout(new GridLayout(num+1,1));
		for(int i=0;i<num;i++)
		{
			pas[i]=new PointAcquzier();
			panels.add(pas[i]);
		}
		setSize(300,300);
		

		FlowLayout slayout= new FlowLayout();
		nameAndColorPanel.setLayout(slayout);
		slayout.setAlignment(FlowLayout.CENTER);
		nameAndColorPanel.add(nameOfPolygonJLabel);
		nameAndColorPanel.add(nameOfPolygon);
		nameAndColorPanel.add(colorOfPolygonJLabel);
		nameAndColorPanel.add(colorOfPolygon);		
		
		FlowLayout layout= new FlowLayout();
		buttonJPanel.setLayout(layout);
		layout.setAlignment(FlowLayout.CENTER);
		buttonJPanel.add(confirmButton);
		buttonJPanel.add(backButton);
		
		add(panels,BorderLayout.CENTER);
		add(nameAndColorPanel,BorderLayout.NORTH);
		add(buttonJPanel,BorderLayout.SOUTH);
		
		colorOfPolygon.setEditable(false);
		confirmButton.addActionListener
		(		new ActionListener() 
					{ public void actionPerformed(ActionEvent a) {confirm();} }
		);
		nameOfPolygon.addActionListener
		(		new ActionListener() 
					{ public void actionPerformed(ActionEvent a) {nameIt();} }
		);
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	public void nameIt()
	{
		for(int i=0;i<pas.length;i++)
		{
			pas[i].nameField.setText(getpolygonName()+i);
			
		}
	}
	public Point[] confirm()
	{
		Point[] p = new Point[pas.length];
		for(int i=0;i<pas.length;i++)
		{	
		 p[i]=new Point(pas[i].getXVal(),pas[i].getYVal(),pas[i].getName());
		 System.out.println(p[i]);
		}
		return p;	
	}
}
