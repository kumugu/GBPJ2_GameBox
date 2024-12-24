package com.gamebox.dto;

import java.security.Timestamp;

public class LibraryDTO {

	private int libraryId;
	private int userId;
	private int gaemId;
	private Timestamp lastPlayed;
	
	// Getters and Setters
	
	public int getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGaemId() {
		return gaemId;
	}
	public void setGaemId(int gaemId) {
		this.gaemId = gaemId;
	}
	public Timestamp getLastPlayed() {
		return lastPlayed;
	}
	public void setLastPlayed(Timestamp lastPlayed) {
		this.lastPlayed = lastPlayed;
	}
}
