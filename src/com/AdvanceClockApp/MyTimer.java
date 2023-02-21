package com.AdvanceClockApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MyTimer extends JFrame {

	private JPanel contentPane;
	
	static int milisecond=0;
    static int second=0;
    static int hour=0;
    static int minute=0;
    static boolean state=true;
    static long sand=0;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyTimer frame = new MyTimer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */
	/**
	 * Create the frame.
	 */
	public MyTimer() {
		setTitle("Timer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel hr = new JLabel("00");
		hr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		hr.setBounds(70, 143, 90, 30);
		contentPane.add(hr);
		
		JLabel min = new JLabel(": 00");
		min.setFont(new Font("Tahoma", Font.PLAIN, 20));
		min.setBounds(224, 143, 90, 30);
		contentPane.add(min);
		
		JLabel sec = new JLabel(": 00");
		sec.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sec.setBounds(380, 143, 90, 30);
		contentPane.add(sec);
		
		JLabel ms = new JLabel(": 000");
		ms.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ms.setBounds(527, 143, 90, 30);
		contentPane.add(ms);
		
		JSpinner hr_spinner = new JSpinner();
		hr_spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				hr.setText(""+hr_spinner.getValue());
			}
		});
		hr_spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		hr_spinner.setBounds(70, 217, 90, 30);
		contentPane.add(hr_spinner);
		
		JSpinner min_spinner = new JSpinner();
		min_spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				min.setText(": "+min_spinner.getValue());
			}
		});
		min_spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		min_spinner.setBounds(224, 217, 90, 30);
		contentPane.add(min_spinner);
		
		JSpinner sec_spinner = new JSpinner();
		sec_spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				sec.setText(": "+sec_spinner.getValue());
			}
		});
		sec_spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		sec_spinner.setBounds(380, 217, 90, 30);
		contentPane.add(sec_spinner);
		
		JSpinner ms_spinner = new JSpinner();
		ms_spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				ms.setText(": "+ms_spinner.getValue());
			}
		});
		ms_spinner.setModel(new SpinnerNumberModel(0, 0, 999, 1));
		ms_spinner.setBounds(527, 217, 90, 30);
		contentPane.add(ms_spinner);
		
		JButton stopBut = new JButton("Stop");
		stopBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state=false;
			}
		});
		stopBut.setBounds(292, 358, 85, 37);
		contentPane.add(stopBut);
		
		JButton startBut = new JButton("Start");
		startBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				milisecond=Integer.parseInt(""+ms_spinner.getValue());
		         second=Integer.parseInt(""+sec_spinner.getValue());
		         minute=Integer.parseInt(""+min_spinner.getValue());
		        hour=Integer.parseInt(""+hr_spinner.getValue());
		         sand=(hour*60*60*1000)+(minute*60*1000)+(second*1000);
		        state =true;
		        Thread t=new Thread()
		        {
		            public void run()
		            {
		                while(sand>=0)
		                {
		                   if(state==true)
		                   {
		                      try{
		                          sleep(5);                    
		                          sand-=5; 
		                          ms.setText(" : "+sand%1000);                         
		                          min.setText(" : "+(sand/(60*1000))%60);
		                          hr.setText("  "+(sand/(60*60*1000))%60);
		                          sec.setText(" : "+(sand/1000)%60);                         
		                      } 
		                      catch(Exception e){                          
		                      }
		                   }
		                   else
		                       break;
		                }
		                if(sand<=0);
		                    
		            }
		        };
		        t.start();
		        
			}
		});
		startBut.setBounds(146, 358, 85, 37);
		contentPane.add(startBut);
		
		JButton resetBut = new JButton("Reset");
		resetBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hour=0;
		        sand=0;
		        minute=0;
		        milisecond=0;
		        hr.setText("00");
		        min.setText(": 00");
		        sec.setText(": 00");
		        ms.setText(": 000");
			}
		});
		resetBut.setBounds(447, 358, 85, 37);
		contentPane.add(resetBut);
	}
}
