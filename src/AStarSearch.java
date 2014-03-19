import java.util.ArrayList;

/*
*	Clayton Salinger Ketner
*	February 27, 2014
*	CSCI 460 - Artificial Intelligence
*/

public class AStarSearch implements Debug
{
	public static ArrayList<Node<City>> 
	search(ArrayList<Node<City>> nodeQueue, ArrayList<Node<City>> successors, Heuristics.Heuristic heuristic)
	{
		// Add all successors to the node queue, then sort the node queue by f(n) = g(n) + h(n)
		// g(n) = cost from start to node n
		// h(n) = heuristic estimated cost from node n to goal
		nodeQueue.addAll(successors);
		Node<City>[] nodesToSort = nodeQueue.toArray(new Node[nodeQueue.size()]);
		
		// Sort by heuristic using bubble sort
		boolean sorted = false;
		while (!sorted)
		{
			sorted = true;
			for (int i = 0; i < nodesToSort.length-1; i++)
			{
				// f(n) = h(n) + g(n)
				int firstCost = Heuristics.getHeuristic(heuristic, nodesToSort[i].getData()) 
								+ costGettingTo(nodesToSort[i]);
				int secondCost = Heuristics.getHeuristic(heuristic, nodesToSort[i+1].getData())
								+ costGettingTo(nodesToSort[i+1]);
								
				if (firstCost > secondCost)
				{
					Node<City> temp = nodesToSort[i];
					nodesToSort[i] = nodesToSort[i+1];
					nodesToSort[i+1] = temp;
					sorted = false;
				}
			}
		}
		
		// Refill the node queue with the sorted one
		nodeQueue.clear();
		for (int i = 0; i < nodesToSort.length; i++)
		{
			nodeQueue.add(nodesToSort[i]);
			
			if (debug)
			{
				int heuristicCost = Heuristics.getHeuristic(heuristic, nodesToSort[i].getData());
				int gettingToCost = costGettingTo(nodesToSort[i]);
				System.out.println(nodesToSort[i].getData().name + " cost = " + 
									heuristicCost + " + " + gettingToCost + " = " + (heuristicCost + gettingToCost));
			}
		}

		if (debug) { System.out.println(); }
		
		return nodeQueue;
	}
	
	private static int costGettingTo(Node<City> currentNode)
	{
		int cost = 0;

		while (currentNode.getParent() != null)
		{
			Node<City> parent = currentNode.getParent();
			cost += currentNode.getData().getCostToNeighbor(parent.getData());

			currentNode = parent;
		}

		return cost;
	}
}