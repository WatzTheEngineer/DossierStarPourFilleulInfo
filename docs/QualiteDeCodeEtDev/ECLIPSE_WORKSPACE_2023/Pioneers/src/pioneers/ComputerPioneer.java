package pioneers;

public class ComputerPioneer {
	
	private String firstName;
	private String lastName;
	private Device device;
	
	public ComputerPioneer(String firstName, String lastName, Device device) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.device = device;
	}
	
	@Override
	public String toString() {
		return this.device + firstName + " " + lastName + " is a pioneer in Computer Science who worked on it.";
	}
	
	public boolean worksOn(Device device) {
		return this.device.equals(device);
	}
}
