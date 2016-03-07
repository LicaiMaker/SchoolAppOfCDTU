package com.schoolapp.schoolapp.shopping;

public class Store {
	private int imageId;
	private String storeReputaion;
	private float ratingNumber;

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getStoreReputaion() {
		return storeReputaion;
	}

	public void setStoreReputaion(String storeReputaion) {
		this.storeReputaion = storeReputaion;
	}

	public float getRatingNumber() {
		return ratingNumber;
	}

	public void setRatingNumber(int ratingNumber) {
		this.ratingNumber = ratingNumber;
	}

	public Store(int imageId, String storeReputaion, int ratingNumber) {
		super();
		this.imageId = imageId;
		this.storeReputaion = storeReputaion;
		this.ratingNumber = ratingNumber;
	}

}
