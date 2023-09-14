package canard.model;

import canard.model.cancan.CanardMuet;
import canard.model.cancan.ComportementCancan;
import canard.model.vol.ComportementVol;
import canard.model.vol.NePasVoler;

public class Leurre extends Canard {

	public Leurre(String nom, ComportementVol vol, ComportementCancan son) {
		super(nom, vol, son);
	}
	
	public Leurre(String nom) {
		this(nom, new NePasVoler(), new CanardMuet());
	}

	@Override
	public String afficher() {
		return "Je suis un Leurre";
	}

}
