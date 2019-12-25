/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.*;
import java.awt.event.*;
import static java.lang.Math.pow;
import javax.swing.*;

/**
 *
 * @author ABHI
 */
public class CodeConvert2 extends JFrame implements ActionListener
{
    Label l1;
    Label l2;
    Button b;
    JRadioButton b1;
    JRadioButton b2;
    JRadioButton b3;
      Label b4;
    Button bo;
    TextField t1;
    TextField t2;
    CodeConvert2()
    {
        Panel p=new Panel();
        p.setLayout(new GridLayout(8,3,5,5));
        b=new Button("Swap i-o");
        bo=new Button("Calculator");
        l1=new Label("Binary Input:");
        l2=new Label("Decimal Output");
        b1=new JRadioButton("BINARY",true);
        b2=new JRadioButton("OCTAL");
        b4=new Label("CONVERT FROM:");
        b3=new JRadioButton("HEXADECIMAL");
        t1=new TextField(20);
        t2=new TextField(20);
        t2.setEditable(false);
        ButtonGroup bg=new ButtonGroup();
        bg.add(b1);bg.add(b2);bg.add(b3);
        p.add(l1);
        p.add(t1);
        p.add(b4);
        
        p.add(b1);
       
        p.add(b2);
        p.add(b3);
        p.add(l2);
        
        p.add(t2);
        p.add(bo);
        p.add(b);
        add(p);
        setSize(400,375);
        p.setLocation(10,35);
        p.setSize(360,400);
        p.setVisible(true);
        setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        setVisible(true);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b.addActionListener(this);
        bo.addActionListener(this);
    }
    public int btod(long val)
    {
        String bin="";
        int cnt=-1,d=0,v=0;
        try
        {
        bin=Long.toString(val);
        }
        catch(Exception e){return(0);}
        while(cnt!=bin.length())
        {
            v=(int)val%10;
            val=val/10;
            cnt++;
            if(v==0 || v==1)
            {
                d=d+((int)pow(2,cnt)*v);
            }
            else
            {
               JOptionPane.showMessageDialog(b1,"Binary number must have only 0 & 1");
               return(0);
            }
        }
        return d;
    }
    public int otod(int val)
    {
       String bin="";
        int v=0,cnt=-1,d=0;
        bin=Integer.toString(val);
        while(cnt!=bin.length())
        {
            v=val%10;
            val=val/10;
            cnt++;
            if(v<8)
            {
                d=d+((int)pow(8,cnt)*v);
            }
            else
            {
               JOptionPane.showMessageDialog(b2,"Octal number must have only number less than 8");
               return(0);
            }
        }
        return d;
    }
    public int htod(String val)
    {
        int cnt=0,d=0,k=0,p=val.length()-1;
        char c;
        String hex="";
        while(cnt<val.length())
        {
            c=val.charAt(cnt);
            if(Character.isDigit(c))
            {
                hex=""+c;
                k=Integer.parseInt(hex);
                d=d+((int)pow(16,p)*k);
                cnt++;p--;
            }
            else
            {
                if(c=='A')
                    k=10;
                else if(c=='B')
                    k=11;
                else if(c=='C')
                    k=12;
                else if(c=='D')
                    k=13;
                else if(c=='E')
                    k=14;
                else if(c=='F')
                    k=15;
                else
                {
                    JOptionPane.showMessageDialog(b3,"Hexadecimal numbers must have 0-9 & A-F only");
                    return 0;
                }
                d=d+((int)pow(16,p)*k);
                cnt++;p--;
            }
        }
        return d;
    }
    public void actionPerformed(ActionEvent e) 
    {
       String s=e.getActionCommand();
       int a=0;
	   try
	   {
       if(s.equals("BINARY"))
       {
           long v= Long.parseLong(t1.getText());
           l1.setText("Binary Input:");
           a=btod(v);
           t2.setText(""+a);
       }
       
       if(s.equals("OCTAL"))
       {
           int v=Integer.parseInt(t1.getText());
           l1.setText("Octal Input:");
           a=otod(v);
           t2.setText(""+a);
       }
       if(s.equals("HEXADECIMAL"))
       {
           s=t1.getText();
           l1.setText("Hexadecimal Input:");
           a=htod(s);
           t2.setText(""+a);
       }
       if(s.equals("Swap i-o"))
       {
           new CodeConverter();
           dispose();
       }
       if(s.equals("Calculator"))
       {
           new Cal();
           dispose();
       }
	   }
	   catch(Exception ke)
	   {JOptionPane.showMessageDialog(this,"Check the number inserted");}
    }
}
