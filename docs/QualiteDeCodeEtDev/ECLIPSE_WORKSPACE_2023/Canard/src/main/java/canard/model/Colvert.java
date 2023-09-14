package canard.model;

import canard.model.cancan.Cancan;
import canard.model.cancan.ComportementCancan;
import canard.model.vol.ComportementVol;
import canard.model.vol.VolerAvecDesAiles;

public class Colvert extends Canard {

	public Colvert(String nom, ComportementVol vol, ComportementCancan son) {
		super(nom, vol, son);
	}
	
	public Colvert(String nom) {
		this(nom, new VolerAvecDesAiles(), new Cancan());
	}

	@Override
	public String afficher() {
		return "Je suis un vrai colvert";
	}

}
