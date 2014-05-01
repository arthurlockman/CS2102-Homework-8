import java.util.LinkedList;

/**
 * An interface for creating networks.
 */
public interface INetwork
{
	/**
	 * Returns the list of cities contained in this network.
	 * @return A linkedList of Strings, the list of cities in the network.
	 */
	public LinkedList<String> getCities();

	/**
	 * Adds a city to the network.
	 * @param city A string, the city to add to the network.
	 */
	public void addCity(String city);

	/**
	 * Adds a city to the network.
	 * @param city A node, the city to add to the network.
	 */
	public void addCity(Node city);

	/**
	 * Add a collection of citites (as nodes) to the network.
	 * @param cities The nodes to add.
	 */
	public void addCities(LinkedList<Node> cities);

	/**
	 * Merge two networks. This method does check for duplicates.
	 * @param other The network to merge with.
	 * @return The merged networks.
	 */
	public Network merge(Network other);

	/**
	 * Test if this network contains a city.
	 * @param city The city to search for.
	 * @return Whether or not this network contains the specified city.
	 */
	public boolean contains(String city);

	/**
	 * Test if this network contains a city.
	 * @param city The city to search for.
	 * @return Whether or not this network contains the specified city.
	 */
	public boolean contains(Node city);
}
