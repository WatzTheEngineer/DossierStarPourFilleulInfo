package canard.model;

import canard.model.cancan.ComportementCancan;
import canard.model.vol.ComportementVol;

public abstract class Canard{

	private final String nom;
	private ComportementVol vol;
	private ComportementCancan son;
	
	public String nager() {
		return "Tous les canards flottent, meme les leurres !";
	}

	public abstract String afficher();

	protected Canard(String nom, ComportementVol vol, ComportementCancan son) {
		this.nom = nom;
		this.vol = vol;
		this.son = son;
	}

	public String nom() {
		return this.nom;
	}
	
	public String effectuerVol() {
		return vol.voler();
	}
	
	public String effectuerCancan() {
		return son.cancaner();
	}
	
	public void setVol(ComportementVol vol) {
		this.vol = vol;
	}

	public void setSon(ComportementCancan son) {
		this.son = son;
	}
	
}
