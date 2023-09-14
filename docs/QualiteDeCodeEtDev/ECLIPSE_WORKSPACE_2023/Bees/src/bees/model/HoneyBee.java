package bees.model;

public abstract class HoneyBee {
	
	protected final String name;
	
	protected HoneyBee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String doYourJob() {
		return this.getName() + " I'm a HoneyBee ";
	}
	
	public String fly() {
		return "I believe, I can fly";
	}
	
}
