package timer;

import java.io.*;

public class TimerModel
{
	private int hours;
	private int minutes;
	private int seconds;
	
	public TimerModel()
	{
		restartTimer();
	}
	
	public void restartTimer()
	{
		setTime(loadTimeValue());
	}

	/**
	 * Sets time from preformated string.
	 * 
	 * @param time preformated time string as "00:00:00"
	 */
	public void setTime(String time)
	{
		hours = Integer.parseInt(time.substring(0, 2));
		minutes = Integer.parseInt(time.substring(3, 5));
		seconds = Integer.parseInt(time.substring(6, 8));
		
		storeTimeValue(time);		
	}
	
	/**
	 * 	Returns the time as a preformated string
	 * 
	 * @return preformated time string as "00:00:00"
	 */
	public String getTime()
	{
		String time;
		if(hours < 10)
			time = "0" + hours;
		else
			time = String.valueOf(hours);
		
		if(minutes < 10)
			time += ":" + "0" + minutes;
		else
			time += ":" + minutes;
		
		if(seconds < 10)
			time += ":" + "0" + seconds;
		else
			time += ":" + seconds;
		
		return time;
	}
	
	public boolean isTimeUp()
	{
		if (hours == 0 && minutes == 0 && seconds == 0)
			return true;
		else
			return false;
	}	
	
	private void storeTimeValue(String time) 
	{		
		try
		{
			BufferedWriter fileWriter = new BufferedWriter( new FileWriter("properties.txt"));
			fileWriter.write(time);
			fileWriter.newLine();
			fileWriter.close();			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	private String loadTimeValue()
	{
		String result = "00:02:00";
		try
		{
			BufferedReader fileReader = new BufferedReader( new FileReader("properties.txt"));
			result = fileReader.readLine();
			fileReader.close();
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 *  Timer doesn't have his own thread of control and every time interval 
	 *  tick is initiated with this method from outside.
	 *  
	 *  pre:  none
	 *  post: reduces current tracked time by second or does nothing
	 *  	  if time is already elapsed.
	 */
	public void timeTick()
	{
		if(!isTimeUp())
		{
			if(seconds != 0)
				seconds--;
			else if (minutes != 0)
			{
				minutes--;
				seconds = 59;
			}
			else 
			{
				hours--;
				minutes = 59;
				seconds = 59;
			}
		}
	}

}
