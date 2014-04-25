
[Source](http://web.cs.wpi.edu/~cs2102/d14/hw8.html "Permalink to Homework 8 - Graphs")

# Homework 8 - Graphs

##  CS 2102 - Dterm 14

##  Homework 8 - Graphs: Connected Networks

###  Due: Friday, May 2 at 5pm




## Assignment Goals

  * to be able to write programs over graphs with cyclic data

Note: Please document all of your classes and methods with Javadoc for this assignment.

##  Problems

Airlines are struggling to make a profit. A handful of regional, low-fare airlines have decided to merge into a unified network, hoping to entice more business with broader low-cost service. Since each airline used to operate its own services, the new "national" airline has some gaps. For example, if one partner airline serviced only the southwest and another only the midwest, the merged airline will need at least one flight between the southwest and the midwest to meet its service goals.

The flight-scheduling team of the merged airline has already created a large graph of all the existing flights offered across the partner airlines. Your job is to write a program to (a) help find the gaps in the service and (b) suggest how they might fill in those gaps. There may have been gaps in the service within an individual regional airline, so viewing the gaps solely through the regional airlines' networks will not help here. To find the gaps in service, we first need to break the national flight graph into subsets of cities that can reach one another, but cannot reach cities in any other subset. For example, assume we have flights between Boston/Worcester, Boston/Hartford, Chicago/Denver, Phoenix/Houston, and Houston/Tulsa. This graph would yield three subsets: (Boston, Worcester, Hartford), (Chicago, Denver), and (Phoenix, Houston, Tulsa). We'll refer to each subset as a _network_.

  1. Create a class `Node` that consists of the name of a city and a list of Nodes to which there exist a direct flight (as we developed in class). Unlike the code we developed in class, a connection between two cities should denote that there are flights in either direction between the cities (in other words, if you can fly from city A to city B, you can fly from city B to city A).

  2. Create a class `Graph` that contains a list of Nodes. Create at least one non-trivial example of a Graph (you may use the example described above if you wish).

  3. Create a class `Network` that is a LinkedList of city names (Strings).

  4. Write a method `getNetworks()` on graphs that returns a `LinkedList` of Networks.

Hints: Don't attempt to code this method until you understand what's being asked for. Work out examples on paper. Draw pictures of the data. Write your test methods in the Examples class before you start to code. You will need to keep track of visited Nodes; if you use a LinkedList of Nodes to do this, then code `getNetworks()` as a wrapper method that calls a helper with an empty visited list as an argument.

  5. Wrtie a method `newFlights()` on graphs that returns a list of pairs of city names such that adding flights between each pair would turn the entire graph into one network. Your returned list should have as few pairs as possible, but does not need to account for any other constraints (such as the distance between cities for the proposed flights).

## Grading

Here is the [general grading rubric][1] for the assignments in this course. We will be looking for evidence that you understand the algorithm, as evidenced by your code and test cases. We expect to see Javadoc documentation on all classes and methods, good tests, and clean code.

## What to Turn In

Using [web-based turnin][2], submit .java files containing the final versions of all classes, interfaces, and examples developed for this assignment. Do not submit the .class files. Create a zip file containing the separate files for each class/interface.

* * *

   [1]: http://web.cs.wpi.edu/common/general-design.txt
   [2]: https://turnin.cs.wpi.edu:8088/turnin.rkt
  