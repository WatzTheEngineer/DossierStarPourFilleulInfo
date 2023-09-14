
public class Rover {

	private Position position;
	private Direction direction;
	
	public Rover(Position position, Direction direction) {
		this.position = position;
		this.direction = direction;
	}
	
	public Rover(int x, int y, Direction direction) {
		this(new Position(x, y), direction);
	}
	
	public Rover() {
		this(new Position(0, 0), Direction.NORTH);
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Rover [position=" + position + ", direction=" + direction + "]";
	}
	
	public void move() {
		
		switch (direction) {
		case NORTH:
			this.position = new Position(position.getX(), position.getY()-1);
			break;
		case EAST:
			this.position = new Position(position.getX()+1, position.getY());
			break;
		case SOUTH:
			this.position = new Position(position.getX(), position.getY()+1);
			break;
		case WEST:
			this.position = new Position(position.getX()-1, position.getY());
			break;
		}
		
	}
	
	public void turnLeft() {
		
		switch (direction) {
		case NORTH:
			this.direction = Direction.WEST;
			break;
		case EAST:
			this.direction = Direction.NORTH;
			break;
		case SOUTH:
			this.direction = Direction.EAST;
			break;
		case WEST:
			this.direction = Direction.SOUTH;
			break;
		}
		
	}
	
	public void turnRight() {
		
		switch (direction) {
		case NORTH:
			this.direction = Direction.EAST;
			break;
		case EAST:
			this.direction = Direction.SOUTH;
			break;
		case SOUTH:
			this.direction = Direction.WEST;
			break;
		case WEST:
			this.direction = Direction.NORTH;
			break;
		}
		
	}
	
	public String getLocation() {
		return " is actually at position (x=" + this.position.getX() + ", y=" + this.position.getY() + ") towards the " + this.direction;
	}
	
}
