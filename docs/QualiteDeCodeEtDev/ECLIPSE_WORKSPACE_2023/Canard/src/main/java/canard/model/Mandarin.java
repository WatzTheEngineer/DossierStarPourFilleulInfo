package canard.model;

import canard.model.cancan.Cancan;
import canard.model.cancan.ComportementCancan;
import canard.model.vol.ComportementVol;
import canard.model.vol.VolerAvecDesAiles;

public class Mandarin extends Canard {

	public Mandarin(String nom, ComportementVol vol, ComportementCancan son) {
		super(nom, vol, son);
	}
	
	public Mandarin(String nom) {
		this(nom, new VolerAvecDesAiles(), new Cancan());
	}

	@Override
	public String afficher() {
		return "Je suis un vrai Mandarin";
	}

}
