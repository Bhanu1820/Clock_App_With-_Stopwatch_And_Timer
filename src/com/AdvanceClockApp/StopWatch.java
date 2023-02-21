package com.AdvanceClockApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class StopWatch extends JFrame {

	private JPanel contentPane;
	
	static int milisecond=0;
    static int second=0;
    static int hour=0;
    static int minute=0;
    static boolean state=true;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StopWatch frame = new StopWatch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public StopWatch() {
		setTitle("Stop Watch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel hr = new JLabel("00");
		hr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		hr.setBounds(74, 108, 90, 30);
		contentPane.add(hr);
		
		JLabel ms = new JLabel(": 00");
		ms.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ms.setBounds(467, 108, 90, 30);
		contentPane.add(ms);
		
		JLabel min = new JLabel(": 00");
		min.setFont(new Font("Tahoma", Font.PLAIN, 20));
		min.setBounds(203, 108, 90, 30);
		contentPane.add(min);
		
		JLabel sec = new JLabel(": 00");
		sec.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sec.setBounds(341, 108, 90, 30);
		contentPane.add(sec);
		
		JButton stopBut = new JButton("Stop");
		stopBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state =false;
			}
		});
		stopBut.setBounds(277, 267, 85, 21);
		contentPane.add(stopBut);
		
		JButton startBut = new JButton("Start");
		startBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state =true;
		        Thread t=new Thread()
		        {
		            public void run()
		            {
		                while(true)
		                {
		                   if(state==true)
		                   {
		                      try{
		                          sleep(5);
		                          if(milisecond>1000)
		                          {
		                              milisecond=0;
		                              second++;
		                          }
		                          if(second>60)
		                          {
		                              second=0;
		                              milisecond=0;
		                              minute++;
		                          }
		                          if(minute>60)
		                          {
		                              second=0;
		                              milisecond=0;
		                              hour++;
		                              minute++;
		                          }
		                          milisecond = milisecond+5;
		                         ms.setText(" : "+milisecond);
		                         min.setText(" : "+minute);
		                         hr.setText("  "+hour);
		                         sec.setText(" : "+second);
		                      } 
		                      catch(Exception e){
		                          
		                      }
		                   }
		                   else
		                       break;
		                }
		            }
		        };
		        t.start();
			}
		});
		startBut.setBounds(138, 267, 85, 21);
		contentPane.add(startBut);
		
		JButton resetbut = new JButton("Reset");
		resetbut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = false;
		        milisecond=0;
		        second=0;
		        minute=0;
		        hour=0;
		        min.setText(": 00");
		        hr.setText("00");
		        sec.setText(": 00");
		        ms.setText(": 00");
			}
		});
		resetbut.setBounds(422, 267, 85, 21);
		contentPane.add(resetbut);
	}
}
