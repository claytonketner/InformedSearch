import java.util.ArrayList;

/*
*	Clayton Salinger Ketner
*	February 27, 2014
*	CSCI 460 - Artificial Intelligence
*/

public class GreedySearch
{
	public static ArrayList<Node<City>> 
	search(ArrayList<Node<City>> nodeQueue, ArrayList<Node<City>> successors, Heuristics.Heuristic heuristic)
	{
		// Add all successors to the node queue, then sort the node queue by heuristic cost
		nodeQueue.addAll(successors);
		Node<City>[] nodesToSort = nodeQueue.toArray(new Node[nodeQueue.size()]);

		// Sort by heuristic using bubble sort
		boolean sorted = false;
		while (!sorted)
		{
			sorted = true;
			for (int i = 0; i < nodesToSort.length-1; i++)
			{
				int firstHCost = Heuristics.getHeuristic(heuristic, nodesToSort[i].getData());
				int secondHCost = Heuristics.getHeuristic(heuristic, nodesToSort[i+1].getData());
				if (firstHCost > secondHCost)
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
		}
		
		return nodeQueue;
	}
}