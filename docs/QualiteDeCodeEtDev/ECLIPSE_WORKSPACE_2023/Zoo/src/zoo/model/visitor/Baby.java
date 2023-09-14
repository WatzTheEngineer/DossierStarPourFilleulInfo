package zoo.model.visitor;

import zoo.application.Noisy;

public class Baby extends Child implements Noisy{

	public Baby(Integer age) {
		super(age);
	}
	
	public Baby() {
		this(0);
	}

	@Override
	public String noise() {
		return "waaaaaaaaaaaaaa";
	}
	
	@Override
	public Integer priceOfTicket() {
		return 0;
	}

	@Override
	public String whoAmI() {
		return "I'm under 1 year old : I'm a baby !";
	}
}
