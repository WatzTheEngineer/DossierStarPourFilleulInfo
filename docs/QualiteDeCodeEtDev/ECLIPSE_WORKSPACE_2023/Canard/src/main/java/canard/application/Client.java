package canard.application;

import java.util.ArrayList;
import java.util.List;

import canard.model.Canard;
import canard.model.Colvert;
import canard.model.PrototypeCanard;
import canard.model.vol.PropulsionAReaction;

public class Client {

	private static final String LIGNE = "-----------------";

	public static void main(String[] args) {

		List<Canard> canards = mettreDesCanardsDansMonSimulateur();

		testerToutLeCanard(canards);

	}

	private static List<Canard> mettreDesCanardsDansMonSimulateur() {
		List<Canard> canards = new ArrayList<>();
		canards.add(new Colvert("Piero"));
		canards.add(new PrototypeCanard("Jack"));
		return canards;
	}

	private static void testerToutLeCanard(List<Canard> canards) {
		System.out.println(LIGNE);
		System.out.println("Test complets des canards :");
		System.out.println(LIGNE);

		for (Canard canard : canards) {
			if (canard instanceof PrototypeCanard) {
				System.out.println(canard.afficher());
				System.out.println(canard.effectuerVol());
				canard.setVol(new PropulsionAReaction());
				System.out.println(canard.effectuerVol());
			} else {
				System.out.println(canard.afficher());
				System.out.println(canard.nager());
				System.out.println(canard.effectuerCancan());
				System.out.println(canard.effectuerVol());
			}
		}
	}
}
