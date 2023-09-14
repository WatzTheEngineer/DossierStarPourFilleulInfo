package farwest;

public class Bandit extends PersonnageFarWest implements EtreCapableDeTirerAuPistolet{

	private int taille;
	private boolean estEnPrison;
	
	public Bandit(String prenom, String nom, int taille, boolean estEnPrison) {
		super(prenom, nom);
		this.taille = taille;
		this.estEnPrison = estEnPrison;
	}
	
	public Bandit(String prenom, String nom, int taille) {
		this(prenom,nom,taille,false);
	}

	public void faireUnBraquage() {
		
	}
	
	public void mettreEnPrison() {
		this.estEnPrison = true;
	}
	
	public void libererDePrison() {
		this.estEnPrison = false;
	}
	
	@Override
	public String decrire() {
		String state;
		if (estEnPrison) {
			state = "en Prison";
		}
		else {
			state = "Libre";
		}
		return super.decrire() + " Je mesure " + taille + " cm et je suis " + state;
	}

	@Override
	public void tirerAuPistolet() {
		// TODO Auto-generated method stub
		
	}
}
