package com.pfe.madrasati.model;

import java.util.Scanner;

import com.pfe.madrasati.service.SalleService;

public class Salle {
	private Integer id;
	private String code;
	private String libelle;

//	private static int comp;
//Source : www.exelib.net

	public Salle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Salle(Integer id, String code, String libelle) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;

	}

	@Override
	public String toString() {
		return "Salle [id=" + id + ", code=" + code + ", libelle=" + libelle + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

//	public static int getComp() {
//		return comp;
//	}
//
//	public static void setComp(int comp) {
//		Salle.comp = comp;
//	}

	
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + id;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salle other = (Salle) obj;
		if (this.code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id != other.id)
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}

	
	
	public static void main(String[] args) {
		SalleService ss = new SalleService();

		//Salle s4 = new Salle(1, "A", "Salle 1");
		//Salle s6 = new Salle(1, "A", "Salle 1");
		
		//System.out.println(s4.equals(s6)); 
        ss.create(new Salle(1,"A", "Salle 1")) ;
        ss.create(new Salle(2,"B", "Salle 2")) ;
        ss.create(new Salle(3,"C", "Salle 3")) ;
        ss.create(new Salle(4,"D", "Salle 2")) ;
        ss.create(new Salle(5,"E", "Salle 2")) ;
	
        System.out.println("La liste des salles :");
		for (Salle s : ss.findAll())
			System.out.println("\t" + s);
       // System.out.println(ss.findAll());
	//	System.out.println("Supprimer la salle avec id = 1");
		//ss.delete(ss.findById(1));
		
		System.out.println("Modifier la salle avec id = 2");
		Salle salle = ss.findById(2);
		System.out.println("\tSalle à modifier : " + salle);
		
		Scanner sc = new Scanner(System.in);
		//System.out.println("Donner le nouveau id :");
         //salle.setId(sc.nextInt());
         
		System.out.println("Donner le nouveau code :");
		salle.setCode(sc.nextLine());
		
		System.out.println("Donner le nouveau libelle :");
		salle.setLibelle(sc.nextLine());
		ss.update(salle);
		
		System.out.println("La liste des salles après les mises à jour :");
		for (Salle s : ss.findAll())
			System.out.println("\t" + s);

}
}