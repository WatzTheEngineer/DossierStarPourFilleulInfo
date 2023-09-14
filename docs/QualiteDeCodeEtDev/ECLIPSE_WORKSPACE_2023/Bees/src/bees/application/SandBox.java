package bees.application;

import bees.gui.Console;
import bees.model.Drone;
import bees.model.HoneyBee;
import bees.model.Queen;
import bees.model.Worker;

public class SandBox {

	public static void main(String[] args) {

		HoneyBee melli = new Queen("Mellifera");
		HoneyBee may = new Worker("Maya");
		HoneyBee will = new Drone("Willy");

		Console.title("Appel à getClass de la classe Object ");
		Console.message("Classe de l'objet melli : " + melli.getClass());
		Console.message("Classe de l'objet may : " + may.getClass());
		Console.message("Classe de l'objet will : " + will.getClass());

		Console.title("Appel à getName de la classe Class via le mot clé class ");
		Console.message("Classe de Class Queen.class : " + (Queen.class).getName());
		Console.message("Classe de Class Worker.class : " + (Worker.class).getName());
		Console.message("Classe de Class Drone.class : " + (Drone.class).getName());

		Console.title("Appel à getName de la classe HoneyBee : ");
		Console.message("Attribut name de l'objet melli : " + melli.getName());
		Console.message("Attribut name de l'objet may : " + may.getName());
		Console.message("Attribut name de l'objet will : " + will.getName());

		Console.title("Operateur instanceof ");
		if (melli instanceof HoneyBee) {
			Console.message("melli est une instance de HoneyBee");
		}
		if (melli instanceof Queen) {
			Console.message("melli est une instance de Queen");
		}

		if (melli instanceof Worker) {
			Console.message("melli est une instance de Worker");
		}
		if (melli instanceof Drone) {
			Console.message("melli est une instance de Drone");
		}
		
		
	}

}
