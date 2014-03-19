import java.util.ArrayList;

/*
*	Clayton Salinger Ketner
*	February 11, 2014
*	CSCI 460 - Artificial Intelligence
*/

public class Node<E> implements Comparable<Node<E>>
{
	private Node<E> parent;
	private ArrayList<Node<E>> children;
	private E data;

	public Node(Node<E> parent, E data)
	{
		this.parent = parent;
		this.children = new ArrayList<Node<E>>();
		this.data = data;
	}
	
	public boolean isRoot()
	{
		if (parent == null)
			return true;
		return false;
	}
	
	public Node<E> getParent()
	{
		return parent;
	}
	
	public ArrayList<Node<E>> getChildren()
	{
		return children;
	}
	
	public E getData()
	{
		return data;
	}

	public Node<E> getChildWithData(E dataToFind)
	{
		for (Node<E> child : children)
		{
			if (child.getData().equals(dataToFind))
			{
				return child;
			}
		}
		return null; // Child with that data wasn't in the list
	}

	/** Removes the specified child from this node.
	*	@return Returns the removed child or null if the child didn't exist. **/
	public Node<E> removeChildWithData(E dataToRemove)
	{
		// Returns null if child wasn't found
		Node<E> foundChild = this.getChildWithData(dataToRemove);

		children.remove(foundChild);
		return foundChild;
	}

	/** Adds a child and sets its parent to THIS. The child's children are carried over. **/
	public void addChild(Node<E> childToAdd)
	{
		// Create and add a new child with THIS as the parent and the same data as before
		Node<E> newChild = new Node<E>(this, childToAdd.getData());

		// Transfer children to new child object
		for (Node<E> childChild : childToAdd.getChildren())
			newChild.addChild(childChild);

		children.add(newChild);
	}

	/** Checks if any parents all the way up to the top have this data.
		For use in loop detection. **/
	public boolean hasAncestor(E dataToCheck)
	{
		// Check data
		// City.equals compares names to check for equivalence
		if (data.equals(dataToCheck))
			return true;

		// Base case
		if (this.isRoot())
			return false;

		// Recurse
		return parent.hasAncestor(dataToCheck);
	}

	@Override
	public int compareTo(Node<E> arg0)
	{
		if (this.equals(arg0))
			return 0;
		return 1;
	}
}