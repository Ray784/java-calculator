/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author ABHI
 */
public class Log extends Frame
{
    JLabel jl;
	public Log()
	{
		Font f=new Font("Comic Sans MS",Font.PLAIN,20);
		JPanel P =new JPanel();
		ImageIcon ii = new ImageIcon("D:\\javaex\\log\\bu.gif");
		jl = new JLabel(ii);
		jl.setText("LOADING"); 
		setBackground(Color.black);
		jl.setForeground(Color.white);
		P.setBackground(Color.black);
		jl.setBounds(200,200,220,30);
		jl.setFont(f);
		P.setBounds(70,100,220,200);
		P.add(jl);
		P.setSize(240,400);
		add(P);
		setSize(400,343);
		setLayout(null);
		setVisible(true);
		java.util.Timer timer = new java.util.Timer();
		timer.schedule(new TimerTask(){
			public void run() {
				new Cal();
				dispose();}},5000);
	}
	public static void main(String args[])
	{
		new Log();
	}
}
