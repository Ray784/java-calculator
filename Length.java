/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Length implements ActionListener
{
	Button b[]=new Button[25];
	TextField t1;
	char ch,ch1;
	int i;
        String value;
	double v1,op,v;
	Panel p,p1,p2;
	Frame f;
        Button b1,b2;
	Length()
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
                b2=new Button("MainPage");
		b[0]=new Button("AC");
                b[1]=new Button("DEL");
                b[2]=new Button("|x|");
                b[3]=new Button("in->cm");
		b[4]=new Button("cm->in");
		b[8]=new Button("ft->m");
		b[9]=new Button("m->ft");
		b[13]=new Button("yd->m");
		b[14]=new Button("m->yd");
		b[18]=new Button("mile->km");
		b[19]=new Button("km->mile");
		b[23]=new Button("nmile->m");
		b[24]=new Button("m->nmile");
                b[22]=new Button("+/-");
                b[21]=new Button(".");
                b[20]=new Button("0");
                b[15]=new Button("1");
                b[16]=new Button("2");
                b[17]=new Button("3");
                b[10]=new Button("4");
                b[11]=new Button("5");
                b[12]=new Button("6");
                b[5]=new Button("7");
                b[6]=new Button("8");
                b[7]=new Button("9");
		//defining the frame and panel setting size etc.
		p2.setLayout(null);
		p.setLayout(new GridLayout(5,7,5,5));
                p1.setLayout(new GridLayout(1,2,5,5));
                f.setLayout(null);
                f.setSize(400,375);
		p2.setSize(400,375);
		p2.setVisible(true);
                
                f.setVisible(true);
		p.setSize(390,270);
                p1.setSize(270,30);
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
		for(i=0;i<25;i++)
                    p.add(b[i]);
                p1.add(b1);
                p1.add(b2);
		p2.add(p);
		p2.add(p1);
                f.add(p2);
		//implementing the components
		for(i=0;i<22;i++)
		{
			b[i].addActionListener(this);
		}
		t1.addActionListener(this);
                b1.addActionListener(this);
                b2.addActionListener(this);
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
                                value=t1.getText();
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
                                    case "in->cm":
                                        op=2.54;
                                        v1=Double.parseDouble(value);
                                        v=v1*op;
                                        t1.setText(""+v);
                                        break;
                                }	
			}
			catch(Exception e)
				{t1.setText("");}
		}
	}
        public static void main(String args[])
        {
            new Length();
        }
}
