package com.example.utils;

import org.androidannotations.annotations.sharedpreferences.SharedPref;

@SharedPref
public interface ISettings {

	String name();
	String surname();
	
	int age();
	
	boolean haveBoyFriend();
	
	boolean maritalStatus();

}
