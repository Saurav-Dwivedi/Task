package com.example.task.model;

import com.google.gson.annotations.SerializedName;

public class ResultItem{

	@SerializedName("imageUrl")
	private String imageUrl;

	@SerializedName("description")
	private String description;

	@SerializedName("_id")
	private String id;

	@SerializedName("title")
	private String title;

	@SerializedName("publishedAt")
	private String publishedAt;

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public String getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(String publishedAt) {
		this.publishedAt = publishedAt;
	}
}