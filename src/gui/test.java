package gui;

import javax.swing.JFrame;


public class test
{
	public static void main(String a[])
	{
		MotherWindow m=new MotherWindow();	
		m.pack();
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setResizable(false);
		m.setVisible(true);
	}
}



