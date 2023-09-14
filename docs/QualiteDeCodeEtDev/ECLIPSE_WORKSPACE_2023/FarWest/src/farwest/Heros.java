package farwest;

public class Heros extends PersonnageFarWest implements EtreCapableDeTirerAuPistolet{
	
	private String profession;
	private Cheval cheval;
	
	public Heros(String prenom, String nom, String profession, Cheval cheval) {
		super(prenom, nom);
		this.profession = profession;
		this.cheval = cheval;
	}

	public void monter(Cheval cheval) {

	}
	
	public void attraper(Bandit bandit) {

	}
	
	@Override
	public String decrire() {
		return super.decrire() + " Je suis " + profession + " et mon cheval est " + cheval.decrire();
	}

	@Override
	public void tirerAuPistolet() {
		System.out.println("Je tire plus vite au pistolet : ..Pan..Pan..Pan");
	}
	
}
