package com.gamebox.dto;

import java.security.Timestamp;

public class PurchasesDTO {

	private int purchaseId;
	private int userId;
	private int gameId;
	private Timestamp purchasedAt;
	
	// Getters and Setters
	
	public int getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public Timestamp getPurchasedAt() {
		return purchasedAt;
	}
	public void setPurchasedAt(Timestamp purchasedAt) {
		this.purchasedAt = purchasedAt;
	}
	
}
