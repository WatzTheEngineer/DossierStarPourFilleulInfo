
public class Main {

	public static void main(String[] args) {

		Rover viper = new Rover();
		System.out.println("viper" + viper.getLocation());
		System.out.println("Viper actually : " + viper.getPosition() + " " + viper.getDirection());
		System.out.println(" ========================================== ");

		Rover python = new Rover(new Position(5, 10), Direction.EAST);
		System.out.println("python" + python.getLocation());
		System.out.println("Python actually : " + python.getPosition() + " " + python.getDirection());
		System.out.println(" ========================================== ");

		Rover anaconda = new Rover(20, 30, Direction.SOUTH);
		System.out.println("anaconda" + anaconda.getLocation());
		System.out.println("Anaconda actually : " + anaconda.getPosition() + " " + anaconda.getDirection());
		System.out.println(" ========================================== ");
		
		System.out.println("========================== TEST ZONE =============================");
		
		System.out.println("viper is moving");
		viper.move();
		System.out.println("Viper actually : " + viper.getPosition() + " " + viper.getDirection());
		
		System.out.println("viper turn left");
		viper.turnLeft();
		System.out.println("Viper actually : " + viper.getPosition() + " " + viper.getDirection());
		
		System.out.println("viper is moving");
		viper.move();
		System.out.println("Viper actually : " + viper.getPosition() + " " + viper.getDirection());
		
		System.out.println("viper turn right");
		viper.turnRight();
		System.out.println("Viper actually : " + viper.getPosition() + " " + viper.getDirection());
		
		System.out.println("viper is moving");
		viper.move();
		System.out.println("Viper actually : " + viper.getPosition() + " " + viper.getDirection());
		
		System.out.println("viper is moving");
		viper.move();
		System.out.println("Viper actually : " + viper.getPosition() + " " + viper.getDirection());
		
		System.out.println("viper turn left");
		viper.turnLeft();
		System.out.println("Viper actually : " + viper.getPosition() + " " + viper.getDirection());
		
		System.out.println("viper is moving");
		viper.move();
		System.out.println("Viper actually : " + viper.getPosition() + " " + viper.getDirection());
	}

}
