package zoo.model.visitor;

public abstract class Visitor {

	protected final Integer REGULAR_TICKET = 10;
	
	public String sayHello() {
		return "Hello ! I'm a visitor ! " + whoAmI();
	}
	
	public abstract String whoAmI();
	
	public abstract Integer priceOfTicket();
	
}
