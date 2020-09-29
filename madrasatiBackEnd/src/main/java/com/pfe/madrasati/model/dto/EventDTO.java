package com.pfe.madrasati.model.dto;

public class EventDTO {
	private Integer id;
	private String title;
	private String startString;
	private String endString;
	private String color;
	private Integer idclasse;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getIdclasse() {
		return idclasse;
	}
	public void setIdclasse(Integer idclasse) {
		this.idclasse = idclasse;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStartString() {
		return startString;
	}
	public void setStartString(String startString) {
		this.startString = startString;
	}
	public String getEndString() {
		return endString;
	}
	public void setEndString(String endString) {
		this.endString = endString;
	}
	
}
