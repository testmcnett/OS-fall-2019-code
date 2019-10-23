/**
 * Interface for shared memory.
 *
 * Figure 3.15
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Eighth Edition
 * Copyright John Wiley & Sons - 2010.
 */
package bounded;
public interface Buffer <E>
{
	// producers call this method
	public void insert(E item);

	// consumers call this method
	public E remove();
}
