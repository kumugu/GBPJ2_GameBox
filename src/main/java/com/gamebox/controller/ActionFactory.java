package com.gamebox.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ActionFactory {
	private static Properties actionMappings;
	
	static {
		actionMappings = new Properties();
		try (InputStream input = ActionFactory.class.getClassLoader().getResourceAsStream("mapping.properties")) {
			if (input != null) {
				actionMappings.load(input);
			} else {
				throw new RuntimeException("Unable to find mapping.properties");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Error loading mapping.properties");
		}
	}

	public static Action getAction(String command) {
		String className = actionMappings.getProperty(command);
		
		if (className == null) {
			return null;	// mapping 된 Action이 없으면 null 반환		
		} 
		
		try {
			Class<?> actionClass = Class.forName(className);	// Class 로드
			return (Action) actionClass.getDeclaredConstructor().newInstance();	// Action 객체 생성
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error creating Aciton instance for: " + command, e); 
		}
	}
}
