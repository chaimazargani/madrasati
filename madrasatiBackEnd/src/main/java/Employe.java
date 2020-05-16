import com.pfe.madrasati.model.Personne;

public class Employe extends Personne {
	private Double salaire ;

	

	public Employe(double d, String string, String string2, int i, int j) {
		super();
		// TODO Auto-generated constructor stub
	}



	public Employe(String nom, String prenom, int id) {
		super(nom, prenom, id);
		// TODO Auto-generated constructor stub
	}

    

	


	@Override
	public String toString() {
		return "Employe [salaire=" + salaire + ", nom=" + nom + ", prenom=" + prenom + ", id=" + id + "]";
	}



	public static void main(String[] args) {

		Employe emp1 = new Employe ( 200.222 ,  "salah" , "abc" , 7 , 1000);
		Employe empl2 = new Employe (500.52 ,"asma" , "abc" , 9, 2000);
		Personne per1 = new Personne("ali", "zzz", 2);
//		Etudiant et1 =new Etudiant (22554, "abc" , "aaa" , 4 );

	}
}



