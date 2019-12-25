/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author ABHI
 */
public class Unit extends JFrame implements ActionListener
{
    Label l1,l2;
    Button b1,b2;
    Unit()
    {
        l1=new Label("Unit Converter");
        l2=new Label("MainMenu");
        b1=new Button("Length");
        b2=new Button("Weight/Temperature/Area");
        add(l1);
        add(l2);
        add(b1);
        add(b2);
        Font fo=new Font("Arial Black",Font.BOLD,20);
        Color c=new Color(10,10,10);
        l1.setFont(fo);
        l2.setFont(fo);
        b2.setFont(fo);
        b1.setFont(fo);
        setVisible(true);
        setLayout(null);
        l1.setForeground(Color.BLUE);
        l2.setForeground(Color.BLUE);
        l1.setBounds(120,70 ,200,30);
        l2.setBounds(140,100 ,200,30);
        b1.setBounds(70,130,250,30);
        b2.setBounds(70,170,250,30);
        setSize(400,375);
        b1.addActionListener(this);
        b2.addActionListener(this);
        addWindowListener(new WindowAdapter()
		{public void windowClosing(WindowEvent we)
			{System.exit(0);}});
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String s=e.getActionCommand();
        if(s.equals("Length"))
        {
            new Length();
            dispose();
        }
        if(s.equals("Weight/Temperature/Area"))
        {
            new WTA();
            dispose();
        }
    }
    public static void main(String args[])
    {
        new Unit();
    }
    
}
