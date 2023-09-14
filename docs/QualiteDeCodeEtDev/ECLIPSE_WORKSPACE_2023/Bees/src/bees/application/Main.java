package bees.application;

import java.util.ArrayList;
import java.util.Arrays;

import bees.gui.Console;
import bees.model.Drone;
import bees.model.HoneyBee;
import bees.model.Queen;
import bees.model.Worker;

public class Main {

	public static void main(String[] args) {

		collectionOfHoneyBees();

	}

	public static void someHoneyBees() {

		Console.title(" Some honeybees ");

		HoneyBee queen = new Queen("Mellifera");
		HoneyBee firstWorker = new Worker("Maya");
		HoneyBee secondWorker = new Worker("Marguerite");
		HoneyBee thirdWorker = new Worker("Propolis");
		HoneyBee firstDrone = new Drone("Willy");
		HoneyBee secondDrone = new Drone("Didier");

		Console.message(queen.doYourJob());
		Console.message(firstWorker.doYourJob());
		Console.message(secondWorker.doYourJob());
		Console.message(thirdWorker.doYourJob());
		Console.message(firstDrone.doYourJob());
		Console.message(secondDrone.doYourJob());

		Console.message(Console.SEPARATOR);

		Console.message(queen.fly());
		Console.message(firstWorker.fly());
		Console.message(secondWorker.fly());
		Console.message(thirdWorker.fly());
		Console.message(firstDrone.fly());
		Console.message(secondDrone.fly());
	}

	private static void collectionOfHoneyBees() {

		int queenCounter = 0;
		int droneCounter = 0;
		int workerCounter = 0;
		Console.title(" Collection of Honeybees ");

		ArrayList<HoneyBee> honeybees = new ArrayList<>();

		honeybees.addAll(Arrays.asList(new Queen("Mellifera"), new Worker("Maya"), new Worker("Marguerite"),
				new Worker("Propolis"), new Drone("Willy"), new Drone("Didier")));

		for (HoneyBee honeyBee : honeybees) {
			Console.message(honeyBee.doYourJob());
			Console.message(honeyBee.fly());
			Console.message(Console.SEPARATOR);
			if (honeyBee instanceof Queen) {
				queenCounter++;
			}
			else if (honeyBee instanceof Worker) {
				workerCounter++;
			}
			else if (honeyBee instanceof Drone) {
				droneCounter++;
			}
		}

		Console.title("My collection has " + honeybees.size() + " bees");
		Console.message("-> " + queenCounter + " queen(s)");
		Console.message("-> " + workerCounter + " worker(s)");
		Console.message("-> " + droneCounter + " drone(s)");
	}

}
