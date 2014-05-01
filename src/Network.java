import java.util.LinkedList;

/**
 * A network contains a list of cities that are connected by flights.
 */
public class Network implements INetwork
{
	private LinkedList<String> cities = new LinkedList<String>();

	/**
	 * Constructs a network object.
	 */
	Network()
	{
		//Empty constructor.
	}

	/**
	 * Constructs a network object and populates the list of cities with a
	 * pre-created list of cities.
	 * @param cities A LinkedList of Strings, the list of cities to populate
	 *               the network with.
	 */
	Network(LinkedList<String> cities)
	{
		this.cities.addAll(cities);
	}

	/**
	 * Returns the list of cities contained in this network.
	 * @return A linkedList of Strings, the list of cities in the network.
	 */
	@Override
	public LinkedList<String> getCities()
	{
		return cities;
	}

	/**
	 * Adds a city to the network.
	 * @param city A string, the city to add to the network.
	 */
	@Override
	public void addCity(String city)
	{
		if (!this.contains(city))
			cities.add(city);
	}

	/**
	 * Adds a city to the network.
	 *
	 * @param city A node, the city to add to the network.
	 */
	@Override
	public void addCity(Node city)
	{
		if (!this.contains(city))
			cities.add(city.getCityName());
	}

	/**
	 * Add a collection of citites (as nodes) to the network.
	 *
	 * @param cities The nodes to add.
	 */
	@Override
	public void addCities(LinkedList<Node> cities)
	{
		for (Node n : cities)
			this.addCity(n);
	}

	/**
	 * Merge two networks. This method does check for duplicates.
	 *
	 * @param other The network to merge with.
	 * @return The merged networks.
	 */
	@Override
	public Network merge(Network other)
	{
		Network r = new Network();
		for (String s : other.getCities())
		{
			if (!this.contains(s))
				r.addCity(s);
		}
		return null;
	}

	/**
	 * Test if this network contains a city.
	 *
	 * @param city The city to search for.
	 * @return Whether or not this network contains the specified city.
	 */
	@Override
	public boolean contains(String city)
	{
		for (String s : cities)
		{
			if (s.equals(city))
				return true;
		}
		return false;
	}

	/**
	 * Test if this network contains a city.
	 *
	 * @param city The city to search for.
	 * @return Whether or not this network contains the specified city.
	 */
	@Override
	public boolean contains(Node city)
	{
		for (String s : cities)
		{
			if (s.equals(city.getCityName()))
				return true;
		}
		return false;
	}

	/**
	 * Test if this network contains any of the listed cities.
	 *
	 * @param cities A list of nodes to check for.
	 * @return Whether or not this network contains any of the listed nodes.
	 */
	@Override
	public boolean containsAny(LinkedList<Node> cities)
	{
		boolean r = false;

		for (Node n : cities)
			r = this.contains(n);

		return r;
	}
}
