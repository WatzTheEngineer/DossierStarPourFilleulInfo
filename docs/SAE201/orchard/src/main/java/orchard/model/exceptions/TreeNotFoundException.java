package orchard.model.exceptions;

import orchard.model.Orchard;
import orchard.model.Tree;

/**{@link Exception} used when the wanted {@link Tree} do not exist in the {@link Orchard}
 * @see IllegalStateException
 * @see Orchard#getTreeByColor(orchard.model.FruitColor)
 */
@SuppressWarnings("serial")
public class TreeNotFoundException extends IllegalStateException {
	
	public TreeNotFoundException(String message) {
		super(message);
	}
}
