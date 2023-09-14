package calc.model;

import calc.util.DivisionParZeroException;

public class Calculatrice {
	
	public int additionner(int terme1, int terme2) {
		return terme1 + terme2;
	}
	
	public int soustraire(int terme1, int terme2) {
		return terme1 - terme2;
	}
	
	public int multiplier(int facteur1, int facteur2) {
		return facteur1 * facteur2;
	}
	
	public int diviser(int dividende, int diviseur) throws DivisionParZeroException {
		if (diviseur == 0) {
			throw new DivisionParZeroException("BatException");
		}
		return dividende / diviseur;
	}
	
}
