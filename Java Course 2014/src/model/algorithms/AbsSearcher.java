package model.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public abstract class AbsSearcher implements Searcher {
	// Data Members
	private int evaluatedNodesNum;
	private HashSet<State> closedList;
	private PriorityQueue<State> openList;
	
	
	// Methods
	public AbsSearcher() {
		evaluatedNodesNum = 0;
		closedList = new HashSet<State>();
		openList = new PriorityQueue<State>();
	}
	
	public boolean addToClosedList(State state) {
		return closedList.add(state);
	}
	
	public boolean removeFromClosedList(State state) {
		return closedList.remove(state);
	}
	
	public boolean containedInClosedList(State state) {
		return closedList.contains(state);
	}
	
	public boolean isClosedListEmpty() {
		return closedList.isEmpty();
	}
	
	public boolean addToOpenList(State state) {
		// Increment evaluated nodes counter
		evaluatedNodesNum++;
		// Add given state to open list
		return openList.add(state);
	}
	
	public State removeFromOpenList() {
		return openList.remove();
	}
	
	public boolean containedInOpenList(State state) {
		return openList.contains(state);
	}
	
	public boolean isOpenListEmpty() {
		return openList.isEmpty();
	}

	@Override
	public abstract ArrayList<Action> search(State start, State goal);

	@Override
	public int getNumOfEvaluatedNodes() {
		return evaluatedNodesNum;
	}

}
