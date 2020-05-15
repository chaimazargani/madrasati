import com.pfe.madrasati.model.Personne;

public class Etudiant extends Personne {
	public int cne;

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Etudiant(String nom, String prenom, int id) {
		super(nom, prenom, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Etudiant [cne=" + cne + ", nom=" + nom + ", prenom=" + prenom + ", id=" + id + "]";
	}

	public static void main(String[] args) {

       Etudiant etud1 = new Etudiant ( "med" , "abc" , 2 );
       

	
}
}