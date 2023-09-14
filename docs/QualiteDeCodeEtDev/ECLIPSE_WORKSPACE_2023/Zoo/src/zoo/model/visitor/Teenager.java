package zoo.model.visitor;

public class Teenager extends Child {

	public Teenager(Integer age) {
		super(age);
	}
	
	@Override
	public Integer priceOfTicket() {
		return super.REGULAR_TICKET/2;
	}
	
	@Override
	public String whoAmI() {
		return "I'm between 15 and 18 years old I'm a teenager !";
	}

}
