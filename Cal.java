/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Cal implements ActionListener
{
	Button b[]=new Button[35];
	TextField t1;
	String value1,value2,op,value;
	char ch,ch1;
	int i;
	float v1,v2,v;
	Panel p,p1,p2;
	Frame f;
        Button b1,b2;
	Cal()
	{
                p2=new Panel();
            p1=new Panel();
		p=new Panel();
		f=new Frame();
		//defining textfield
		Font fo=new Font("Arial Black",Font.BOLD,20);
		t1=new TextField(21);
		t1.setEditable(false);
		t1.setFont(fo);
		
		//defining buttons
                b1=new Button("CodeConverter");
                b2=new Button("Unit Converter");
		for(i=0;i<10;i++)
			b[i]=new Button(""+i);
		b[10]=new Button("+");
		b[11]=new Button("-");
		b[12]=new Button("x");
		b[13]=new Button("/");
		b[14]=new Button("=");
		b[15]=new Button("AC");
		b[16]=new Button("DEL");
		b[17]=new Button("nPr");
		b[18]=new Button("nCr");
		b[19]=new Button("!");
		b[20]=new Button("sin");
		b[21]=new Button("cos");
		b[22]=new Button("tan");
		b[23]=new Button("loge");
		b[24]=new Button("l/x");
		b[25]=new Button(".");
		b[26]=new Button("%");
		b[27]=new Button("+/-");
		b[28]=new Button("|x|");
		b[29]=new Button("exp");
		b[30]=new Button("rad");
		b[31]=new Button("sqrt");
		b[32]=new Button("rand");
		b[33]=new Button("log10");
		b[34]=new Button("^");
				
		//defining the frame and panel setting size etc.
		p2.setLayout(null);
		p.setLayout(new GridLayout(5,7,5,5));
                p1.setLayout(new GridLayout(1,2,5,5));
                f.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
                f.setSize(480,450);
		p2.setSize(400,375);
		p2.setVisible(true);
                
                f.setVisible(true);
		p.setSize(390,270);
                p1.setSize(380,30);
		t1.setBounds(10,35,380,30);
		p.setBounds(10,70,380,263);
                p1.setBounds(10,335,380,30);
		p.setVisible(true);
                p1.setVisible(true);
		f.addWindowListener(new WindowAdapter()
		{public void windowClosing(WindowEvent we)
			{System.exit(0);}});
			
		//adding components to frame and panel
		p2.add(t1);
		p.add(b[27]);
		p.add(b[26]);
		p.add(b[19]);
		p.add(b[24]);
		p.add(b[28]);
		p.add(b[16]);
		p.add(b[15]);
		p.add(b[7]);
		p.add(b[8]);
		p.add(b[9]);
		p.add(b[10]);
		p.add(b[30]);
		p.add(b[29]);
		p.add(b[23]);
		p.add(b[4]);
		p.add(b[5]);
		p.add(b[6]);
		p.add(b[11]);
		p.add(b[20]);
		p.add(b[31]);
		p.add(b[33]);
		p.add(b[1]);
		p.add(b[2]);
		p.add(b[3]);
		p.add(b[12]);
		p.add(b[21]);
		p.add(b[18]);
		p.add(b[17]);
		p.add(b[0]);
		p.add(b[25]);
		p.add(b[14]);
		p.add(b[13]);
		p.add(b[22]);
		p.add(b[34]);
		p.add(b[32]);
                p1.add(b1);
                p1.add(b2);
		p2.add(p);
		p2.add(p1);
                f.add(p2);
		//implementing the components
		for(i=0;i<35;i++)
		{
			b[i].addActionListener(this);
		}
		t1.addActionListener(this);
                /*b1.addActionListener(this);
                b2.addActionListener(this);*/
	}
	//factorial function
	int fact(int n)
	{    
		if (n == 0)    
			return 1;    
		else    
			return(n *fact(n-1));    
 } 
	//implementing action listener
	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();
		ch=s.charAt(0);
		if(Character.isDigit(ch) || ch=='.' )
		{
			if(t1.getText().equals(""))
			{
				t1.setText(""+s);
			}
			else
			{
				value=t1.getText();
				t1.setText(value+s);
			}
		}
		else
		{
			try
			{
				switch(s)
				{
					case "+":
					op="ADD";
					value1=t1.getText();
					t1.setText("");
					break;
					case "-":
					op="SUB";
					value1=t1.getText();
					t1.setText("");
					break;
					case "x":
					op="MUL";
					value1=t1.getText();
					t1.setText("");
					break;
					case "/": 
					op="DIV";
					value1=t1.getText();
					t1.setText("");
					break;
					case "^":
					op="POW";
					value1=t1.getText();
					t1.setText("");
					break;
					case "%":
					op="PERC";
					value1=t1.getText();
					t1.setText("");
					break;
					case "nPr":
					op="PERM";
					value1=t1.getText();
					t1.setText("");
					break;
					case "nCr":
					op="COMB";
					value1=t1.getText();
					t1.setText("");
					break;
					
					case "l/x":
					op="";
					value1=t1.getText();
					v1=Float.parseFloat(value1);
					t1.setText(""+(1/v1));
					break;
					case "AC":
					op="";
					value1="";
					t1.setText("");
					break;
					case "DEL":
					op="";
					value1="";
					String temp=t1.getText();
					int l=temp.length();
					if(l==1 || l==0)
					{
						t1.setText("");
					}
					else
					{
						String t=""+temp.charAt(0);
						for(i=1;i<l-1;i++)
						{
							t+=temp.charAt(i);
						}
						t1.setText(t);
					}
					break;
					case "!":
					op="";
					value1=t1.getText();
					v1=Float.parseFloat(value1);
					t1.setText(""+fact((int)v1));
					break;
					case "sin":
					op="";
					value1=t1.getText();
					v1=Float.parseFloat(value1);
					t1.setText(""+Math.sin(v1));
					break;
					case "cos":
					op="";
					value1=t1.getText();
					v1=Float.parseFloat(value1);
					t1.setText(""+Math.cos(v1));
					break;
					case "tan":
					op="";
					value1=t1.getText();
					v1=Float.parseFloat(value1);
					t1.setText(""+Math.tan(v1));
					break;
					case "loge":
					op="";
					value1=t1.getText();
					v1=Float.parseFloat(value1);
					t1.setText(""+Math.log(v1));
					break;
					case "log10":
					op="";
					value1=t1.getText();
					v1=Float.parseFloat(value1);
					t1.setText(""+Math.log10(v1));
					break;
					case "|x|":
					op="";
					value1=t1.getText();
					v1=Float.parseFloat(value1);
					t1.setText(""+Math.abs(v1));
					break;
					case "+/-":
					op="";
					value1=t1.getText();
					v1=Float.parseFloat(value1);
					t1.setText(""+(v1*-1));
					break;
					case "sqrt":
					op="";
					value1=t1.getText();
					v1=Float.parseFloat(value1);
					t1.setText(""+Math.sqrt(v1));
					break;
					case "rad":
					op="";
					value1=t1.getText();
					v1=Float.parseFloat(value1);
					t1.setText(""+Math.toRadians(v1));
					break;
					case "rand":
					op="";
                     t1.setText(""+Math.random());
					break;
					case "exp":
					op="";
					value1=t1.getText();
					v1=Float.parseFloat(value1);
					t1.setText(""+Math.exp(v1));
					break;
                                        /*case "CodeConverter":
                                            new CodeConverter();
                                            f.dispose();
											break;
                                            case "Unit Converter":
                                            new Unit();
                                            f.dispose();
											break;*/
				
					case "=":
					if(t1.getText()!="")
					value2=t1.getText();
					else
						value2="1";
						switch(op)
						{
							case "ADD":
							v1=Float.parseFloat(value1);
							v2=Float.parseFloat(value2);
							v=v1+v2;
							t1.setText(""+v);
							break;
							case "SUB":
							v1=Float.parseFloat(value1);
							v2=Float.parseFloat(value2);
							v=v1-v2;
							t1.setText(""+v);
							break;
							case "MUL":
							v1=Float.parseFloat(value1);
							v2=Float.parseFloat(value2);
							v=v1*v2;
							t1.setText(""+v);
							break;
							case "DIV":
							v1=Float.parseFloat(value1);
							v2=Float.parseFloat(value2);
							v=v1/v2;
							t1.setText(""+v);
							break;
							case "POW":
							v1=Float.parseFloat(value1);
							v2=Float.parseFloat(value2);
							v=(float)Math.pow(v1,v2);
							t1.setText(""+v);
							break;
							case "PERC":
							v1=Float.parseFloat(value1);
							v2=Float.parseFloat(value2);
							v=v1*v2/100;
							t1.setText(""+v);
							break;
							case "PERM":
							v1=Float.parseFloat(value1);
							v2=Float.parseFloat(value2);
							v=fact((int)v1)/fact((int)v1-(int)v2);
							t1.setText(""+v);
							break;
							case "COMB":
							v1=Float.parseFloat(value1);
							v2=Float.parseFloat(value2);
							v=fact((int)v1)/(fact((int)v1-(int)v2))/fact((int)v2);
							t1.setText(""+v);
							break;
						}
						break;
				}
			}
			catch(Exception e)
				{t1.setText("");}
				
			
		}
	}
        public static void main(String args[])
        {
            new Cal();
        }
}
