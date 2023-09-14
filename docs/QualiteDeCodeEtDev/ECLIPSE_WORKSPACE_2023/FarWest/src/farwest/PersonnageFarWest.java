package farwest;

public class PersonnageFarWest {
	
	protected final String prenom;
	protected final String nom;
	
	public PersonnageFarWest(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}
	
	public String decrire() {
		return nom + " " + prenom + "!";
	}
	
}
