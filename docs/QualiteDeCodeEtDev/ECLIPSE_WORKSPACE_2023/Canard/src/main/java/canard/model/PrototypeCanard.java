package canard.model;

import canard.model.cancan.CanardMuet;
import canard.model.cancan.ComportementCancan;
import canard.model.vol.ComportementVol;
import canard.model.vol.NePasVoler;

public class PrototypeCanard extends Canard {

	public PrototypeCanard(String nom, ComportementVol vol, ComportementCancan son) {
		super(nom, vol, son);
	}
	
	public PrototypeCanard(String nom) {
		this(nom, new NePasVoler(), new CanardMuet());
	}

	@Override
	public String afficher() {
		return "Je suis un prototype de canard";
	}

}
