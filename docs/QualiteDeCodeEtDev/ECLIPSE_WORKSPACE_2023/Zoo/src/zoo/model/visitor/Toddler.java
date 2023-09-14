package zoo.model.visitor;

public class Toddler extends Child {

	public Toddler(Integer age) {
		super(age);
	}

	@Override
	public Integer priceOfTicket() {
		return super.REGULAR_TICKET/4;
	}

	@Override
	public String whoAmI() {
		return "I'm between 1 and 6 year old : I'm a toddler !";
	}
}
