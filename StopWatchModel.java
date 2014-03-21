package timer;

public class StopWatchModel
{
	private int hours;
	private int minutes;
	private int seconds;
	
	public StopWatchModel()
	{
		restartStopWatch();
	}
	
	public void restartStopWatch()
	{
		hours = 0;
		minutes = 0;
		seconds = 0;
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
	
	/**
	 *  StopWatch doesn't have his own thread of control and every time interval 
	 *  tick is initiated with this method from outside.
	 *  
	 *  pre:  none
	 *  post: increases current time by second or restarts if time overflow
	 */
	public void timeTick()
	{	
		if(seconds < 59)
			seconds++;
		else if (minutes < 59)
		{
			minutes++;
			seconds = 0;
		}
		else if (hours < 24)
		{
			hours++;
			minutes = 00;
			seconds = 00;
		}
		else
		{
			hours = 00;
			minutes = 00;
			seconds = 00;
		}		
	}
}
