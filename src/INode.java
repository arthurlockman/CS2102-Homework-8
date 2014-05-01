import java.util.LinkedList;

/**
 * An interface for creating nodes.
 */
public interface INode
{
	/**
	 * Add a route to this node.
	 * @param toNode the node to add the route to.
	 */
	void addFlight(Node toNode);

	/**
	 * Determine whether exists a route from this Node to the given node.
	 *
	 * INVARIANT: Node n is marked as checked iff n.hasRoute has been called
	 * since the most recent call to hasRoute on the overall graph.
	 *
	 * TERMINATES because code checks checked flag before recurring,
	 * a new node is marked as checked every time hasRoute is called
	 * from a new node, the invariant guarantees that nodes remain
	 * checked until computation completes, and there are a finite
	 * number of possible nodes on which to call hasRoute.
	 *
	 * @param to The node to find a route to.
	 * @return A boolean, whether or not the route exists.
	 */
	boolean hasRoute(Node to);

	/**
	 * Uncheck the node.
	 */
	void uncheck();

	/**
	 * Determine if the node has been checked.
	 * @return A boolean, if the node is checked or not.
	 */
	boolean isChecked();

	/**
	 * Check off this node.
	 */
	void check();
}
