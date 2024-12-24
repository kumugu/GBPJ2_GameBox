package com.gamebox.controller;

public class ActionForward {
	private String path;		// 이동할 경로
	private boolean redirect;	// true: Redirect, false: forward
	
	public ActionForward (String path, boolean redirect) {
		this.path = path;
		this.redirect = redirect;
	}

	public String getPath() {
		return path;
	}

	public boolean isRedirect() {
		return redirect;
	}
	
}
