package gui;

import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.script.SimpleBindings;

public class FilteredTextAdapter implements TextListener
{
	public static final int NUMBER_ONLY=0;
	public static final int STRING_ONLY=1;
	public static final int ip_ONLY=2;
	private int fildType;
	public FilteredTextAdapter(int ft)
	{
		fildType=ft;
	}
	public void textValueChanged(TextEvent arg0)
	{
		String newString="";
		String s="";
		Object object=arg0.getSource();
		if(object instanceof TextField)
		{
			s=((TextField) object).getText();
			if (fildType==1) 
				newString=checkname(s);
			else if(fildType==2)
				newString=checkIp(s);
			
			if (s.compareTo(newString)!=0) 
				((TextField) object).setText(newString);
		}
		else if(object instanceof TextArea)
		{
			s=((TextArea) object).getText();
			if (fildType==1) 
				newString=checkname(s);
			else if(fildType==0)
				newString=checkNum(s);
				if (s.compareTo(newString)!=0) 
					((TextArea) object).setText(newString);
		}
	}
	
	public String checkname(String s)
	{
		String ss="";
		System.out.println(s.length());
		for (int i = 0; i < s.length(); i++)
		{
			
			if(!Character.isAlphabetic(s.charAt(i)))
				continue;
			ss +=s.charAt(i);
		}
		return ss;
	}
	public String checkNum(String s)
	{
		String ss="";
		System.out.println(s.length());

		for (int i = 0; i < s.length(); i++)
		{
			if(!Character.isDigit(s.charAt(i)))
			{
				continue;	
			}	
			ss +=s.charAt(i);
		}
		return ss;
	}
	public String checkIp (String stringsource)
	{
		int dotcounter=0;
		String s="";
		String test="";
		for(int i=0;i<stringsource.length();i++)
		{
			if(Character.isDigit(stringsource.charAt(i)))
			{
				test +=stringsource.charAt(i);
				if(Integer.parseInt(test) <255)
					s+=stringsource.charAt(i);
				else 
					continue;	
			}
			else if (stringsource.charAt(i)=='.'& dotcounter<3 & stringsource.charAt(i)!=stringsource.charAt(i-1)) /* TODO*/
			{
				s +='.';
				dotcounter++;
				test="";
				if( dotcounter>3)
					break;
			}
				
		}
		
		return s;
	}
	
//	private String checkBySplite(String stringsource,String spliter,int counter,int maxvalue)
//	{
//
//		String[] splited=stringsource.split(spliter);
//		String ss="";
//
//		if (splited.length<=counter && splited.length>0)
//			for (int i = 0; i < splited.length; i++) 
//			{
//				int j=Integer.parseInt(splited[i]);
//				if(j<=maxvalue &&j>0)
//				{
//					if(i!= counter)
//						ss +=splited[i]+spliter;
//					else
//						ss +=splited[i];
//				}	
//				else 
//					break;
//			}
//		return ss;
//	}
//	public String checkIpAdd (String s)
//	{
//		return checkBySplite(s,".",4,255);	
//	}
//	public String checkIntColor (String s)
//	{
//		return checkBySplite(s,",",3,255);	
//	}
//	public String checkHexColor(String s)
//	{
//		String rColor="";
//		String gColor="";
//		String bColor="";
//		int r=0;
//		int g=0;
//		int b=0;
//		if(s.length()!=7)
//			throw new IllegalArgumentException("checkHexColor.exp");
//		else 
//			{
//				rColor=s.substring(1, 3);
//				gColor=s.substring(3, 5);
//				bColor=s.substring(5);
//				r=hexTODec(rColor);
//				g=hexTODec(gColor);
//				b=hexTODec(bColor);
//			}
//		return r+","+g+","+b;
//	}
//	
//	
//	
//	private int hexTODec(String source)
//	{
//		source=source.toUpperCase();
//		String dig1=source.substring(0, 1);
//		String dig2=source.substring(1, 2);
//		int digit1=0;
//		int digit2=0;
//		SimpleBindings sb=new SimpleBindings();
//		String[] hex={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
//		int[] dec={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
//		for (int i = 0; i < dec.length; i++)
//			sb.put(hex[i], dec[i]);	
//		digit1=(int)sb.get(dig1);
//		digit2=(int)sb.get(dig2);
//		return (digit1*16)+digit2;
//	}
//	
//	
}
