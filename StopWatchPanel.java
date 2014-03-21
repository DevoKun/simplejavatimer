package timer;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StopWatchPanel extends JPanel
{
	private JLabel stopWatchDisplay;
	private JButton startCommand;
	private JButton resetButton;	
	
	public StopWatchPanel(ActionListener listener)
	{
		startCommand = new JButton("Start");
		resetButton = new JButton("Reset");

		startCommand.addActionListener(listener);
		resetButton.addActionListener(listener);

		// all buttons width as the largest button width
		startCommand.setPreferredSize(resetButton.getPreferredSize());
			

		stopWatchDisplay = new JLabel("00:00:00");
		stopWatchDisplay.setFont(new Font("", Font.BOLD, 44));
		
		JPanel displayPanel = new JPanel();
		JPanel commandPanel = new JPanel();
		commandPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
				
		displayPanel.add(stopWatchDisplay);

		commandPanel.add(startCommand);
		commandPanel.add(resetButton);
				
		//JPanel timerPane = new JPanel();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(displayPanel);
		add(commandPanel);
		
	}
	
	public void setDisplay(String display)
	{
		stopWatchDisplay.setText(display);
	}
	
	public void setCommandText(String command)
	{
		startCommand.setText(command);
	}
	
}
