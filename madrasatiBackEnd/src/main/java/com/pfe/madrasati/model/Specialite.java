package com.pfe.madrasati.model;

public class Specialite {
	private int id;
	private String code;
	private String libelle;
	private static int count;
	public Specialite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Specialite(int id, String code, String libelle) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Specialite.count = count;
	}
	@Override
	public String toString() {
		return "Speciaite [id=" + id + ", code=" + code + ", libelle=" + libelle + "]";
	}
	
	  
	
	
	
	
	
	
	
	
	
	
	
}
