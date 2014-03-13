package gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.Double;
import java.io.ObjectOutputStream.PutField;
import java.util.Map;
import java.util.Set;
import polygonExample.plane.*;

import javax.naming.Binding;
import javax.print.DocFlavor.INPUT_STREAM;
import javax.script.Bindings;
import javax.script.SimpleBindings;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class DrawerDisplay extends JPanel
{
	//private JLabel label;
	private JPanel xAxisModifocationPanel=new JPanel();
	private JPanel yAxisModifocationPanel=new JPanel();
	private Clickzblelabel yMaxLabel;
	private Clickzblelabel xMaxLabel;
	private Clickzblelabel yMinLabel;
	private Clickzblelabel xMinLabel;
	private Clickzblelabel yGridLabel;
	private Clickzblelabel xGridLabel;
	private Plane Plane=new polygonExample.plane.Plane(-60, 60,-60,60,600,600);
	double YMaxValue=Plane.getYEnd();
	double XMaxValue=Plane.getXEnd();
	double YMinValue=Plane.getYStart();
	double XMinValue=Plane.getXStart();
	double YGridStepValue=Plane.getYGridStep();
	double XGridStepValue=Plane.getXGridStep();
	private JLabel empty=new JLabel("     ");
	
	public DrawerDisplay()
	{
		setLayout(new BorderLayout());
		xAxisModifocationPanel.setLayout(new BorderLayout());
		yAxisModifocationPanel.setLayout(new BorderLayout());
		add(xAxisModifocationPanel,BorderLayout.SOUTH);
		add(yAxisModifocationPanel,BorderLayout.WEST);
		Plane.setLayout(new BorderLayout());
		add(Plane,BorderLayout.CENTER);
		yMaxLabel=new Clickzblelabel(YMaxValue,"Edie Y Max ",3);
		xMaxLabel=new Clickzblelabel(XMaxValue,"Edit X Max ",1);
		yMinLabel=new Clickzblelabel(YMinValue,"Edit Y Min ",4);
		xMinLabel=new Clickzblelabel(XMinValue,"Edit X Min",0);
		xGridLabel=new Clickzblelabel(YGridStepValue,"Edit X Grid value",2);
		yGridLabel=new Clickzblelabel(XGridStepValue,"Edit Y Grid value",5);
		JPanel ewm =new JPanel();
		FlowLayout xewm = new FlowLayout();
		xewm.setAlignment(FlowLayout.LEFT);
		ewm.add(empty);
		ewm.add(xMinLabel);
		xAxisModifocationPanel.add(ewm,BorderLayout.WEST);
		JPanel xgp = new JPanel();
		FlowLayout xgpf = new FlowLayout();
		xgpf.setAlignment(FlowLayout.CENTER);
		xgp.add(xGridLabel);
		xAxisModifocationPanel.add(xgp,BorderLayout.CENTER);
		xAxisModifocationPanel.add(xMaxLabel,BorderLayout.EAST);
		yAxisModifocationPanel.add(yMinLabel,BorderLayout.SOUTH);
		yAxisModifocationPanel.add(yGridLabel,BorderLayout.CENTER);
		yAxisModifocationPanel.add(yMaxLabel,BorderLayout.NORTH);
	}

	class Clickzblelabel extends JLabel implements MouseListener
	{
		private String messageToShow=null;
		int Index=0;
		//constructor:
		public Clickzblelabel(double contenet,String message,int ind) 
		{
			super(Double.toString(contenet));
			Index=ind;
			messageToShow=message;
			this.addMouseListener(this);	
		}
		@Override
		public void mouseClicked(MouseEvent arg0) 
		{
			String input=JOptionPane.showInputDialog(null,"input please",
									 messageToShow,JOptionPane.QUESTION_MESSAGE);
			switch(Index)
			{
			case 0:
				if(Double.parseDouble(input)<Plane.getXEnd())
				{
				Plane.setXBoundaries(Double.parseDouble(input), Plane.getXEnd());
				xMinLabel.setText(Double.toString(Plane.getXStart()));
				xMaxLabel.setText(Double.toString(Plane.getXEnd()));
				}
				else if(Double.parseDouble(input)>Plane.getXEnd())
				{
				Plane.setXBoundaries(Double.parseDouble(input), Plane.getXEnd());
				xMinLabel.setText(Double.toString(Plane.getXStart()));
				xMaxLabel.setText(Double.toString(Plane.getXEnd()));
				String swapMessage="You entered the Xmin > Xmax " +
									"so we swaped them to you ";
				JOptionPane.showMessageDialog(null, swapMessage, "Plesae note..",
						Index,null);
				}
				else/*if =*/
				{
					String errorMessage="You cann't input tow equal number ! \n " +
							"Pleasr retry again  ";
					JOptionPane.showMessageDialog(null, errorMessage , "Plesae note..",
							Index,null);
				}
			break;
			case 1:
				if(Double.parseDouble(input)<Plane.getXEnd())
				{
				Plane.setXBoundaries(Double.parseDouble(input), Plane.getXEnd());
				xMinLabel.setText(Double.toString(Plane.getXStart()));
				xMaxLabel.setText(Double.toString(Plane.getXEnd()));
				}
				else if(Double.parseDouble(input)>Plane.getXEnd())
				{
				Plane.setXBoundaries(Double.parseDouble(input), Plane.getXEnd());
				xMinLabel.setText(Double.toString(Plane.getXStart()));
				xMaxLabel.setText(Double.toString(Plane.getXEnd()));
				String swapMessage="You entered the Xmin > Xmax " +
									"so we swaped them to you ";
				JOptionPane.showMessageDialog(null, swapMessage, "Plesae note..",
						Index,null);
				}
				else/*if =*/
				{
					String swapMessage="You cann't input tow equal number ! \n " +
							"Pleasr retry again  ";
					JOptionPane.showMessageDialog(null, swapMessage, "Plesae note..",
							Index,null);
				}
				break;
			case 3:
				Plane.setYBoundaries(Plane.getYStart(),Double.parseDouble(input));
				yMaxLabel.setText(input);
			break;
			case 4:
				Plane.setYBoundaries(Double.parseDouble(input), Plane.getYEnd());
				yMinLabel.setText(input);
			break;
			case 2:
				Plane.setXGridStep(Double.parseDouble(input));
				xGridLabel.setText(input);
			break;
			case 5:
				Plane.setYGridStep(Double.parseDouble(input));
				yGridLabel.setText(input);
			break;
			}
			Plane.repaint();
			//for debug:
			System.out.println(messageToShow + input+" Index is"+Index);
		}
		@Override
		public void mouseEntered(MouseEvent arg0){/*TODO Auto-generated method stub*/}
		@Override
		public void mouseExited(MouseEvent arg0) {/*TODO Auto-generated method stub*/}
		@Override
		public void mousePressed(MouseEvent arg0){/*TODO Auto-generated method stub*/}
		@Override
		public void mouseReleased(MouseEvent arg0){/*TODO Auto-generated method stub*/}
	}
}