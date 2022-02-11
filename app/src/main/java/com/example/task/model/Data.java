package com.example.task.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("result")
	private List<ResultItem> result;

	@SerializedName("ms")
	private int ms;

	@SerializedName("query")
	private String query;

	public void setResult(List<ResultItem> result){
		this.result = result;
	}

	public List<ResultItem> getResult(){
		return result;
	}

	public void setMs(int ms){
		this.ms = ms;
	}

	public int getMs(){
		return ms;
	}

	public void setQuery(String query){
		this.query = query;
	}

	public String getQuery(){
		return query;
	}
}