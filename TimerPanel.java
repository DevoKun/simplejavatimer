package timer;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TimerPanel extends JPanel
{
	private JLabel timerDisplay;
	private JButton startCommand;
	private JButton resetButton;
	private JButton setButton;
	
	public TimerPanel(ActionListener listener)
	{
		startCommand = new JButton("Start");
		resetButton = new JButton("Reset");
		setButton = new JButton("Set");
		startCommand.addActionListener(listener);
		resetButton.addActionListener(listener);
		setButton.addActionListener(listener);
		// all buttons width as the largest button width
		startCommand.setPreferredSize(resetButton.getPreferredSize());
		setButton.setPreferredSize(resetButton.getPreferredSize());	
		

		timerDisplay = new JLabel("00:00:00");
		timerDisplay.setFont(new Font("", Font.BOLD, 44));
		
		JPanel displayPanel = new JPanel();
		JPanel commandPanel = new JPanel();
				
		displayPanel.add(timerDisplay);

		commandPanel.add(startCommand);
		commandPanel.add(resetButton);
		commandPanel.add(Box.createHorizontalStrut(20));
		commandPanel.add(setButton);
				
		//JPanel timerPane = new JPanel();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(displayPanel);
		add(commandPanel);
		
	}
	
	public void setDisplay(String display)
	{
		timerDisplay.setText(display);
	}
	
	public void setCommandText(String command)
	{
		startCommand.setText(command);
	}
}
