import java.util.LinkedList;

/**
 * An interface for writing graphs.
 */
public interface IGraph
{
	/**
	 * Creates a new node in the graph.
	 * @param cityname The name of the node to add.
	 * @return The new node that was added.
	 */
	Node newNode(String cityname);

	/**
	 * Adds an edge between two nodes.
	 * @param from The node to start the edge at.
	 * @param to The node to end the edge at.
	 */
	void addEdge(Node from, Node to);

	/**
	 * Determines whether the graph contains a route from
	 * one node to another.
	 * @param from The node to start at.
	 * @param to The node to which there must be a route.
	 * @return A boolean, whether or not the route exists.
	 */
	boolean hasRoute(Node from, Node to);

	/**
	 * Gets a list of all the networks represented by the
	 * graph.
	 * @return A LinkedList of networks contained in this graph.
	 */
	LinkedList<Network> getNetworks();
}
