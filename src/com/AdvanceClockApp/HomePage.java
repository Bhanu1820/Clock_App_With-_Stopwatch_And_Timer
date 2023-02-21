package com.AdvanceClockApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Window;
import java.util.Date;
import java.util.Timer;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private JPanel contentPane;
	private JLabel heading;
	private JLabel clock;

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public HomePage() {
		setTitle("My Clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		heading = new JLabel("Current Date/Time");
		heading.setFont(new Font("Microsoft JhengHei", Font.BOLD, 27));
		heading.setBounds(25, 30, 371, 51);
		contentPane.add(heading);
		
		clock = new JLabel("New label");
		clock.setFont(new Font("Tahoma", Font.PLAIN, 44));
		clock.setBounds(51, 101, 561, 73);
		contentPane.add(clock);
		
		JButton btnNewButton = new JButton("Stop Watch");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StopWatch sw =new StopWatch();
				sw.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(94, 254, 166, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Timer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					MyTimer frame = new MyTimer();
					frame.setVisible(true);
				
				
			}
		});
		btnNewButton_1.setBounds(380, 254, 172, 35);
		contentPane.add(btnNewButton_1);
		
		Thread t=new Thread() {
			
			public void run()
			{   
				while(true) {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String datetime= new Date().toLocaleString();
				clock.setText(datetime);
				}
			}
	    	
			};
			t.start();
		
	}
}
