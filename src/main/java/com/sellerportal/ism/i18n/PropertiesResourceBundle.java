package com.sellerportal.ism.i18n;

import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesResourceBundle extends Properties {

	private ResourceBundle bundle = null;
	
	public PropertiesResourceBundle(ResourceBundle _bundle)
	{
	 this.bundle = _bundle;	
	}
	
	@Override
	public  Object get(Object key) {
		try {
			return bundle.getString(key+"");
		}catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public  String getProperty(String key) {
		try {
			return bundle.getString(key+"");
		}catch(Exception e) {
			return null;
		}
		
	}
	
	@Override
	public  String getProperty(String key,String defaultValue) {
		String v = null;
		try {			
			v = bundle.getString(key+"");
			if(v==null)
				v=defaultValue;
		}catch(Exception e) {
			v=defaultValue;
		}
		
		
		return v;
	}
	
	public  Object getString(Object key) {
		try {
			return bundle.getString(key+"");
		}catch(Exception e) {
			return null;
		}
		
	}

}
