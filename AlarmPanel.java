package timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class AlarmPanel extends JPanel
{
	private JLabel timeDisplay;
	private JLabel alarmDisplay;
	private JButton enableCommand;
	private JButton setCommand;	
	
	public AlarmPanel(ActionListener listener)
	{
		enableCommand = new JButton("Disable");
		setCommand = new JButton("Set");

		enableCommand.addActionListener(listener);
		setCommand.addActionListener(listener);

		Dimension enableCommandDimension = enableCommand.getPreferredSize();
		enableCommand.setText("Enable");
		enableCommand.setPreferredSize(enableCommandDimension);
		//enableCommand.setPreferredSize(new Dimension(67,26));
		setCommand.setPreferredSize(new Dimension(67,26));
		
		
			

		timeDisplay = new JLabel("00:00:00");
		Font displayFont = new Font("", Font.BOLD, 34);		
		timeDisplay.setFont(displayFont);		
		//timeDisplay.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
			
		alarmDisplay = new JLabel("00:00:00");
		alarmDisplay.setForeground(Color.GRAY);
		alarmDisplay.setFont(new Font("", Font.BOLD, 17));
		//alarmDisplay.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		JPanel displayPanel = new JPanel();
		displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.X_AXIS));
		//displayPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		JPanel alarmPanel = new JPanel();
		
		alarmPanel.setBorder(BorderFactory.createEmptyBorder());
		alarmPanel.setLayout(new BoxLayout(alarmPanel, BoxLayout.X_AXIS));
		JPanel commandPanel = new JPanel();
		commandPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
				
		displayPanel.add(timeDisplay);
		alarmPanel.add(alarmDisplay);

		commandPanel.add(enableCommand);
		commandPanel.add(setCommand);
				
		//JPanel timerPane = new JPanel();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(displayPanel);
		add(alarmPanel);
		add(commandPanel);
		
	}
	
	public void setTimeDisplay(String display)
	{
		timeDisplay.setText(display);
	}
	
	public void setAlarmDisplay(String display)
	{
		alarmDisplay.setText(display);
	}
	
	
	public void setCommandText(String command)
	{
		enableCommand.setText(command);
	}
	
	public void setDisabled()
	{
		alarmDisplay.setForeground(Color.GRAY);
	}

	public void setEnabled()
	{		
		Color color = new Color(0x1D, 0x87, 0x39);		
		alarmDisplay.setForeground(color);
	}
}
