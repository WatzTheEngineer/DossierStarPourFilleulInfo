package zoo.model.animal;

import zoo.application.Noisy;

public abstract class Animal implements Noisy{
	
	protected final String name;

	protected Animal(String name) {
		this.name = name;
	}
	
	public String name() {
		return this.name;
	}
	
}
