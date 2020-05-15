package com.pfe.madrasati.model;

public class Prof {
	private int id;
	private String nom;
	private String prenom;
	private String telephone;
	private String email;
	private Specialite Specialite;

	public Prof() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prof(int id, String nom, String prenom, String telephone, String email, Specialite specialite) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.Specialite = specialite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Specialite getSpecialite() {
		return Specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.Specialite = specialite;
	}

	@Override
	public String toString() {
		return "Prof [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", telephone=" + telephone + ", email="
				+ email + ", specialite=" + Specialite + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((Specialite == null) ? 0 : Specialite.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
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
		Prof other = (Prof) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (Specialite == null) {
			if (other.Specialite != null)
				return false;
		} else if (!Specialite.equals(other.Specialite))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}

	public static void main(String[] args) {
		Specialite[] specialites = new Specialite[3];
		specialites[0] = new Specialite(01, "S1", "java 2EE");
		specialites[1] = new Specialite(052, "S2", "gestion de projet");
		specialites[2] = new Specialite(023, "S3", "net");

		Prof[] professeur = new Prof[4];
		professeur[0] = new Prof(03, "ahmed", "abc", "20569487", "ahmedabc@mail.com", specialites[0]);
		professeur[1] = new Prof(02, "amal", "efg", "20469487", "amaldabc@mail.com", specialites[1]);
		professeur[2] = new Prof(04, "asma", "hij", "20869487", "asmaabc@mail.com", specialites[2]);
		professeur[3] = new Prof(07, "assia", "klm", "20599487", "assiaabc@mail.com", specialites[1]);

		System.out.println("Professeur par spécialité : ");
		for (Specialite s : specialites) {
			System.out.println("\t" + s);
	 	//int etat = 0;
	 	for (Prof pr : professeur) {
	 	if (pr.getSpecialite().getId()== s.getId()) {
				System.out.println("\t\t" + pr);
			//etat = 1;


}

	}	
	 //if (etat == 0) {
			//System.out.println("\t\tAucun professeur dans cette spécialité");

	 	}
}
	}