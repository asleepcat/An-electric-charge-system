package main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time {

	public static void main(String[] args) {
		Date a=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(a);
		Calendar c = (Calendar) calendar.clone();
		c.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
		System.out.println(formatter.format(c.getTime()));
	}

}
