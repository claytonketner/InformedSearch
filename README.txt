Clayton Salinger Ketner
ID# 3938850756
cketner@usc.edu
---------------------------------
CSCI 460 Assignment 2
---------------------------------

PROGRAM STRUCTURE
	- The program's main method is in Homework2.java.
	- Homework2.java:
		- Contains the "generic search algorithm" in a method called genericSearch()
		- Contains the expand() method that expands a node and returns the successors
	- search() in Homework2.java
		- Calls static methods in the different search type classes
	- Search algorithms
		- Contain their own static search() methods
		- The expand() method (in Homework2.java) actually generates the tree, while the search() methods organize the node queue

PROGRAM EXECUTION
	1. Choose the desired search algorithm in Homework2.java's search() method (under the "TESTS" comment) by commenting out the undesired search algorithms. Only 1 search algorithm should be run at a time
	2. Compile using "javac *.java" in "src" directory
	3. Run using "java Homework2" in "src" directory

PROGRAM OUTPUT
	The program prints "Output: " followed by the city names of the nodes as they are removed from the node queue and expanded. Once the search is completed, a notification is printed notifying of success or failure. Then "Solution: " is printed, followed by the calculated solution path from Alexandria to Luxor. 

ASSIGNMENT QUESTIONS
	1. For A* search, heuristic 1 (h1) and heuristic 2 (h2) both expand the same 18 nodes in the same order.

	2. Both heuristics' solutions match, which is expected since A* is optimal if its heuristic is admissible (always <= actual cost). At first glance, it seems like h2 should have better performance (should expand fewer nodes) than h1 since h2 > h1 for all cities. This means h2 is more accurate than h1 since both are admissible heuristics. From this, the result of both heuristics having equal performance is unexpected. 

	However, looking at the map, the travel costs are always much greater than the difference between h1 and h2. This means that the difference between the heuristics is trivial compared to the travel costs, and since A* uses the evaluation function f(n) = h(n) + g(n), that trivial difference has negligible influence on the value of f(n). 

	So upon further evaluation, both heuristics having equal performance is to be expected.