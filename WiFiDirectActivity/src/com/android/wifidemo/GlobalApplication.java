package com.android.wifidemo;

import android.content.Context;

public class GlobalApplication extends android.app.Application{
private static Context GlobalContext;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		if(GlobalApplication.GlobalContext == null){
			GlobalApplication.GlobalContext = getApplicationContext();
		}
	}
	
	public static Context getGlobalAppContext() {
		return GlobalApplication.GlobalContext;
	}
}
