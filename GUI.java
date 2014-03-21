package timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

public class GUI extends JFrame
{
	private TimerModel timerModel = new TimerModel();
	private StopWatchModel stopWatchModel = new StopWatchModel();
	private AlarmModel alarmModel = new AlarmModel();
	
	
	private TimerPanel timerPanel;
	private StopWatchPanel stopWatchPanel;
	private AlarmPanel alarmPanel;
	
	public GUI()
	{
		initialization();	
	}
	
	private void initialization()
	{		
		timerPanel = new TimerPanel(new TimerListener());
		timerPanel.setDisplay(timerModel.getTime());
		
		stopWatchPanel = new StopWatchPanel(new StopWatchListener());
		
		alarmPanel = new AlarmPanel(new AlarmListener());
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.add("Timer", timerPanel);
		tabbedPane.add("StopWatch", stopWatchPanel);
		tabbedPane.add("Alarm", alarmPanel);	
		
		add(tabbedPane, BorderLayout.CENTER);

		setTitle("Timer");		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}
	
	public static void main(String[] args)
	{
		// Building interface in EventQueue thread
		EventQueue.invokeLater(new Runnable()
			{			
				@Override
				public void run()
				{
					new GUI();					
				}
			});
	}


	
	class TimerListener implements ActionListener
	{
		private Timer swingTimerTicker;
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand() == "Start")
			{
				timerPanel.setCommandText("Stop");
				timerPanel.setDisplay(timerModel.getTime());	
				swingTimerTicker = new Timer(1000, this);		
				swingTimerTicker.start();
			}
			if(e.getActionCommand() == "Stop")
			{
				timerPanel.setCommandText("Start");
				swingTimerTicker.stop();
			}
			if(e.getActionCommand() == "Reset")
			{
				timerModel.restartTimer();
				timerPanel.setDisplay(timerModel.getTime());
			}
			if(e.getActionCommand() == "Set")
			{
				String s = (String)JOptionPane.showInputDialog("Input timer time", timerModel.getTime());
				timerModel.setTime(s);
				timerPanel.setDisplay(timerModel.getTime());

			}
			if(e.getSource() == swingTimerTicker) 
			{
				if(timerModel.isTimeUp()) // time is up
				{
					swingTimerTicker.stop();
					timerModel.restartTimer();
					timerPanel.setDisplay(timerModel.getTime());
					timerPanel.setCommandText("Start");
					
					// Launching new thread to play music
					new Thread( new Runnable()
						{						
							@Override
							public void run()
							{
								new SoundEngine().playSound();							
							}
						}).start();				
				}
				else // still counting
				{
					timerModel.timeTick();
					timerPanel.setDisplay(timerModel.getTime());
				}
			}			
		} // method actionPerformed		
	} // class TimerListener
	
	class StopWatchListener implements ActionListener
	{
		private Timer swingTimerTicker;
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand() == "Start")
			{
				stopWatchPanel.setCommandText("Stop");
				stopWatchPanel.setDisplay(stopWatchModel.getTime());	
				swingTimerTicker = new Timer(1000, this);		
				swingTimerTicker.start();
			}
			if(e.getActionCommand() == "Stop")
			{
				stopWatchPanel.setCommandText("Start");
				swingTimerTicker.stop();
			}
			if(e.getActionCommand() == "Reset")
			{
				stopWatchModel.restartStopWatch();
				stopWatchPanel.setDisplay(stopWatchModel.getTime());
			}
			if(e.getSource() == swingTimerTicker) 
			{
				stopWatchModel.timeTick();
				stopWatchPanel.setDisplay(stopWatchModel.getTime());	
			}			
		} // method actionPerformed		
	} // class StopWatchListener

	class AlarmListener implements ActionListener
	{
		private Timer swingTimerTicker;
		
		public AlarmListener()
		{
			swingTimerTicker = new Timer(1000, this);
			swingTimerTicker.start();
		}
		
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand() == "Enable")
			{
				alarmPanel.setCommandText("Disable");
				alarmPanel.setEnabled();
				alarmModel.enable();
				//timerPanel.setDisplay(timerModel.getTime());	
				//swingTimerTicker = new Timer(1000, this);		
				//swingTimerTicker.start();
			}
			if(e.getActionCommand() == "Disable")
			{
				alarmPanel.setCommandText("Enable");
				alarmPanel.setDisabled();
				alarmModel.disable();
				//timerPanel.setCommandText("Start");
				//swingTimerTicker.stop();
			}

			if(e.getActionCommand() == "Set")
			{
				String s = (String)JOptionPane.showInputDialog("Input timer time", alarmModel.getTime());
				alarmModel.setAlarmTime(s);
				alarmPanel.setAlarmDisplay(alarmModel.getAlarmTime());

			}
			if(e.getSource() == swingTimerTicker) 
			{
				alarmPanel.setTimeDisplay(alarmModel.getTime());
				if(alarmModel.isTimeUp()) // time is up
				{
					//swingTimerTicker.stop();
					//timerModel.restartTimer();
					//timerPanel.setDisplay(timerModel.getTime());
					//timerPanel.setCommandText("Start");
					
					// Launching new thread to play music
					new Thread( new Runnable()
						{						
							@Override
							public void run()
							{
								new SoundEngine().playSound();							
							}
						}).start();				
				}
				else // still counting
				{
					//timerModel.timeTick();
					//timerPanel.setDisplay(timerModel.getTime());
				}
			}			
		} // method actionPerformed		
	} // class TimerListener
}
