/**
 * @author Arthur Lockman | ajlockman | CS 2102 D14 | Section D02
 * @author Erin Ferguson | eeferguson | CS 2102 D14 | Section D02
 */

import tester.Tester;

public class Examples
{
	private Graph flightGraph = new Graph();
	private Node boston, worcester, hartford, chicago, denver, phoenix, houston, tulsa;

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

		flightGraph.addEdge(boston, worcester);
		flightGraph.addEdge(boston, hartford);
		flightGraph.addEdge(chicago, denver);
		flightGraph.addEdge(phoenix, houston);
		flightGraph.addEdge(houston, tulsa);
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
				t.checkExpect(flightGraph.hasRoute(chicago, worcester), false);
	}

	/**
	 * Tests the getNetworks method on graphs.
	 * @param t The tester.
	 * @return Whether or not the test passed.
	 */
	boolean testGetNetworks(Tester t)
	{
		return t.checkExpect(flightGraph.getNetworks(), null);
	}

	/**
	 * Tests the getFlights method on graphs.
	 * @param t The tester.
	 * @return Whether or not the test passed.
	 */
	boolean testGetFlights(Tester t)
	{
		return t.checkExpect(flightGraph.getFlights(), null);
	}
}
