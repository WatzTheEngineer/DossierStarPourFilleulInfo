package zoo.model.visitor;

public abstract class Child extends Visitor {
	
	protected Integer age;

	protected Child(Integer age) {
		super();
		this.age = age;
	}

	@Override
	public String whoAmI() {
		return "I'm a Child. ";
	}

	@Override
	public abstract Integer priceOfTicket();

}
