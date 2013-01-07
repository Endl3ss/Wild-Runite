package scripts.WildRunite.copy;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import scripts.WildRunite.WildRunite;

import javax.swing.event.*;

public class Gui extends JFrame {
	static boolean start = false;
	public static boolean superstop = false;
	static JButton Start; 
	static boolean guiWait = true;

	
	public Gui() {
		setSize(300,100);
		setTitle("Mining Options");
		
		setLayout(new BorderLayout());	
		
		Start = new JButton("Start");
		add(Start, BorderLayout.SOUTH);
		Start.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent d) {
							guiWait = false;
							WildRunite.g.dispose();
						}
		});

	}
	public static void exitgui() {
		superstop = true;}
	
	}
	
	