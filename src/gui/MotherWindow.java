package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;

import org.omg.CORBA.PRIVATE_MEMBER;

public class MotherWindow extends JFrame
{
	 private Editor editor=new Editor();
	 private DrawerDisplay drawerDisplay=new DrawerDisplay();
		JMenuBar menuBar;
		JMenu File;
		JMenuItem Exit;
	public MotherWindow() 
	{
		menuBar=new JMenuBar();
		File=new JMenu("File");
		Exit=new JMenuItem("Exit");

		setLayout(new BorderLayout(5,5));
		add(editor,BorderLayout.SOUTH);
		add(drawerDisplay,BorderLayout.CENTER);
		add(menuBar,BorderLayout.NORTH);
		menuBar.add(File);
		File.add(Exit);
		
		exitListener e=new exitListener();
		Exit.addActionListener(e);
	}
	
	
	public class exitListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	}
}
