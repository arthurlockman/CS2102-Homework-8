import java.util.LinkedList;

/**
 * The node class contains data about a node and the other nodes it has routes to
 */
public class Node implements INode
{
	private String cityName;
	private LinkedList<Node> getsTo;
	private boolean checked = false;

	/**
	 * Constructor for the Node class.
	 * @param cityName A string, the name of this node.
	 */
	Node(String cityName)
	{
		this.cityName = cityName;
		this.getsTo = new LinkedList<Node>();
	}

	/**
	 * Get the list of connections to this node.
	 * @return A LinkedList of Nodes, the list of connections.
	 */
	public LinkedList<Node> getGetsTo()
	{
		return getsTo;
	}

	/**
	 * Get the name of this node.
	 * @return a String, the name of this node.
	 */
	public String getCityName()
	{
		return cityName;
	}

	/**
	 * Add a route to this node.
	 * @param toNode the node to add the route to.
	 */
	@Override
	public void addFlight(Node toNode)
	{
		this.getsTo.add(toNode);
	}

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
	 * @param visited Nodes previously visited in the search.
	 * @return A boolean, whether or not the route exists.
	 */
	@Override
	public boolean hasRoute(Node to)
	{
		if (this.equals(to))
			return true;
		else if (this.checked)
			return false;
		else
		{
			this.checked=true;
			for (Node c : this.getsTo) {
				if (c.hasRoute(to)) {
					return true;
				}
			}
			return false;
		}
	}

	/**
	 * Uncheck the node.
	 */
	@Override
	public void uncheck()
	{
		this.checked = false;
	}

	/**
	 * Determine if the node has been checked.
	 *
	 * @return A boolean, if the node is checked or not.
	 */
	@Override
	public boolean isChecked()
	{
		return this.checked;
	}

	/**
	 * Check off this node.
	 */
	@Override
	public void check()
	{
		this.checked = true;
	}
}
