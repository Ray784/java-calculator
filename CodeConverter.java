/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author ABHI
 */
public class CodeConverter extends JFrame implements ActionListener
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
    CodeConverter()
    {
        Panel p=new Panel();
        p.setLayout(new GridLayout(8,3,5,5));
        b=new Button("Swap i-o");
        bo=new Button("Calculator");
        l1=new Label("Decimal Input:");
        l2=new Label("Binary Output");
        b1=new JRadioButton("BINARY");
        b2=new JRadioButton("OCTAL");
        b4=new Label("CONVERT TO:");
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
        
        setSize(400,375);
        p.setSize(400,375);
        p.setVisible(true);
        add(p);
        setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        
        setVisible(true);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b.addActionListener(this);
        bo.addActionListener(this);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
    public String dtob(int val)
    {
        String bin="";
	int b=0;
	while(val!=0)
	{
            b=val%2;
            val=val/2;
            bin=b+bin;
	}
	return bin;
    }
    public String dtoo(int val)
    {
        String bin="";
	int b=0;
	while(val!=0)
	{
            b=val%8;
            val=val/8;
            bin=b+bin;
        }
	return bin;
    }
    public String dtoh(int val)
    {
        char c='A';
        String bin="";
	int b=0;
	while(val!=0)
	{
            b=val%16;
            val=val/16;
            if(b>9)
            {
               if(b==10)
                   c='A';
               if(b==11)
                   c='B';
               if(b==12)
                   c='C';
               if(b==13)
                   c='D';
               if(b==14)
                   c='E';
               if(b==15)
                   c='F';
               bin=c+bin;
            }
            else
                bin=b+bin;
        }
	return bin;
    }
    public void actionPerformed(ActionEvent e) 
    {
        try
        {
       String s=e.getActionCommand();
       if(b1.isSelected())
       {
           int v=Integer.parseInt(t1.getText());
           l2.setText("Binary Output:");
           s=dtob(v);
           t2.setText(""+s);
       }
       if(s.equals("OCTAL"))
       {
           int v=Integer.parseInt(t1.getText());
           l2.setText("Octal Output:");
           s=dtoo(v);
           t2.setText(""+s);
       }
       if(s.equals("HEXADECIMAL"))
       {
           int v=Integer.parseInt(t1.getText());
           l2.setText("Hexadecimal Output:");
           s=dtoh(v);
           t2.setText(""+s);
       }
       if(s.equals("Swap i-o"))
       {
           new CodeConvert2();
           dispose();
       }
       if(s.equals("Calculator"))
       {
           new Cal();
           dispose();
       }
        }
        catch(Exception ke){
        JOptionPane.showMessageDialog(this,"Check the number inserted");}
    }
     public static void main(String args[])
    {
        new CodeConverter();
    }
}
