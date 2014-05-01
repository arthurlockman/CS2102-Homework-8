import java.util.LinkedList;

/**
 * A graph class contains a list of nodes, and can determine the relationships between them.
 */
public class Graph implements IGraph
{
	private LinkedList<Node> nodes;

	/**
	 * Constructs the Graph object.
	 */
	Graph()
	{
		this.nodes = new LinkedList<Node>();
	}

	/**
	 * Creates a new node in the graph.
	 *
	 * @param cityname The name of the node to add.
	 * @return The new node that was added.
	 */
	@Override
	public Node newNode(String cityname)
	{
		Node n = new Node(cityname);
		this.nodes.add(n);
		return n;
	}

	/**
	 * Adds an edge between two nodes.
	 *
	 * @param from The node to start the edge at.
	 * @param to   The node to end the edge at.
	 */
	@Override
	public void addEdge(Node from, Node to)
	{
		from.addFlight(to);
		to.addFlight(from);
	}

	/**
	 * Determines whether the graph contains a route from
	 * one node to another.
	 *
	 * @param from The node to start at.
	 * @param to   The node to which there must be a route.
	 * @return A boolean, whether or not the route exists.
	 */
	@Override
	public boolean hasRoute(Node from, Node to)
	{
		boolean r = to.hasRoute(from);
		uncheckAll();
		return r;
	}

	/**
	 * Gets a list of all the networks represented by the
	 * graph.
	 *
	 * @return A LinkedList of networks contained in this graph.
	 */
	@Override
	public LinkedList<Network> getNetworks()
	{
		LinkedList<Network> result = new LinkedList<Network>();

		Network tmp = new Network();
		tmp.addCity(nodes.getFirst());
		tmp.addCities(nodes.getFirst().getGetsTo());
		result.add(tmp);

		for (Node n : nodes)
		{
			
		}

		return result;
	}

	/**
	 * Uncheck all nodes in the graph.
	 */
	private void uncheckAll()
	{
		for (Node n : nodes)
			n.uncheck();
	}

}
