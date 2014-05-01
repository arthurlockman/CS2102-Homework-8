/**
 * Contains a pair of nodes.
 */
public class Pair
{
	private Node node1, node2;

	/**
	 * Constructs a pair.
	 * @param node1 The first node in the pair.
	 * @param node2 The second node in the pair.
	 */
	Pair(String node1, String node2)
	{
		this.node1 = new Node(node1);
		this.node2 = new Node(node2);
	}

	/**
	 * Gets node1.
	 * @return A node, node1.
	 */
	public Node getNode1()
	{
		return node1;
	}

	/**
	 * Gets node2.
	 * @return A node, node2.
	 */
	public Node getNode2()
	{
		return node2;
	}

	/**
	 * Creates a string representation of this pair.
	 * @return A string, the representation of the pair.
	 */
	@Override
	public String toString()
	{
		return node1.getCityName() + " -> " + node2.getCityName();
	}
}
