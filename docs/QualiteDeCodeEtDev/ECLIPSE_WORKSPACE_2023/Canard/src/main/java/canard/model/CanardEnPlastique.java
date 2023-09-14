package canard.model;

import canard.model.cancan.Coincoin;
import canard.model.cancan.ComportementCancan;
import canard.model.vol.ComportementVol;
import canard.model.vol.NePasVoler;

public class CanardEnPlastique extends Canard {

	public CanardEnPlastique(String nom, ComportementVol vol, ComportementCancan son) {
		super(nom, vol, son);
	}
	
	public CanardEnPlastique(String nom) {
		this(nom, new NePasVoler(), new Coincoin());
	}

	@Override
	public String afficher() {
		return "Je suis un Canard en Plastique";
	}

}
