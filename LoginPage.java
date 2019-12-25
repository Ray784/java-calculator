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
public class LoginPage extends Frame implements ActionListener,KeyListener
{
	Button b1;
	Button b2;
	TextField t1;
	TextField t2;
	Label l1;
	Label l2;
	LoginPage()
	{
		b1=new Button("SUBMIT");
		b2=new Button("RESET");
		t1=new TextField();
		t2=new TextField();
		l1=new Label("USER_NAME");
		l2=new Label("PASSWORD");
		t2.setEchoChar('*');
		add(l1);add(t1);add(l2);add(t2);add(b1);add(b2);
		setSize(400,343);
		l1.setBounds(100,100,90,30);
		t1.setBounds(200,100,90,30);
		l2.setBounds(100,150,90,30);
		t2.setBounds(200,150,90,30);
		b1.setBounds(100,200,90,30);
		b2.setBounds(200,200,90,30);
		setLayout(null);
		setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
                t1.addActionListener(this);
                t2.addActionListener(this);
                t1.addKeyListener(this);
                b1.addKeyListener(this);
                b2.addKeyListener(this);
                t2.addKeyListener(this);
		addWindowListener(new WindowAdapter()
		{public void windowClosing(WindowEvent we)
			{dispose();}});
	}
        public void keyPressed(KeyEvent ke)
        {
            int s=ke.getKeyCode();
            if(s==KeyEvent.VK_DOWN)
            {
                t2.requestFocus();
            }
            if(s==KeyEvent.VK_UP)
            {
                t1.requestFocus();
            }
            if(s==KeyEvent.VK_RIGHT)
            {
                b2.requestFocus();
            }
            if(s==KeyEvent.VK_LEFT)
            {
                b1.requestFocus();
            }
        }
        public void keyTyped(KeyEvent ke)
        {
        }
        public void keyReleased(KeyEvent ke)
        {
        }
	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();
		if(s.equals("RESET"))
		{
			t1.setText("");
			t2.setText("");
		}
		if(s.equals("SUBMIT"))
		{
			if(t1.getText().equals(""))
			{
				String a="Username cannot be empty";
				JOptionPane.showMessageDialog(this,a);
			}
			else if(t2.getText().equals(""))
			{
				String a="Password cannot be empty";
				JOptionPane.showMessageDialog(this,a);
			}
			else if(t1.getText().equals("Abhay Bhat") && t2.getText().equals("bhat"))
			{
				new Log();
				dispose();
			}
			else
			{
				String a="Invalid Username or Password";
				JOptionPane.showMessageDialog(this,a);
			}
		}
		
	}
	public static void main(String args[])
	{
		new LoginPage();
	}
}
