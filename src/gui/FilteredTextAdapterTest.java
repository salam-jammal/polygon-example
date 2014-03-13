package gui;

import java.awt.TextField;

import javax.swing.JFrame;


public class FilteredTextAdapterTest 
{
	static FilteredTextAdapter fta =new FilteredTextAdapter(FilteredTextAdapter.ip_ONLY);
	public static void main(String s[])
	{
		JFrame jFrame=new JFrame();
		TextField jtf = new TextField(10);
		jtf.addTextListener(fta);
		jFrame.add(jtf);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		
	}
}
