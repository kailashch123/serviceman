package com.spring.util;

import java.util.ArrayList;
import java.util.List;

import com.spring.model.User;

public class AppUtil {

	public static String createOwnerString(User owner) {
		String str = owner.getFirstName()+" "+owner.getLastName()+" ("+owner.getEmail()+")";
		return str;
	}
	
	public static List<String> initTime() {
		List<String> times = new ArrayList<String>();
		times.add("--Select--");
		times.add("3:00 PM");
		times.add("3:15 PM");
		times.add("3:30 PM");
		times.add("3:45 PM");
		times.add("4:00 PM");
		times.add("4:15 PM");
		times.add("4:30 PM");
		times.add("4:45 PM");
		times.add("5:00 PM");
		times.add("5:15 PM");
		times.add("5:30 PM");
		times.add("5:45 PM");
		times.add("6:00 PM");
		times.add("6:15 PM");
		times.add("6:30 PM");
		return times;
		
	}
}
