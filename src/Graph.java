import java.util.LinkedList;

/**
 * A graph class contains a list of nodes, and can determine
 * the relationships between them.
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

		result.add(new Network());
		result.getFirst().addCity(nodes.getFirst());
		result.getFirst().addCities(nodes.getFirst().getGetsTo());
		nodes.getFirst().check();

		for (Node n : nodes)
		{
			if (!n.isChecked())
			{
				for (Network net : result)
				{
					if (net.contains(n))
					{
						n.check();
					}
					else if (net.containsAny(n.getGetsTo()))
					{
						net.addCity(n);
						n.check();
					}
				}
				if (!n.isChecked())
				{
					Network tmp = new Network();
					tmp.addCity(n);
					tmp.addCities(n.getGetsTo());
					result.add(tmp);
					n.check();
				}
			}
		}

		this.uncheckAll();
		return result;
	}

	/**
	 * Gets a list of pairs of cities that should be connected
	 * to create one network out of the entire graph.
	 *
	 * @return A list of pairs that should be connected.
	 */
	@Override
	public LinkedList<Pair> getFlights()
	{
		LinkedList<Pair> result = new LinkedList<Pair>();
		LinkedList<Network> networks = this.getNetworks();

		for (int i = 0; i < networks.size(); i++)
		{
			if (i+1 < networks.size())
			{
				result.add(new Pair(networks.get(i).getCities().getLast(),
						networks.get(i+1).getCities().getFirst()));
			}
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
