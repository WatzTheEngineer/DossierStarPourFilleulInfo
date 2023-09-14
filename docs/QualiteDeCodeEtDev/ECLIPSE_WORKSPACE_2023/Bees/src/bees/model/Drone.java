package bees.model;

public class Drone extends HoneyBee {
	
	public Drone(String name) {
		super(name);
	}

	@Override
	public String doYourJob() {
		return super.doYourJob() + "I'm a Drone, I'm going to date our Queen";
	}
	
}
