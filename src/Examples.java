/**
 * @author Arthur Lockman | ajlockman | CS 2102 D14 | Section D02
 * @author Erin Ferguson | eeferguson | CS 2102 D14 | Section D02
 */

import tester.Tester;

import java.util.LinkedList;

/**
 * A class to hold Homework 8 examples.
 */
public class Examples
{
	private Graph flightGraph = new Graph();

	private Node boston, worcester, hartford, chicago, denver, phoenix;
	private Node portland, newyork, detroit, houston, tulsa;

	private LinkedList<String> testNetwork1Feeders,
			testNetwork2Feeders, testNetwork3Feeders, testNetwork4Feeders;
	private Network testNetwork1, testNetwork2, testNetwork3, testNetwork4;
	private LinkedList<Network> testNetworks;
	private LinkedList<Pair> testPairs;

	/**
	 * Constructs the examples class.
	 */
	Examples()
	{
		boston = flightGraph.newNode("Boston");
		worcester = flightGraph.newNode("Worcester");
		hartford = flightGraph.newNode("Hartford");
		chicago = flightGraph.newNode("Chicago");
		denver = flightGraph.newNode("Denver");
		phoenix = flightGraph.newNode("Phoenix");
		houston = flightGraph.newNode("Houston");
		tulsa = flightGraph.newNode("Tulsa");
		portland = flightGraph.newNode("Portland");
		newyork = flightGraph.newNode("New York");
		detroit = flightGraph.newNode("Detroit");

		flightGraph.addEdge(boston, worcester);
		flightGraph.addEdge(boston, hartford);
		flightGraph.addEdge(chicago, denver);
		flightGraph.addEdge(phoenix, houston);
		flightGraph.addEdge(houston, tulsa);
		flightGraph.addEdge(portland, newyork);
		flightGraph.addEdge(detroit, portland);

		testNetwork1Feeders = new LinkedList<String>();
		testNetwork2Feeders = new LinkedList<String>();
		testNetwork3Feeders = new LinkedList<String>();
		testNetwork4Feeders = new LinkedList<String>();

		testNetwork1Feeders.add("Boston");
		testNetwork1Feeders.add("Worcester");
		testNetwork1Feeders.add("Hartford");

		testNetwork2Feeders.add("Chicago");
		testNetwork2Feeders.add("Denver");

		testNetwork3Feeders.add("Phoenix");
		testNetwork3Feeders.add("Houston");
		testNetwork3Feeders.add("Tulsa");

		testNetwork4Feeders.add("Portland");
		testNetwork4Feeders.add("New York");
		testNetwork4Feeders.add("Detroit");

		testNetwork1 = new Network(testNetwork1Feeders);
		testNetwork2 = new Network(testNetwork2Feeders);
		testNetwork3 = new Network(testNetwork3Feeders);
		testNetwork4 = new Network(testNetwork4Feeders);

		testNetworks = new LinkedList<Network>();
		testNetworks.add(testNetwork1);
		testNetworks.add(testNetwork2);
		testNetworks.add(testNetwork3);
		testNetworks.add(testNetwork4);

		testPairs = new LinkedList<Pair>();
		testPairs.add(new Pair("Hartford", "Chicago"));
		testPairs.add(new Pair("Denver", "Phoenix"));
		testPairs.add(new Pair("Tulsa", "Portland"));
	}

	/**
	 * Tests the hasRoute method on graphs and on nodes.
	 * @param t The tester.
	 * @return Whether or not the test passed.
	 */
	boolean testHasRoute(Tester t)
	{
		return t.checkExpect(flightGraph.hasRoute(boston, worcester), true) &&
				t.checkExpect(flightGraph.hasRoute(boston, hartford), true) &&
				t.checkExpect(flightGraph.hasRoute(chicago, denver), true) &&
				t.checkExpect(flightGraph.hasRoute(phoenix, houston), true) &&
				t.checkExpect(flightGraph.hasRoute(houston, tulsa), true) &&
				t.checkExpect(flightGraph.hasRoute(boston, chicago), false) &&
				t.checkExpect(flightGraph.hasRoute(boston, boston), true) &&
				t.checkExpect(flightGraph.hasRoute(boston, denver), false) &&
				t.checkExpect(flightGraph.hasRoute(chicago, phoenix), false) &&
				t.checkExpect(flightGraph.hasRoute(worcester, hartford), true) &&
				t.checkExpect(flightGraph.hasRoute(chicago, worcester), false) &&
				t.checkExpect(flightGraph.hasRoute(detroit, newyork), true) &&
				t.checkExpect(flightGraph.hasRoute(newyork, newyork), true) &&
				t.checkExpect(flightGraph.hasRoute(detroit, boston), false);
	}

	/**
	 * Tests the getNetworks method on graphs.
	 * @param t The tester.
	 * @return Whether or not the test passed.
	 */
	boolean testGetNetworks(Tester t)
	{
		return t.checkExpect(flightGraph.getNetworks(), testNetworks);
	}

	/**
	 * Tests the getFlights method on graphs.
	 * @param t The tester.
	 * @return Whether or not the test passed.
	 */
	boolean testGetFlights(Tester t)
	{
		return t.checkExpect(flightGraph.getFlights(), testPairs);
	}
}
