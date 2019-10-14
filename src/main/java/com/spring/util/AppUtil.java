package com.spring.util;

import com.spring.model.User;

public class AppUtil {

	public static String createOwnerString(User owner) {
		String str = owner.getFirstName()+" "+owner.getLastName()+" ("+owner.getEmail()+")";
		return str;
	}
}
