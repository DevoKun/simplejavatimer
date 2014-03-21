package timer;

import java.util.Calendar;

public class AlarmModel
{
	private int hours;
	private int minutes;
	private int seconds;
	
	private boolean enabled = false;
	
	/**
	 * Sets time from preformated string.
	 * 
	 * @param time preformated time string as "00:00:00"
	 */
	public void setAlarmTime(String time)
	{
		hours = Integer.parseInt(time.substring(0, 2));
		minutes = Integer.parseInt(time.substring(3, 5));
		seconds = Integer.parseInt(time.substring(6, 8));
	}
	
	/**
	 * 	Returns the current time as a preformated string
	 * 
	 * @return preformated time string as "00:00:00"
	 */
	public String getTime()
	{
		Calendar calendar = Calendar.getInstance();
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		int minutes = calendar.get(Calendar.MINUTE);
		int seconds = calendar.get(Calendar.SECOND);
		
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
	 * 	Returns the alarm time as a preformated string
	 * 
	 * @return preformated time string as "00:00:00"
	 */
	public String getAlarmTime()
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
		Calendar calendar = Calendar.getInstance();
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		int minutes = calendar.get(Calendar.MINUTE);
		int seconds = calendar.get(Calendar.SECOND);
		
		if (this.hours == hours && this.minutes == minutes && this.seconds == seconds && enabled == true)
			return true;
		else
			return false;
	}	
	
	public void enable()
	{
		enabled = true;
	}
	
	public void disable()
	{
		enabled = false;
	}
}
